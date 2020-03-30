USE myCar;
CREATE TABLE myCar (Id VARCHAR(255), Make VARCHAR(255), Model VARCHAR(255), Year VARCHAR(255), Color VARCHAR(255), Vin VARCHAR (255));

INSERT INTO mycar(Id, Make, Model, Year, Color, Vin) VALUES (1234, 'Honda', 'LX', 2002, 'Black', 'Qwerty1234');
INSERT INTO mycar(Id, Make, Model, Year, Color, Vin) VALUES (1111, 'Honda', 'EX', 2003, 'White', 'Qwerty4444');
INSERT INTO mycar(Id, Make, Model, Year, Color, Vin) VALUES (1212, 'Honda', 'Civic', 2008, 'Blue', 'Qwerty5555');
INSERT INTO mycar(Id, Make, Model, Year, Color, Vin) VALUES (2121, 'Honda', 'Oddysey', 2012, 'Red', 'Qwerty3333');
INSERT INTO mycar(Id, Make, Model, Year, Color, Vin) VALUES (2222, 'Honda', 'Accord', 2013, 'Gray', 'Qwerty7777');

SHOW TABLES;
SELECT * FROM myCar;