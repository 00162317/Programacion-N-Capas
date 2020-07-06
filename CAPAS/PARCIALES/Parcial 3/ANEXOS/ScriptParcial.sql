create table departamento(
	idDepartamento serial Primary Key,
	nombreDepartamento	varchar(50)
);

create table municipio(
	idMunicipio serial Primary Key,
	nombreMunicipio	varchar(50),
	fkDepartamento int references departamento(idDepartamento)
);

create table usuario(
	idUsuario serial Primary Key,
	nombre varchar(25),
	apellido varchar(25),
	fechaNac date,
	fkMunicipio int references municipio(idMunicipio),
	fkDepartamento int references departamento(idDepartamento),
	Direccion varchar(100),
	nombreUser varchar(25) unique,
	contrasenia varchar(25),
	tipoUsuario	bool,
	sesion bool
);

create table materia(
	idMateria serial Primary Key,
	nombre varchar(25),
	descripcion varchar(100),
	estado bool
);

create table centroEscolar(
	idCentroEscolar serial Primary Key,
	nombre varchar(100),
	fkMunicipio int references municipio(idMunicipio),
	descripcion varchar(100),
	estado bool
);

create table estudiante(
	idEstudiante serial Primary Key,
	nombre varchar(20),
	apellido varchar(20),
	carnet varchar(9),
	fechaNac date,
	direccion varchar(100),
	fkMunicipio int references municipio(idMunicipio),
	fkDepartamento int references departamento(idDepartamento),
	telefonoFijo varchar(8),
	telefonoMovil varchar(8),
	fkCentroEscolar int references centroEscolar(idCentroEscolar),
	nombrePadre varchar(50),
	nombreMadre varchar(50)
);

create table materiaXestudiante(
	fkMateria int,
	fkEstudiante int,
	anio int,
	ciclo int,
	nota float
);

Alter table materiaXestudiante add primary key(fkMateria, fkEstudiante);
Alter table materiaXestudiante add foreign key (fkMateria) references materia(idMateria);
Alter table materiaXestudiante add foreign key (fkEstudiante) references estudiante(idEstudiante);

