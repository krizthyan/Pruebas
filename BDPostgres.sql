CREATE TABLE public.phones (
	id int4 NOT NULL,
	"number" char NULL,
	citycode char NULL,
	contrycode char NULL,
	id_user int4 NULL,
	CONSTRAINT "Phones_pkey" PRIMARY KEY (id),
	CONSTRAINT pf_phones_user FOREIGN KEY (id_user) REFERENCES public.users(id)
);
CREATE INDEX fki_fk_user_phone ON public.phones USING btree (id_user);

 alter table postgres.public.phones
  add constraint pf_phones_user
  foreign key (id_user)
  references users(id);

CREATE TABLE public.users (
	id int4 NOT NULL,
	"name" varchar NULL,
	email varchar NULL,
	"password" varchar NULL,
	created date NULL,
	modified date NULL,
	lastlogin date NULL,
	isactive varchar NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id)
);

create sequence sec_users
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
 create sequence sec_phones
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  