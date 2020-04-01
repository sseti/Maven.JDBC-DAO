CREATE DATABASE myCar;
USE myCar;

CREATE TABLE Car (Id INTEGER(255), Make VARCHAR(255), Model VARCHAR(255), Year INTEGER(255), Color VARCHAR(255), Vin INTEGER(255));

INSERT INTO Car (Id, Make, Model, Year, Color, Vin) VALUES (1234, 'Honda', 'LX', 2002, 'Black', 53545);
INSERT INTO Car (Id, Make, Model, Year, Color, Vin) VALUES (1111, 'Honda', 'EX', 2003, 'White', 13234);
INSERT INTO Car (Id, Make, Model, Year, Color, Vin) VALUES (1212, 'Honda', 'Civic', 2008, 'Blue', 423424);
INSERT INTO Car (Id, Make, Model, Year, Color, Vin) VALUES (2121, 'Honda', 'Oddysey', 2012, 'Red', 234324);
INSERT INTO Car (Id, Make, Model, Year, Color, Vin) VALUES (2222, 'Honda', 'Accord', 2013, 'Gray', 133444);

SHOW TABLES;
SELECT * FROM Car;
DELETE FROM Car WHERE ID = 9867;
