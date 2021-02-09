# Twitter
这是一个用来学习spring-cloud和训练代码能力的项目。目前已把spring-cloud-alibaba的整体框架搭出来了，并且加入了spring-security-oauth2，使用的授权码模式。
## 目标
模仿推特，开发出推特的主要功能。

## gateway模块
1. 服务网关（判断路径来把不同的请求分发给不同的服务，spring框架已帮我完成）
2. 全局鉴权--- 首先判断路径是否需要权限，不需要直接放行，需要则判断携带的jwt是否有效、是否有权限。 `已完成`

## oauth模块
1. 验证与授权 （spring-cloud-security-oauth2已帮我完成大部分功能）
2. Jwt自定义携带信息 `已完成`
3. 邮箱与手机的验证 `未开发`
4. 修改密码 `未开发`
5. 通过其他方式登录，如QQ、微信 `未开发`
6. 管理员控制CRUD `未开发`

## tweet模块
1. 推文 （回复与推文在结构上是一致的，所以把两者合并了）
   1. 发布推文`已完成` `未测试`
   2. 删除推文`开发中` `未测试`
   3. 发布回复`未开发`
   4. 查看详细推文（包括该推文的上下推文）`未开发`
2. 点赞
   1. 点赞推文（推文点赞数+1）`未开发`
   2. 查看该推文有哪些用户点赞`未开发`
   3. 查看用户点赞的推文`未开发`
   4. 取消点赞`未开发`
3. 转发
   1. 转发推文（推文转发数+1）`未开发`
   2. 查看该推文有哪些用户转发`未开发`
   3. 取消转发`未开发`
4. 引用
   1. 引用推文（推文引用数+1）`未开发`
   2. 查看该推文有哪些用户引用了`未开发`
   3. 删除引用推文（引用后也是一条推文，所以删除后需要删除引用表中的记录）`未开发`
   

## user模块
1. 用户详细信息的CRUD `未开发`