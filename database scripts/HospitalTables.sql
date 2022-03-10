use hospitalDH
go

DROP TABLE Doctors; 
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


CREATE TABLE Doctors
(
	DoctorId	INT IDENTITY,
	Names		VARCHAR(200),
	LastNames	VARCHAR(200),
	DateOfBirth	DATE,
	Adress		VARCHAR(200),
	PictureFile VARCHAR(200),
	HospitalId	INT,
	CONSTRAINT PK_Doctors PRIMARY KEY(DoctorId),
	CONSTRAINT FK_Doctors_Hospitals FOREIGN KEY(HospitalId) REFERENCES Hospitals(HospitalId)
)


CREATE TABLE Students
(
	Id	INT IDENTITY,
	name		VARCHAR(200),
	email	VARCHAR(200),
	dob	DATE,	
	CONSTRAINT PK_Doctors PRIMARY KEY(Id)
	
)


insert into Students values ('Sanuel', 'samuel18@gmail.com', '2018-01-01')
insert into Students values ('Soraya', 'soraya18@gmail.com', '2018-01-09')


select * from Students