# Hospital Web System Manager

This project was developed with **Angular** for the **frontend** and **JPA SPRING BOOT** for the backend using the **IDE Eclipse**
For the database implementation, **MS SERVER** was used.



## Installation
- You need to creete the database named **hospitalDH**
```SQL
CREATE DATABASE hospitalDH

```
- Run the data tables [scripts](https://github.com/toitolucho/hospital-jp-spring-boot/blob/main/database%20scripts/HospitalTables.sql "Data Tables scripts") to create all the tables
```SQL

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
```
- Run the Script with the initial data.
- Configure the application.properties for database connection with JPA SPRING BOOT.
- Run the backpend API.
- 


## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
