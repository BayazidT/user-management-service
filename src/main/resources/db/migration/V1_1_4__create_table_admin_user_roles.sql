CREATE SEQUENCE user_roles_id_sequence START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS user_roles (id INT NOT NULL,
                                          role_id INT NOT NULL,
                                          user_id UUID NOT NULL,
                                          CONSTRAINT pk_user_role PRIMARY KEY (id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES admin_users(id),
    CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES admin_roles(id)
    );
insert into user_management.user_roles(id, role_id, user_id) values (1, 1, 'aafc17bc-d845-48e1-b5c7-59a9a6a8a50b');
