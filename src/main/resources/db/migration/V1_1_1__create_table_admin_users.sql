CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE  IF NOT EXISTS admin_users(id UUID NOT NULL,
                   first_name VARCHAR(255) NOT NULL,
                   last_name VARCHAR(255),
                   username VARCHAR(255) NOT NULL UNIQUE,
                   email VARCHAR(255) NOT NULL UNIQUE,
                   remember_token VARCHAR(255),
                   status BOOLEAN DEFAULT TRUE,
                   password VARCHAR(255) NOT NULL,
                    created_by                            varchar(255),
                    updated_by                            varchar(255),
                    created_at                            timestamp(6) default CURRENT_TIMESTAMP(6),
                    updated_at                            timestamp(6) default CURRENT_TIMESTAMP(6),
                   CONSTRAINT pk_user PRIMARY KEY (id)
);
insert into user_management.admin_users(id, first_name, username, email,status, password)VALUES
    ('aafc17bc-d845-48e1-b5c7-59a9a6a8a50b', 'SUPER ADMIN','super_admin','super_admin@trstorebd.com', TRUE,'$2a$10$vpJnAOAxyMbvWAuKrflWyOCVl09nWvtJW/i7dU9Er/oLXIa8faXU.');
