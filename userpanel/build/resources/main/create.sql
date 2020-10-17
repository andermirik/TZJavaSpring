CREATE TABLE roles ( id serial NOT NULL CONSTRAINT id_roles_pk PRIMARY KEY, NAME VARCHAR ( 20 ) NOT NULL );
ALTER TABLE roles OWNER TO postgres;
-- auto-generated definition
CREATE TABLE users (
	id serial NOT NULL CONSTRAINT id_users_pk PRIMARY KEY,
	LOGIN VARCHAR ( 50 ),
	PASSWORD VARCHAR ( 256 ),
	role_id INTEGER CONSTRAINT user_table_role_table_id_fk REFERENCES roles
);
ALTER TABLE users OWNER TO postgres;
CREATE UNIQUE INDEX user_table_login_uindex ON users(LOGIN);
INSERT INTO roles(NAME)
VALUES
	('ROLE_ADMIN');
INSERT INTO roles(NAME)
VALUES
	('ROLE_USER');