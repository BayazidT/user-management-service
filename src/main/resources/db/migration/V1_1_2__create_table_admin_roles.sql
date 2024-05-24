CREATE TABLE  IF NOT EXISTS admin_roles(id INT NOT NULL,
                                       name VARCHAR(255) NOT NULL,
                                       slug VARCHAR(255),
                                       status BOOLEAN DEFAULT TRUE,
                                        created_by                            varchar(255),
                                        updated_by                            varchar(255),
                                        created_at                            timestamp(6) default CURRENT_TIMESTAMP(6),
                                        updated_at                            timestamp(6) default CURRENT_TIMESTAMP(6),
                                       CONSTRAINT pk_role PRIMARY KEY (id)
);

insert into user_management.admin_roles(id, name, slug, status) values (1, 'SUPER_ADMIN', 'super_admin', TRUE);
insert into user_management.admin_roles(id, name, slug, status) values (2, 'ADMIN', 'admin', TRUE);
insert into user_management.admin_roles(id, name, slug, status) values (3, 'SUPER_USER', 'super_user', TRUE);
insert into user_management.admin_roles(id, name, slug, status) values (4, 'USER', 'user', TRUE);
