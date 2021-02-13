CREATE TABLE `sys_permission`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `parent_id`   bigint(20)   DEFAULT NULL COMMENT '父权限',
    `name`        varchar(64)  NOT NULL COMMENT '权限名称',
    `enname`      varchar(64)  NOT NULL COMMENT '权限英文名称',
    `url`         varchar(255) NOT NULL COMMENT '授权路径',
    `description` varchar(200) DEFAULT NULL COMMENT '备注',
    `created`     datetime     NOT NULL DEFAULT (NOW()),
    `updated`     datetime     NOT NULL DEFAULT (NOW()),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100
  DEFAULT CHARSET = utf8 COMMENT ='权限表';

CREATE TABLE `sys_role`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `parent_id`   bigint(20)   DEFAULT NULL COMMENT '父角色',
    `name`        varchar(64) NOT NULL COMMENT '角色名称',
    `enname`      varchar(64) NOT NULL COMMENT '角色英文名称',
    `description` varchar(200) DEFAULT NULL COMMENT '备注',
    `created`     datetime    NOT NULL DEFAULT (NOW()),
    `updated`     datetime    NOT NULL DEFAULT (NOW()),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100
  DEFAULT CHARSET = utf8 COMMENT ='角色表';

CREATE TABLE `sys_role_permission`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`       bigint(20) NOT NULL COMMENT '角色 ID',
    `permission_id` bigint(20) NOT NULL COMMENT '权限 ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100
  DEFAULT CHARSET = utf8 COMMENT ='角色权限表';

CREATE TABLE `sys_user`
(
    `id`                      bigint(20)  NOT NULL COMMENT '唯一id',
    `username`                varchar(50) NOT NULL COMMENT '用户名',
    `password`                varchar(64) NOT NULL COMMENT '密码，加密存储',
    `phone`                   varchar(20) DEFAULT NULL COMMENT '注册手机号',
    `email`                   varchar(50) DEFAULT NULL COMMENT '注册邮箱',
    `account_non_expired`     tinyint(1)  NOT NULL DEFAULT 1 COMMENT '账号是否过期',
    `account_non_locked`      tinyint(1)  NOT NULL DEFAULT 1 COMMENT '账号是否锁定',
    `credentials_non_expired` tinyint(1)  NOT NULL DEFAULT 1 COMMENT '凭证是否过期',
    `enabled`                 tinyint(1)  NOT NULL DEFAULT 1 COMMENT '账号是否可用',
    `created`                 datetime    NOT NULL DEFAULT (NOW()),
    `updated`                 datetime    NOT NULL DEFAULT (NOW()),
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`) USING BTREE,
    UNIQUE KEY `phone` (`phone`) USING BTREE,
    UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

CREATE TABLE `sys_user_role`
(
    `id`       bigint(20)  NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL COMMENT '用户 ID',
    `role_id`  bigint(20)  NOT NULL COMMENT '角色 ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100
  DEFAULT CHARSET = utf8 COMMENT ='用户角色表';