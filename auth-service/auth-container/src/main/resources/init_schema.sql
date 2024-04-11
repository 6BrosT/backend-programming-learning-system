DROP SCHEMA IF EXISTS "auth_service" CASCADE;

CREATE SCHEMA "auth_service";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE auth_service.main_user (
	id uuid NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    dob TIMESTAMP WITH TIME ZONE,
	firstname character varying,
	lastname character varying,
	phone character varying,
	address character varying,
	avatar_url text,
	refresh_token character varying,
	last_ip character varying,
	last_login TIMESTAMP WITH TIME ZONE,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	is_deleted boolean NOT NULL DEFAULT false,
	PRIMARY KEY ("id")
);

CREATE TABLE auth_service.main_organization (
	id uuid NOT NULL,
	description text,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	email character varying COLLATE pg_catalog."default" NOT NULL,
	phone character varying,
	address character varying,
	api_key character varying,
	moodle_url text,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	updated_by uuid,
	created_by uuid,
	is_deleted boolean NOT NULL DEFAULT false,
	PRIMARY KEY ("id")
);

CREATE TABLE auth_service.role (
	id uuid NOT NULL,
	organization_id uuid NOT NULL,
	description text,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	updated_by uuid,
	created_by uuid,
	PRIMARY KEY ("id")
);

CREATE TABLE auth_service.user_role (
	id uuid NOT NULL,
	user_id uuid NOT NULL,
	role_id uuid NOT NULL,
	is_active boolean NOT NULL DEFAULT true,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	updated_by uuid,
	created_by uuid,
	PRIMARY KEY ("id")
);

ALTER TABLE auth_service.role
    ADD CONSTRAINT "role_fk1" FOREIGN KEY (organization_id)
    REFERENCES "auth_service".main_organization (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;

ALTER TABLE auth_service.user_role
    ADD CONSTRAINT "user_role_fk1" FOREIGN KEY (user_id)
    REFERENCES auth_service.main_user (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;

ALTER TABLE auth_service.user_role
    ADD CONSTRAINT "user_role_fk2" FOREIGN KEY (role_id)
    REFERENCES auth_service.role (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;