insert into sys_permission(id, parent_id, name, enname, url, description)
values (101, 0, '系统管理', 'System', '/', '超级管理员拥有所有权限');

insert into sys_permission(id, parent_id, name, enname, url, description)
values (601, 101, '发布推文', 'postTweet', '/server-tweet/tweet_POST', '用户来发布推文'),
       (602, 101, '删除推文', 'deletedTweet', '/server-tweet/tweet_DELETE', '用户删除已发布的推文');


insert into sys_role(parent_id, name, enname, description)
VALUES (0, '超级管理员', 'admin', '超级管理员拥有所有权限'),
       (0, '普通用户', 'user', '普通用户可以做普通用户该做的事');

insert into sys_role_permission(role_id, permission_id) VALUES (100, 101), (100, 601), (100, 602);
insert into sys_role_permission(role_id, permission_id) VALUES (101, 601), (101, 602);

insert into sys_user(id, username, password)
VALUES (1000000000000000001, 'admin', '$2a$10$bClI902vYPQpsxkjWKgIEOzGOYRSxh51Ro0D1gXEfI6AuHzpn2vWa');
insert into sys_user_role(user_id, role_id)
VALUES (1000000000000000001, 100);







insert into ClientDetails(appId, resourceIds, appSecret, scope, grantTypes, redirectUrl, authorities,
                          access_token_validity, refresh_token_validity, additionalInformation, autoApproveScopes)
VALUES ('zhumouren', '', '$2a$10$Ff2In2W3534/PMMLrOSa2ef9fWJnH5q92zj2aWtvwZMcTWfElNR16', '', '',
        'http://192.168.3.3:8080/oauth/code', 'authorization_code,password,refresh_token', '', '', '', '');
