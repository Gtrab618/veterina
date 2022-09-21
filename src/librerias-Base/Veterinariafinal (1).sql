----------------CREACION DE TABLA DE PERSONA------------------------
CREATE TABLE PERSONA(
per_id serial,
per_cedula character varying(10) UNIQUE,
per_nombre character varying(50),
per_apellido1 character varying(50),
per_apellido2 character varying(50),
per_estado character varying(1),
CONSTRAINT PK_PERSONA PRIMARY KEY (per_id)
);

----------------CREACION DE TABLA DE PERSONAL------------------------
CREATE TABLE PERSONAL(
perl_id serial,
perl_usuario character varying(15),
perl_contrasena character varying(15),
perl_acceso character varying(15),
perl_estado character varying(1),
per_id integer,
CONSTRAINT PK_PERSONAL PRIMARY KEY (perl_id),
CONSTRAINT fk_personauno FOREIGN KEY (per_id) REFERENCES PERSONA (per_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

----------------CREACION DE TABLA DE CLIENTE------------------------
CREATE TABLE CLIENTE(
cli_id serial,
cli_telefono character varying(10),
cli_direccion character varying(150),
per_id integer,
CONSTRAINT PK_CLIENTE PRIMARY KEY (cli_id),
CONSTRAINT fk_personados FOREIGN KEY (per_id) REFERENCES PERSONA (per_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);


----------------CREACION DE TABLA DE MASCOTA------------------------
CREATE TABLE MASCOTA(
mas_id serial,
mas_nombremascota character varying(50),
mas_sexo character varying(30),
mas_raza character varying(30),
mas_especie character varying(30),
mas_esterilizado boolean,
mas_fechanac Date,
mas_foto bytea,
mas_estado character varying(1),
cli_id Integer,
CONSTRAINT PK_MASCOTA PRIMARY KEY (mas_id),
CONSTRAINT fk_cliente FOREIGN KEY (cli_id) REFERENCES CLIENTE (cli_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

----------------CREACION DE TABLA DE GROOMING------------------------
CREATE TABLE GROOMING(
gro_id serial,
gro_tipocorte character varying(20),
gro_precio FLOAT,
gro_fecha Date,
gro_descripcion character varying(500),
mas_id Integer,
CONSTRAINT PK_GROOMING PRIMARY KEY (gro_id),
CONSTRAINT fk_mascota FOREIGN KEY (mas_id) REFERENCES MASCOTA (mas_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

----------------CREACION DE TABLA DE CONSULTA------------------------
CREATE TABLE CONSULTA(
con_id serial,
con_motivos character varying(1000),
con_observaciones character varying(1000),
con_tratamiento character varying(1000),    
con_frecuenciaCardiaca int,
con_frecuenciaRespiratoria int,
con_hidratacion int,
con_temperatura double precision,
con_peso double precision,
con_llenadoCapilar character varying(10),
con_muscosa character varying(10),
con_fecha Date,
mas_id Integer,
CONSTRAINT PK_CONSULTA PRIMARY KEY (con_id),
CONSTRAINT fk_mascotados FOREIGN KEY (mas_id) REFERENCES MASCOTA (mas_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);



----------------CREACION DE TABLA DE MEDICAMENTOS------------------------
CREATE TABLE MEDICAMENTOS(
med_id serial,
med_nombre character varying(50),
med_fechaelaborado Date,
med_fechacaducidad Date,
med_tipo character varying(60),
mas_estado character varying(1),
CONSTRAINT PK_MEDICAMENTOS PRIMARY KEY (med_id)
);
----------------CREACION DE TABLA DE CONSULTA-MEDICAMENTOS------------------------
--CREATE TABLE DETALLEREPORTEMEDICINA(
--det_id serial,
--med_id Integer,
--rep_id Integer,
--CONSTRAINT PK_DETALLEREPORTEMEDICINA PRIMARY KEY (det_id),
--CONSTRAINT fk_reporte FOREIGN KEY (rep_id) REFERENCES REPORTE (rep_id) ON UPDATE NO ACTION ON DELETE NO ACTION,
--CONSTRAINT fk_medicamento FOREIGN KEY (med_id) REFERENCES MEDICAMENTOS (med_id) ON UPDATE NO ACTION ON DELETE NO ACTION
--);

--------------------------CREACION DE PERSONA--------------------------
INSERT INTO persona( per_cedula, per_nombre,  per_apellido1, per_apellido2, per_estado)
    VALUES ( '0150709806', 'Raul', 'Luna', 'Diaz', '1');

INSERT INTO persona( per_cedula, per_nombre, per_apellido1, per_apellido2, per_estado)
    VALUES ('0180605809', 'Juan', 'Perez', 'Sanchez', '1');

INSERT INTO persona( per_cedula, per_nombre, per_apellido1, per_apellido2, per_estado)
    VALUES ('0184598712', 'Carla', 'Leon', 'Flor', '1');    
--------------------------CREACION DE PERSONAL--------------------------
INSERT INTO personal(perl_usuario, perl_contrasena, perl_acceso, perl_estado, per_id)
    VALUES ('admin', '1234', 'total', '1',  1);

INSERT INTO personal(perl_usuario, perl_contrasena, perl_acceso, perl_estado, per_id)
    VALUES ('visita', '4321', 'parcial', '1',  2);

--------------------------CREACION DE CLIENTE--------------------------
INSERT INTO cliente( cli_telefono, cli_direccion, per_id)
    VALUES ( '0998761253', 'Miraflores', 3);


 
 