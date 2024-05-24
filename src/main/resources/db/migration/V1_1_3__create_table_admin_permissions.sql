CREATE TABLE  IF NOT EXISTS admin_permissions(id INT NOT NULL,
                                       name VARCHAR(255) NOT NULL,
                                       slug VARCHAR(255),
                                       http_method VARCHAR(255),
                                       http_path VARCHAR(255),
                                       status BOOLEAN DEFAULT TRUE,
                                        created_by                            varchar(255),
                                        updated_by                            varchar(255),
                                        created_at                            timestamp(6) default CURRENT_TIMESTAMP(6),
                                        updated_at                            timestamp(6) default CURRENT_TIMESTAMP(6),
                                       CONSTRAINT pk_permission PRIMARY KEY (id)
);

INSERT INTO user_management.admin_permissions(id, name, slug, http_method, http_path, status) VALUES
                                                                                                  (1, 'CREATE_USER', 'create_user', 'POST', '/users', TRUE),
                                                                                                  (2, 'READ_USER', 'read_user', 'GET', '/users', TRUE),
                                                                                                  (3, 'UPDATE_USER', 'update_user', 'PUT', '/users/{id}', TRUE),
                                                                                                  (4, 'DELETE_USER', 'delete_user', 'DELETE', '/users/{id}', TRUE),

                                                                                                  (5, 'CREATE_ROLE', 'create_role', 'POST', '/roles', TRUE),
                                                                                                  (6, 'READ_ROLE', 'read_role', 'GET', '/roles', TRUE),
                                                                                                  (7, 'UPDATE_ROLE', 'update_role', 'PUT', '/roles/{id}', TRUE),
                                                                                                  (8, 'DELETE_ROLE', 'delete_role', 'DELETE', '/roles/{id}', TRUE),

                                                                                                  (9, 'CREATE_PERMISSION', 'create_permission', 'POST', '/permissions', TRUE),
                                                                                                  (10, 'READ_PERMISSION', 'read_permission', 'GET', '/permissions', TRUE),
                                                                                                  (11, 'UPDATE_PERMISSION', 'update_permission', 'PUT', '/permissions/{id}', TRUE),
                                                                                                  (12, 'DELETE_PERMISSION', 'delete_permission', 'DELETE', '/permissions/{id}', TRUE),

                                                                                                  (13, 'VIEW_DASHBOARD', 'view_dashboard', 'GET', '/dashboard', TRUE),
                                                                                                  (14, 'MANAGE_SETTINGS', 'manage_settings', 'PUT', '/settings', TRUE),
                                                                                                  (15, 'ACCESS_REPORTS', 'access_reports', 'GET', '/reports', TRUE),
                                                                                                  (16, 'VIEW_PROFILE', 'view_profile', 'GET', '/profile', TRUE),
                                                                                                  (100, 'FULL_ACCESS', 'full_access', '*', '/*', TRUE);
