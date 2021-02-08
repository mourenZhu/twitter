create table tweet
(
    `id`          bigint(20) NOT NULL COMMENT 'id',
    `user_id`     bigint(20) NOT NULL COMMENT '用户唯一id',
    `content`     varchar(300) COMMENT '推文内容',
    `pics`        varchar(500)        DEFAULT NULL COMMENT '图片绝对路径',
    `num_likes`   int UNSIGNED        DEFAULT 0 COMMENT '推文点赞数',
    `num_replies` int UNSIGNED        DEFAULT 0 COMMENT '推文回复数',
    `num_quote`   int UNSIGNED        DEFAULT 0 COMMENT '推文引用数',
    `num_forward` INT UNSIGNED        DEFAULT 0 COMMENT '推文转发数',
    `created`     datetime   NOT NULL DEFAULT (NOW()) COMMENT '推文创建时间',
    `updated`     datetime   NOT NULL DEFAULT (NOW()) COMMENT '推文更新时间',
    `is_delete`   TINYINT UNSIGNED    DEFAULT 0 COMMENT '是否删除，0是没有删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='推文表';

create table tweet_reply
(
    `id`          bigint(20) NOT NULL COMMENT 'id',
    `tweet_id`    bigint(20) NOT NULL COMMENT '父推文id',
    `user_id`     bigint(20) NOT NULL COMMENT '用户唯一id',
    `content`     varchar(300) COMMENT '回复内容',
    `pics`        varchar(500)        DEFAULT NULL COMMENT '图片绝对路径',
    `num_likes`   int UNSIGNED        DEFAULT 0 COMMENT '回复点赞数',
    `num_replies` int UNSIGNED        DEFAULT 0 COMMENT '回复回复数',
    `num_quote`   int UNSIGNED        DEFAULT 0 COMMENT '回复引用数',
    `num_forward` INT UNSIGNED        DEFAULT 0 COMMENT '回复转发数',
    `created`     datetime   NOT NULL DEFAULT (NOW()) COMMENT '回复创建时间',
    `updated`     datetime   NOT NULL DEFAULT (NOW()) COMMENT '回复更新时间',
    PRIMARY KEY (`id`),
    KEY (`tweet_id`),
    KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='推文回复表';

create table reply_path
(
    `parent_id` bigint(20) NOT NULL COMMENT '父评论id',
    `child_id`  bigint(20) NOT NULL COMMENT '子评论id',
    PRIMARY KEY (`parent_id`, `child_id`),
    KEY (`parent_id`),
    KEY (`child_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='回复闭包路径表';

create table tweet_like
(
    `tweet_id` bigint(20) NOT NULL COMMENT '推文id',
    `user_id`  bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`  datetime   NOT NULL DEFAULT (NOW()) COMMENT '点赞创建时间',
    PRIMARY KEY (`tweet_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='推文点赞表';

create table reply_like
(
    `reply_id` bigint(20) NOT NULL COMMENT '回复id',
    `user_id`  bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`  datetime   NOT NULL DEFAULT (NOW()) COMMENT '点赞创建时间',
    PRIMARY KEY (`reply_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='回复点赞表';

create table tweet_quote
(
    `parent_id` bigint(20) NOT NULL COMMENT '父推文id',
    `child_id`  bigint(20) NOT NULL COMMENT '子推文id',
    `user_id`   bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`   datetime   NOT NULL DEFAULT (NOW()) COMMENT '引用创建时间',
    PRIMARY KEY (`parent_id`, `child_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='推文引用表';

create table reply_quote
(
    `parent_id` bigint(20) NOT NULL COMMENT '父回复id',
    `child_id`  bigint(20) NOT NULL COMMENT '子推文id',
    `user_id`   bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`   datetime   NOT NULL DEFAULT (NOW()) COMMENT '引用创建时间',
    PRIMARY KEY (`parent_id`, `child_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='回复引用表';

create table tweet_forward
(
    `tweet_id` bigint(20) NOT NULL COMMENT '推文id',
    `user_id`  bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`  datetime   NOT NULL DEFAULT (NOW()) COMMENT '引用创建时间',
    PRIMARY KEY (`tweet_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='推文转发表';

create table reply_forward
(
    `reply_id` bigint(20) NOT NULL COMMENT '推文id',
    `user_id`  bigint(20) NOT NULL COMMENT '用户唯一id',
    `created`  datetime   NOT NULL DEFAULT (NOW()) COMMENT '引用创建时间',
    PRIMARY KEY (`reply_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='回复转发表';
