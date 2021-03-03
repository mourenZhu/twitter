create table tweet
(
    `id`          bigint(20) NOT NULL COMMENT 'id',
    `user_id`     bigint(20) NOT NULL COMMENT '用户唯一id',
    `content`     varchar(300) COMMENT '推文内容',
    `pics`        JSON        DEFAULT NULL COMMENT '图片绝对路径',
    `num_likes`   int UNSIGNED        DEFAULT 0 COMMENT '推文点赞数',
    `num_replies` int UNSIGNED        DEFAULT 0 COMMENT '推文回复数',
    `num_quote`   int UNSIGNED        DEFAULT 0 COMMENT '推文引用数',
    `num_forward` INT UNSIGNED        DEFAULT 0 COMMENT '推文转发数',
    `created`     datetime   NOT NULL DEFAULT (NOW()) COMMENT '推文创建时间',
    `updated`     datetime   NOT NULL DEFAULT (NOW()) COMMENT '推文更新时间',
    `is_deleted`   TINYINT UNSIGNED    DEFAULT 0 COMMENT '是否删除，0是没有删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='推文表';


create table parent_child_tweet
(
    `parent_id` bigint(20) NOT NULL COMMENT '父评论id',
    `child_id`  bigint(20) NOT NULL COMMENT '子评论id',
    `level` int NOT NULL COMMENT '回复层级',
    `is_root` TINYINT UNSIGNED    DEFAULT 0 COMMENT '是否为推文，1是推文，0是回复',
    `is_deleted`   TINYINT UNSIGNED    DEFAULT 0 COMMENT '是否删除，0是没有删除',
    PRIMARY KEY (`parent_id`, `child_id`),
    KEY (`parent_id`),
    KEY (`child_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='推文闭包表';


create table tweet_like
(
    `tweet_id` bigint(20) NOT NULL COMMENT '推文id',
    `user_id`  bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`  datetime   NOT NULL DEFAULT (NOW()) COMMENT '点赞创建时间',
    `is_deleted`   TINYINT UNSIGNED    DEFAULT 0 COMMENT '是否删除，0是没有删除',
    PRIMARY KEY (`tweet_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='推文点赞表';



create table tweet_quote
(
    `parent_id` bigint(20) NOT NULL COMMENT '父推文id',
    `child_id`  bigint(20) NOT NULL COMMENT '子推文id',
    `user_id`   bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`   datetime   NOT NULL DEFAULT (NOW()) COMMENT '引用创建时间',
    `is_deleted`   TINYINT UNSIGNED    DEFAULT 0 COMMENT '是否删除，0是没有删除',
    PRIMARY KEY (`parent_id`, `child_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='推文引用表';



create table tweet_forward
(
    `tweet_id` bigint(20) NOT NULL COMMENT '推文id',
    `user_id`  bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`  datetime   NOT NULL DEFAULT (NOW()) COMMENT '引用创建时间',
    `is_deleted`   TINYINT UNSIGNED    DEFAULT 0 COMMENT '是否删除，0是没有删除',
    PRIMARY KEY (`tweet_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='推文转发表';


