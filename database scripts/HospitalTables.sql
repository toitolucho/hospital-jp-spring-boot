use hospitalDH
go

DROP TABLE Doctors; 
DROP TABLE Patients; 
DROP TABLE Hospitals;
DROP TABLE Users;


create table Users
(
	UserId			INT IDENTITY,
	UserName		VARCHAR(50) UNIQUE,
	UserPassword	VARCHAR(20),
	UserType		CHAR(1),
	CONSTRAINT PK_Users PRIMARY KEY (userId) 
)

create table Hospitals
(
	HospitalId	INT IDENTITY,
	Name		VARCHAR(200) UNIQUE,
	Description VARCHAR(max),
	CONSTRAINT PK_Hospital PRIMARY KEY (HospitalId)
)



CREATE TABLE Patients
(
	PatientId	INT IDENTITY,
	FirstName	VARCHAR(200),
	LastName	VARCHAR(200),
	Address		VARCHAR(200),
	DateOfBirth DATE,
	PictureFile VARCHAR(200),
	HospitalId	INT,
	CONSTRAINT PK_Patients PRIMARY KEY(PatientId),
	CONSTRAINT FK_Patients_Hospitals FOREIGN KEY(HospitalId) REFERENCES Hospitals(HospitalId)
)


CREATE TABLE Doctors
(
	DoctorId	INT IDENTITY,
	FirstName	VARCHAR(200),
	LastNames	VARCHAR(200),
	DateOfBirth	DATE,
	Address		VARCHAR(200),
	PictureFile VARCHAR(200),
	HospitalId	INT,
	CONSTRAINT PK_Doctors PRIMARY KEY(DoctorId),
	CONSTRAINT FK_Doctors_Hospitals FOREIGN KEY(HospitalId) REFERENCES Hospitals(HospitalId)
)
insert into Doctors values ('Rodolfo', 'Merida' , '2018-01-01','Rdolofo Villarroel 68', null,  1)
insert into Doctors values ('Alejandra', 'Rojas' , '2018-01-01','Rdolofo Villarroel 68', null, 1)
insert into Doctors values ('Romseri', 'Lopez' , '2018-01-01','Rdolofo Villarroel 68', null, 2)
insert into Doctors values ('Romelia', 'Carreño' , '2018-01-01','Rdolofo Villarroel 68', null, 2)
insert into Doctors values ('Carlos Walter', 'Baptista' , '2018-01-01','Rdolofo Villarroel 68', null, 3)
select * from Doctors


insert into Hospitals values ('Hospital de las Americas', 'Hospital de las Americas')
insert into Hospitals values ('Hospital Cristo Sol', 'risto Sol')
insert into Hospitals values ('Hospital Universitario', 'Hospital de las Americas')
select * from Hospitals

CREATE TABLE PatienteHistorial
(
	HistorialId			INT IDENTITY,
	Description			VARCHAR(MAX),
	RegistrationDate	DATETIME,
	PatientId			INT,
	CONSTRAINT PK_PatienteHistorial PRIMARY KEY (HistorialId),
	CONSTRAINT FK_PatienteHistorial_Patients FOREIGN KEY(PatientId) REFERENCES Patients(PatientId)
)



CREATE TABLE Specialities
(
	SpecialityId	INT IDENTITY,
	SpecialityName	VARCHAR(200),
	IconProfile		VARCHAR(200),
	CONSTRAINT PK_Specialities PRIMARY KEY (SpecialityId),
	CONSTRAINT U_SpecialityName UNIQUE (SpecialityName)
)


select * from doctors



--drop  table Students

--CREATE TABLE Students
--(
--	Id	INT IDENTITY,
--	name		VARCHAR(200),
--	email	VARCHAR(200),
--	dob	DATE,	
--	age int,
--	CONSTRAINT PK_Students PRIMARY KEY(Id)
	
--)


--insert into Students values ('Sanuel', 'samuel18@gmail.com', '2018-01-01',14)
--insert into Students values ('Soraya', 'soraya18@gmail.com', '2018-01-09',16)
--insert into Students values ('alejandro', 'alejandro@gmail.com', '2018-01-09',19)

select
        doctor0_.DoctorId as doctorid1_0_,
        doctor0_.Address as address2_0_,
        doctor0_.DateOfBirth as dateofbi3_0_,
        --doctor0_.hospital as hospital4_0_,
        doctor0_.LastNames as lastname5_0_,
        doctor0_.FirstName as firstnam6_0_,
        doctor0_.PictureFile as picturef7_0_ 
    from
        Doctors doctor0_