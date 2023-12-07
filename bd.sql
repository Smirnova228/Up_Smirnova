-- Table: public.client

-- DROP TABLE IF EXISTS public.client;

CREATE TABLE IF NOT EXISTS public.client
(
    id integer NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default",
    middle_name character varying(255) COLLATE pg_catalog."default",
    phone character varying(255) COLLATE pg_catalog."default",
    second_name character varying(255) COLLATE pg_catalog."default",
    recipe_id bigint,
    CONSTRAINT client_pkey PRIMARY KEY (id),
    CONSTRAINT fk9xif7wv6k8dxca4jxdas3wnml FOREIGN KEY (recipe_id)
        REFERENCES public.recipe (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.client
    OWNER to postgres;
-- Table: public.client_product

-- DROP TABLE IF EXISTS public.client_product;

CREATE TABLE IF NOT EXISTS public.client_product
(
    product_id bigint NOT NULL,
    client_id integer NOT NULL,
    CONSTRAINT fkgqd72o2a9wa923a2s0757b5c0 FOREIGN KEY (client_id)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkgromm4ojwcglhf5c70suhl3nj FOREIGN KEY (product_id)
        REFERENCES public.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.client_product
    OWNER to postgres;
-- Table: public.employee

-- DROP TABLE IF EXISTS public.employee;

CREATE TABLE IF NOT EXISTS public.employee
(
    id bigint NOT NULL,
    email_employee character varying(255) COLLATE pg_catalog."default",
    first_name_employee character varying(255) COLLATE pg_catalog."default",
    middle_name_employee character varying(255) COLLATE pg_catalog."default",
    password_employee character varying(255) COLLATE pg_catalog."default",
    second_name_employee character varying(255) COLLATE pg_catalog."default",
    employee_position_id bigint,
    CONSTRAINT employee_pkey PRIMARY KEY (id),
    CONSTRAINT fkkft5wjvwfuqgkuuh6tces2pdr FOREIGN KEY (employee_position_id)
        REFERENCES public.employee_position (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employee
    OWNER to postgres;
-- Table: public.employee_position

-- DROP TABLE IF EXISTS public.employee_position;

CREATE TABLE IF NOT EXISTS public.employee_position
(
    id bigint NOT NULL,
    name_employee_position character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT employee_position_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employee_position
    OWNER to postgres; 
-- Table: public.model_user

-- DROP TABLE IF EXISTS public.model_user;

CREATE TABLE IF NOT EXISTS public.model_user
(
    id_user bigint NOT NULL DEFAULT nextval('model_user_id_user_seq'::regclass),
    active boolean NOT NULL,
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT model_user_pkey PRIMARY KEY (id_user)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.model_user
    OWNER to postgres;
-- Table: public.point

-- DROP TABLE IF EXISTS public.point;

CREATE TABLE IF NOT EXISTS public.point
(
    id bigint NOT NULL,
    address character varying(255) COLLATE pg_catalog."default",
    name_point character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT point_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.point
    OWNER to postgres;
-- Table: public.product

-- DROP TABLE IF EXISTS public.product;

CREATE TABLE IF NOT EXISTS public.product
(
    id bigint NOT NULL,
    count integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    price integer NOT NULL,
    point_id bigint,
    type_medicine_id bigint,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT fkipp8apxuvdtrf3mk959t16ipu FOREIGN KEY (point_id)
        REFERENCES public.point (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fksad8wla5qt8kewr70jm2mt9yw FOREIGN KEY (type_medicine_id)
        REFERENCES public.type_medicine (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;
-- Table: public.product_client

-- DROP TABLE IF EXISTS public.product_client;

CREATE TABLE IF NOT EXISTS public.product_client
(
    client_id integer NOT NULL,
    product_id bigint NOT NULL,
    CONSTRAINT fk1fheea2rwcidmnbde8tnj5k3f FOREIGN KEY (client_id)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkgak7fgf5y4ipvsujmtd6pk1iu FOREIGN KEY (product_id)
        REFERENCES public.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product_client
    OWNER to postgres; 
-- Table: public.recipe

-- DROP TABLE IF EXISTS public.recipe;

CREATE TABLE IF NOT EXISTS public.recipe
(
    id bigint NOT NULL,
    number_recipe character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT recipe_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.recipe
    OWNER to postgres; 
-- Table: public.type_medicine

-- DROP TABLE IF EXISTS public.type_medicine;

CREATE TABLE IF NOT EXISTS public.type_medicine
(
    id bigint NOT NULL,
    name_type_medicine character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT type_medicine_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.type_medicine
    OWNER to postgres;
-- Table: public.user_role

-- DROP TABLE IF EXISTS public.user_role;

CREATE TABLE IF NOT EXISTS public.user_role
(
    user_id bigint NOT NULL,
    roles character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT fkhnk3nw6rsvkly3ww7umdq7ys1 FOREIGN KEY (user_id)
        REFERENCES public.model_user (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_role
    OWNER to postgres
