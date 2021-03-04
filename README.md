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
    1. 发布推文`已完成` `已测试`
    2. 删除推文`已完成` `已测试`
    3. 发布回复`已完成` `已测试`
    4. 查看详细推文（包括该推文的上下推文）`已完成` `已测试`
    5. 查看某个用户发布的推文 `已完成` `已测试`
    6. 查看某个用户发布的status `已完成` `已测试`
    7. 获取单个status `已完成` `已测试`
    8. 获取 list status `已完成` `已测试`
    8. 获取 list user status id `已完成` `已测试`
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

## timeline模块

主要功能是用redis缓存用户数据。 一般情况下，用户获得的数据都在这里，用redis可以大幅提高用户获取信息的速度。 （设置过期策略后，用户如何高效获取已过期的status）

1. 用户时间线--user timeline （每个用户自己主页的时间线）
    1. 构建用户的时间线 `已完成` `已测试`

   x. 如果用户一段时间未登录，则删除用户的时间线

2. 主页时间线--home timeline （每个用户自己关注的人的时间线）
    1. 构建用户的home timeline `未开发`

3. 用户发布的所有status（这里存储具体的status对象）
    1. 存入status `已完成` `已测试`
    2. 存入status list `已完成` `已测试`
    3. 查询 status `已完成` `已测试`
    4. 查询 list status `已完成` `已测试`
    5. 查询 status vo `已完成` `已测试`
    6. 查询 list status vo `已完成` `已测试`
    7. 查询 status tree `未开发`
    8. 查询 status vo tree `开发中`

4. 每个用户的具体对象
    1. 存入user `已完成` `已测试`
    2. 获取user `已完成` `已测试`
    3. 获取username `已完成` `已测试`

## user模块

1. 用户详细信息的CRUD
    1. 存入 detailUser `已完成` `已测试`
    2. 查询 detailUser `已完成` `已测试`
    3. 修改 detailUser `已完成` `已测试`

## 参考资料

1. [如何设计一个twitter](<https://www.youtube.com/watch?v=wYk0xPP_P_8>)
2. [推文在mysql中存储方式](<https://nehajirafe.medium.com/data-modeling-designing-facebook-style-comments-with-sql-4cf9e81eb164>)
3. [用redis简单实现twitter](<https://redis.io/topics/twitter-clone>)
4. [retiws中关于user和status的小分析](<http://www.blogjava.net/yongboy/archive/2011/04/06/347672.html>)