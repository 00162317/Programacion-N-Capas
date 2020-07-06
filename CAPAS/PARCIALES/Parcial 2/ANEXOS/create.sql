CREATE TABLE public.cat_categoria
(
    c_categoria serial,
    s_categoria character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT cat_categoria_pkey PRIMARY KEY (c_categoria)
);

CREATE TABLE public.cat_libro
(
    c_libro serial,
    s_titulo character varying(500) COLLATE pg_catalog."default",
    s_autor character varying(150) COLLATE pg_catalog."default",
    c_categoria integer,
    f_ingreso timestamp without time zone,
    b_estado boolean,
    s_isbn character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT cat_libro_pkey PRIMARY KEY (c_libro),
    CONSTRAINT fk_categoria_libro FOREIGN KEY (c_categoria)
        REFERENCES public.cat_categoria (c_categoria) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


select AVG(m.nota) as resultado 
from materiaXestudiante as m
where m.fkestudiante=1

select count(m.fkmateria) as Aprobadas
from materiaXestudiante as m
where m.fkestudiante=1 and m.nota>6


select count(m.fkmateria) as Reprobadas
from materiaXestudiante as m
where m.fkestudiante=1 and m.nota<6