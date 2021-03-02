create table detail_user
(
    `id`           bigint(20)  NOT NULL COMMENT '用户唯一id',
    `nickname`     varchar(15) NOT NULL COMMENT '用户昵称',
    `photo`        varchar(50) COMMENT '用户头像路径',
    `header_photo` varchar(50) COMMENT '用户顶部展示照片路径',
    `about`        varchar(50) COMMENT '用户简介',
    `website`      varchar(30) COMMENT '用户网站',
    `location`     varchar(30) COMMENT '用户地址',
    `birthday`     date COMMENT '出生日期',
    `following`    int COMMENT '关注数量',
    `follows`      int COMMENT '粉丝数量',
    `created`      datetime    NOT NULL DEFAULT (NOW()) COMMENT '用户详细信息创建时间',
    `updated`      datetime    NOT NULL DEFAULT (NOW()) COMMENT '用户详细信息更新时间',
    PRIMARY KEY ('id')
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户细节表';

create table user_follows
(
    `user_id`    bigint(20) NOT NULL COMMENT '用户id',
    `follows_id` bigint(20) NOT NULL COMMENT '关注者id',
    `created`    datetime   NOT NULL DEFAULT (NOW()) COMMENT '用户关注创建时间',
    PRIMARY KEY (`user_id`, `follows_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户关注表';