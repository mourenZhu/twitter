insert into sys_permission(id, parent_id, name, enname, url, description)
values (101, 0, '系统管理', 'System', '/', '超级管理员拥有所有权限');

insert into sys_permission(id, parent_id, name, enname, url, description)
values (701, 101, '创建详细用户信息', 'postDetailUser', '/server-user/detail_POST', '用户创建后，需要再创建详细的用户信息'),
       (702, 101, '修改详细用户信息', 'putDetailUser', '/server-user/detail_PUT', '用户用来修改详细信息');

insert into sys_permission(id, parent_id, name, enname, url, description)
values (801, 101, '发布推文', 'postTweet', '/server-tweet/tweet_POST', '用户来发布推文'),
       (802, 101, '删除推文', 'deleteTweet', '/server-tweet/tweet_DELETE', '用户删除已发布的推文'),
       (803, 101, '回复推文', 'replyTweet', '/server-tweet/tweet/reply_POST', '用户回复推文'),
       (804, 101, '点赞推文', 'postLike', '/server-tweet/tweet/like_POST', '用户点赞推文'),
       (805, 101, '取消点赞', 'deleteLike', '/server-tweet/tweet/like_DELETE', '用户取消点赞'),
       (806, 101, '转发推文', 'postForward', '/server-tweet/tweet/forward_POST', '用户转发推文'),
       (807, 101, '取消转发', 'deleteForward', '/server-tweet/tweet/forward_DELETE', '用户取消转发');



insert into sys_role(id, parent_id, name, enname, description)
VALUES (100, 0, '超级管理员', 'admin', '超级管理员拥有所有权限'),
       (101, 0, '普通用户', 'user', '普通用户可以做普通用户该做的事');

insert into sys_role_permission(role_id, permission_id)
VALUES (100, 101),
       (100, 701),
       (100, 702),
       (100, 801),
       (100, 802),
       (100, 803),
       (100, 804),
       (100, 805),
       (100, 806),
       (100, 807);
insert into sys_role_permission(role_id, permission_id)
VALUES (101, 701),
       (101, 702),
       (101, 801),
       (101, 802),
       (101, 803),
       (101, 804),
       (101, 805),
       (101, 806),
       (101, 807);

insert into sys_user(id, username, password)
VALUES (1000000000000000001, 'admin', '$2a$10$bClI902vYPQpsxkjWKgIEOzGOYRSxh51Ro0D1gXEfI6AuHzpn2vWa');
insert into sys_user_role(user_id, role_id)
VALUES (1000000000000000001, 100);

insert into sys_user(id, username, password)
VALUES (1000000000000000101, 'user', '$2a$10$5kwurygUmtfXvb73ODwr7ebe7d6Y5XRTk1s1pTgDSjUDud5BYcGdS');
insert into sys_user_role(user_id, role_id)
VALUES (1000000000000000101, 101);

insert into sys_user(id, username, password)
VALUES (1000000000000000102, 'test', '$2a$10$OfnckvTv0AgKRAH.6gJNG.ykcUITpS006noGhhLJnMBIW96S.bVjG');
insert into sys_user_role(user_id, role_id)
VALUES (1000000000000000102, 101);

insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types,
                                 web_server_redirect_uri)
VALUES ('zhumouren', '', '$2a$10$Ff2In2W3534/PMMLrOSa2ef9fWJnH5q92zj2aWtvwZMcTWfElNR16', 'all',
        'authorization_code,password,refresh_token',
        'http://192.168.3.3:8080/oauth/code');
