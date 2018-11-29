
CREATE TABLE plateinformation(
	plate_number VARCHAR(20) PRIMARY KEY,
	license_number VARCHAR(20) UNIQUE,
	vin VARCHAR(100) UNIQUE,
	make VARCHAR(20),
	model VARCHAR(20),
	state VARCHAR(10),
	expirationdate DATE,
	isWanted INT,
	wantedescription VARCHAR(1000) DEFAULT null
);

INSERT INTO plateinformation Values('6HCM166','F9445584','YV1382MS7A2512772', 'Nissan', 'Juke','CA','2019-06-03',1,'Stolen');
INSERT INTO plateinformation Values('SCRWOIL','C5215770','1G2NF52E43C305440', 'Nissan', 'Leaf','CA','2019-05-12',0,'null');
INSERT INTO plateinformation Values('GWU2019','G2519949','1FM5K7B84FGA01501', 'Toyota', 'Corolla','CA','2019-06-04',0,'null');
INSERT INTO plateinformation Values('ETALLIC','F3959118','2HGFG12958H560323', 'Toyota', 'RAV4','CA','2019-05-01',0,'null');
INSERT INTO plateinformation Values('3SAM123','K9915810','JTHCF5C25A5037389', 'BMW', 'M3','CA','2018-06-23',0,'null');

CREATE TABLE ownerinformation(
	plate_number VARCHAR(20),
	license_number VARCHAR(20) PRIMARY KEY,
	race VARCHAR(100),
	ethnicity VARCHAR(100),
	eyecolor VARCHAR(100),
	hairColor VARCHAR(100),
	height INT,
	weight INT,
	ssn INT);

INSERT INTO ownerinformation Values('6HCM166','F9445584', 'black','African-American','black','black',155,120,731131965);
INSERT INTO ownerinformation Values('SCRWOIL','C5215770', 'white','American','blue','brown',163,120,731546548);
INSERT INTO ownerinformation Values('GWU2019','G2519949', 'yellow','Aisan','black','black',170,150,731225548);
INSERT INTO ownerinformation Values('ETALLIC','F3959118', 'black','African-American','black','black',155,120,485123486);
INSERT INTO ownerinformation Values('3SAM123','K9915810', 'black','African-American','black','black',150,160,122459635);


CREATE TABLE address(
	license_number VARCHAR(20) PRIMARY KEY,
	address VARCHAR(100),
	city VARCHAR(100),
    region VARCHAR(100),
    postalcode VARCHAR(100),
    country VARCHAR(100));

INSERT INTO address Values('F9445584', '541 Elizabeth Ave', 'Santa Ana', 'CA', '92701', 'United States');
INSERT INTO address Values('C5215770', '29 Jennings Ave', 'Ontario', 'CA', '91758', 'United States');
INSERT INTO address Values('G2519949', '38 Lookout Rd', 'Vacaville', 'CA', '95687', 'United States');
INSERT INTO address Values('F3959118', '901 Tanglewood Lane', 'San Marcos', 'CA', '92024', 'United States');
INSERT INTO address Values('K9915810', '138 Baker St', 'Los Angeles', 'CA', '90011', 'United States');

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
);

INSERT INTO personalinformation Values('F9445584', 'Brooke', 'null', 'Perry', '551-587-9160', 'F', '1952-12-03','Yes','1');
INSERT INTO personalinformation Values('C5215770', 'Amar', 'Chaddy', 'Russell', '360-989-3945', 'F', '1991-09-22','Yes','0');
INSERT INTO personalinformation Values('G2519949', 'Colby', 'null','Ross', '657-888-2976', 'F', '1974-11-07','No','0');
INSERT INTO personalinformation Values('F3959118', 'Katharine', 'Sherill','Mcgee', '507-793-4475', 'F', '1985-06-07','Visa','0');
INSERT INTO personalinformation Values('K9915810', 'Dante', 'null', 'Reed', '586-350-7044', 'M', '1982-01-03','Yes','0');

CREATE TABLE crime
(
	license_number VARCHAR(20) PRIMARY KEY,
	sexoffender INT,
	felonyconviction INT,C5215770
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

