CREATE TABLE
    IF NOT EXISTS role_permissions(id BIGINT NOT NULL,
                              role_id    INT not null,
                              permission_id    INT not null,
                              CONSTRAINT pk_role_permission PRIMARY KEY (id),
                              CONSTRAINT role_id_fk
                              FOREIGN KEY (role_id) REFERENCES admin_roles(id),
                              CONSTRAINT permission_id_fk
                              FOREIGN KEY (permission_id) REFERENCES admin_permissions(id)
);
-- Give full access to the super admin
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (1, 1, 100);
--Give almost full access to the admin
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (2, 2, 1);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (3, 2, 2);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (4, 2, 3);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (5, 2, 4);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (6, 2, 13);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (7, 2, 14);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (8, 2, 15);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (9, 2, 16);
--Giving user related access to super_user
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (10, 3, 1);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (11, 3, 2);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (12, 3, 3);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (13, 3, 4);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (14, 3, 13);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (15, 3, 15);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (16, 3, 16);
--Giving just view and minor access to the normal user
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (17, 4, 13);
insert into user_management.role_permissions(id, role_id, permission_id) VALUES (18, 4, 16);