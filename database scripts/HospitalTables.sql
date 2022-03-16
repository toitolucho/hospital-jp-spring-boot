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
