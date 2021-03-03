package cn.zhumouren.twitter.cloud.user.controller;


import cn.zhumouren.twitter.cloud.constant.exception.UserNotExistException;
import cn.zhumouren.twitter.cloud.constant.result.annotation.ResponseResultBody;
import cn.zhumouren.twitter.cloud.constant.utils.jwt.JwtUtils;
import cn.zhumouren.twitter.cloud.user.entity.DetailUser;
import cn.zhumouren.twitter.cloud.user.service.IDetailUserService;
import cn.zhumouren.twitter.cloud.user.vo.DetailUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户细节表 前端控制器
 * </p>
 *
 * @author zhumouren
 * @since 2021-02-08
 */
@RestController
@RequestMapping("/user")
@ResponseResultBody
public class DetailUserController {

    @Autowired
    private IDetailUserService detailUserService;

    @PostMapping("/detail")
    public boolean postDetailUser(@RequestBody DetailUser detailUser,
                                  @RequestHeader("access_token") String accessToken) {
        Long uid = JwtUtils.getLongByString(accessToken, "uid");
        detailUser.setId(uid);
        return detailUserService.save(detailUser);
    }

    @GetMapping("/{userId}")
    public DetailUserVO getDetailUserVO(@PathVariable("userId") String userId) throws UserNotExistException {
        Long uid = Long.valueOf(userId);
        return detailUserService.getDetailUserVO(uid);
    }

    @PutMapping("/detail")
    public boolean putDetailUser(@RequestBody DetailUserVO detailUserVO,
                                 @RequestHeader("access_token") String accessToken){
        Long uid = JwtUtils.getLongByString(accessToken, "uid");
        detailUserVO.setId(uid);
        return detailUserService.updateDetailUser(detailUserVO);
    }

}
