
CREATE TABLE plateinformation(
	plate_number VARCHAR(20) PRIMARY KEY,
	license_number VARCHAR(20) UNIQUE,
	vin VARCHAR(100) UNIQUE,
	make VARCHAR(20),
	model VARCHAR(20),
	state VARCHAR(10),
	expirationdate DATE,
	isWanted INT,
	wantedescription VARCHAR(1000) DEFAULT null,
	vehiclecolor varchar(20),
	year int(11)
);

INSERT INTO plateinformation Values('8AJG146','F9445584','YV1382MS7A2512772', 'Volvo', 'XC90','CA','2019-06-03',1,'Stolen','black',2016);
INSERT INTO plateinformation Values('ZZ14670','C5215770','1G2NF52E43C305440', 'Chevy', 'Camaro','CA','2019-05-12',0,'null','red',1981);
INSERT INTO plateinformation Values('GWU2019','G2519949','1FM5K7B84FGA01501', 'Toyota', 'Camry','CA','2019-06-04',0,'null','sliver',2009);
INSERT INTO plateinformation Values('G0FRTHR','F3959118','2HGFG12958H560323', 'Ford', 'RAV4','CA','2019-05-01',0,'null','white',2000);
INSERT INTO plateinformation Values('1192447','K9915810','JTHCF5C25A5037389', 'Ford', 'Crown Victoria','CA','2018-06-23',0,'null','black',2011);
INSERT INTO plateinformation VALUES('1303557', 'A1211031', '4T1BF1FK3DU273692', 'Ford', 'f550', 'CA', '2019-08-16', '0', NULL,'white',2010);


CREATE TABLE personalinformation(
	license_number VARCHAR(20) PRIMARY KEY,
	firstname VARCHAR(100),
	middlename VARCHAR(100),
    lastname VARCHAR(100),
	phone VARCHAR (20),
    gender char (1),
    birthday DATE,
	citizen VARCHAR(20),
	crime INT
	race VARCHAR(100),
	ethnicity VARCHAR(100),
	eyecolor VARCHAR(100),
	hairColor VARCHAR(100),
	height INT,
	weight INT,
	ssn INT
	address VARCHAR(100),
	city VARCHAR(100),
    region VARCHAR(100),
    postalcode VARCHAR(100),
    country VARCHAR(100)
);

INSERT INTO personalinformation Values('F9445584', 'Brooke', 'null', 'Perry', '551-587-9160', 'F', '1952-12-03','Yes','1'，'black','African-American','black','black',155,120,731131965, '541 Elizabeth Ave', 'Santa Ana', 'CA', '92701', 'United States');
INSERT INTO personalinformation Values('C5215770', 'Amar', 'Chaddy', 'Russell', '360-989-3945', 'F', '1991-09-22','Yes','0', 'white','American','blue','brown',163,120,731546548, '29 Jennings Ave', 'Ontario', 'CA', '91758', 'United States');
INSERT INTO personalinformation Values('G2519949', 'Colby', 'null','Ross', '657-888-2976', 'F', '1974-11-07','No','0', 'yellow','Aisan','black','black',170,150,731225548, '38 Lookout Rd', 'Vacaville', 'CA', '95687', 'United States');
INSERT INTO personalinformation Values('F3959118', 'Katharine', 'Sherill','Mcgee', '507-793-4475', 'F', '1985-06-07','Visa','0', 'black','African-American','black','black',155,120,485123486, '901 Tanglewood Lane', 'San Marcos', 'CA', '92024', 'United States');
INSERT INTO personalinformation Values('K9915810', 'Dante', 'null', 'Reed', '586-350-7044', 'M', '1982-01-03','Yes','0', 'black','African-American','black','black',150,160,122459635, '138 Baker St', 'Los Angeles', 'CA', '90011', 'United States');
INSERT INTO personalinformation VALUES('A1211031', 'John', 'S', 'Spurrier', '6261234567', 'M', '1988-03-02', 'Yes', '0', 'African-American', 'black', 'black', 'black', '155', '120', '609678885', '114 Stonybrook St', 'San Francisco', 'CA', '94110', 'United States');

CREATE TABLE crime
(
	license_number VARCHAR(20) PRIMARY KEY,
	sexoffender INT,
	felonyconviction INT,
	dvcharge INT,
	dvconviction INT,
	ncicwant INT,
	weaponpermit INT,
	penalCode INT,
	descriptiontext LONGTEXT,
	commenttext LONGTEXT,
	date_Of_Occurance DATE,
	trial_Date DATE,
	conviction_Date DATE,
	location_Of_Occurance TEXT,
	outcome VARCHAR(20)
);

INSERT INTO crime VALUES('F9445584','0','1','0','0','0','0','222',
'Crime suspectclimbed in through our second-story window and stole two guitars and a purse, and kill one of the house owner by using his gun',
'Burglary and Murder', '2018-10-27', null, null, '488 Hall St. Tulare, CA, 93274', 'pending');