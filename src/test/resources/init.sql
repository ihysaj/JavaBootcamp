create table coin(
    id      serial         primary key,
    country varchar(2)     not null,
    value   numeric(10, 4) not null
);

create table country(
     code       varchar(2)     primary key not null,
     description   varchar(50) not null
);

ALTER TABLE COIN
    ADD constraint country_fkey foreign key(country) REFERENCES country(code) ON UPDATE CASCADE ON DELETE CASCADE;


INSERT INTO public.country (code, description) VALUES ('IT', 'Italy');
INSERT INTO public.country (code, description) VALUES ('US', 'United States');
INSERT INTO public.country (code, description) VALUES ('AL', 'Albania');


INSERT INTO public.coin (id, country, value) VALUES (1, 'IT', 0.0100);
INSERT INTO public.coin (id, country, value) VALUES (2, 'IT', 0.0200);
INSERT INTO public.coin (id, country, value) VALUES (3, 'IT', 0.0500);
INSERT INTO public.coin (id, country, value) VALUES (4, 'IT', 0.1000);
INSERT INTO public.coin (id, country, value) VALUES (5, 'IT', 0.2000);
INSERT INTO public.coin (id, country, value) VALUES (6, 'IT', 0.5000);
INSERT INTO public.coin (id, country, value) VALUES (7, 'IT', 1.0000);
INSERT INTO public.coin (id, country, value) VALUES (8, 'IT', 2.0000);
INSERT INTO public.coin (id, country, value) VALUES (9, 'US', 0.0100);
INSERT INTO public.coin (id, country, value) VALUES (10, 'US', 0.0500);
INSERT INTO public.coin (id, country, value) VALUES (11, 'US', 0.1000);
INSERT INTO public.coin (id, country, value) VALUES (12, 'US', 0.2500);
INSERT INTO public.coin (id, country, value) VALUES (13, 'US', 1.0000);
INSERT INTO public.coin (id, country, value) VALUES (14, 'AL', 1.0000);
INSERT INTO public.coin (id, country, value) VALUES (15, 'AL', 5.0000);
INSERT INTO public.coin (id, country, value) VALUES (16, 'AL', 10.0000);
INSERT INTO public.coin (id, country, value) VALUES (17, 'AL', 20.0000);
INSERT INTO public.coin (id, country, value) VALUES (18, 'AL', 50.0000);
INSERT INTO public.coin (id, country, value) VALUES (19, 'AL', 100.0000);
