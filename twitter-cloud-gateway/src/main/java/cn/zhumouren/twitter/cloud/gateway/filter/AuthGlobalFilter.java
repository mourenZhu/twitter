package cn.zhumouren.twitter.cloud.gateway.filter;


import cn.zhumouren.twitter.cloud.gateway.service.IOauthPermissionService;
import cn.zhumouren.twitter.cloud.gateway.utils.AuthoritiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private IOauthPermissionService permissionService;

    /**
     * 全局权限拦截
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getPath() + "_" + exchange.getRequest().getMethod();

        String nowPermission = permissionService.getPermissionByPath(path);

        String token = exchange.getRequest().getHeaders().getFirst("access_token");

        return unifyAuthenticationRedirection(token, nowPermission, exchange, chain);
    }

    /**
     * 统一判断用户携带的token是否有权限访问资源
     *
     * @param token
     * @param nowPermission
     * @param exchange
     * @return
     */
    private Mono<Void> unifyAuthenticationRedirection(String token, String nowPermission, ServerWebExchange exchange, GatewayFilterChain chain) {

        if (nowPermission == null || "".equals(nowPermission)) {
            return chain.filter(exchange);
        }

        if (AuthoritiesUtils.isSignature(token) && AuthoritiesUtils.isExp(token) && AuthoritiesUtils.isAuthorities(token, nowPermission)) {
            return chain.filter(exchange);
        } else {
            //没有权限
            return httpRedirection(HttpStatus.UNAUTHORIZED, exchange);
        }


    }

    /**
     * token无权限，跳转去无权限报错接口
     *
     * @param httpStatus
     * @param exchange
     * @return
     */
    private Mono<Void> httpRedirection(HttpStatus httpStatus, ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);


        if (httpStatus.value() == HttpStatus.FORBIDDEN.value()) {
            response.getHeaders().set("Location", "/error?state=403");
        }

        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
