drop database if exists hotelmanagement;
create database hotelmanagement;
use hotelmanagement;

drop table if exists payment;
drop table if exists reservation;
drop table if exists roomquality;
drop table if exists roomclass;
drop table if exists room;
drop table if exists customer;

create table customer (
	cust_ID INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
	custfname VARCHAR(50),
	custlname VARCHAR(50),
	SSN VARCHAR(50),
	housenumber VARCHAR(50),
	district VARCHAR(50),
	state VARCHAR(50),
	gender VARCHAR(50),
	phonenumber VARCHAR(50)
);

create table roomclass (
	class_ID INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(50),
    class_price DOUBLE,
    class_description VARCHAR(200)
);

create table roomquality (
	roomQuality_ID INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
    quality CHAR(1),
    priceMultiply DOUBLE
);

create table room (
	room_ID INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
    roomNumber INT,
    roomQuality INT,
    class_ID INT,
    foreign key (class_ID) references roomclass(class_ID),
    foreign key (roomQuality) references roomquality(roomQuality_ID)
);

create table reservation (
	reservation_ID INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
    room_ID INT,
    date_in DATETIME,
    date_out DATETIME,
    customer_ID INT,
    foreign key (customer_ID) references customer(cust_ID)
);

create table payment (
	payment_ID INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
    customer_ID INT,
    payment_date DATE,
    amount DOUBLE,
    reservation_ID INT,
    foreign key (reservation_ID) references reservation(reservation_ID)
);

insert into roomquality (roomQuality_ID, quality, priceMultiply) values (1, 'D', 0.5);
insert into roomquality (roomQuality_ID, quality, priceMultiply) values (2, 'C', 1);
insert into roomquality (roomQuality_ID, quality, priceMultiply) values (3, 'B', 1.5);
insert into roomquality (roomQuality_ID, quality, priceMultiply) values (4, 'A', 2);
insert into roomquality (roomQuality_ID, quality, priceMultiply) values (5, 'S', 2.5);

insert into roomclass (class_ID, class_name, class_price, class_description) values (1, 'Single', 10, 'A Single Bed Room');
insert into roomclass (class_ID, class_name, class_price, class_description) values (2, 'Double', 20, 'A Double Beds Room');
insert into roomclass (class_ID, class_name, class_price, class_description) values (3, 'Deluxe', 30,'A good bed room with full furnitures');
insert into roomclass (class_ID, class_name, class_price, class_description) values (4, 'King', 40,  'A king-sized Bed Room with full furnitures');

insert into room (room_ID, roomNumber, roomQuality, class_ID) values (1, 101, 1, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (2, 102, 1, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (3, 103, 1, 2);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (4, 104, 1, 3);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (5, 105, 1, 4);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (6, 201, 2, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (7, 202, 2, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (8, 203, 2, 2);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (9, 204, 2, 3);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (10, 205, 2, 4);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (11, 301, 3, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (12, 302, 3, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (13, 303, 3, 2);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (14, 304, 3, 3);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (15, 305, 3, 4);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (16, 401, 4, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (17, 402, 4, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (18, 403, 4, 2);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (19, 404, 4, 3);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (20, 405, 4, 4);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (21, 501, 5, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (22, 502, 5, 1);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (23, 503, 5, 2);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (24, 504, 5, 3);
insert into room (room_ID, roomNumber, roomQuality, class_ID) values (25, 505, 5, 4);

insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (1, 'Giacobo', 'Ledamun', '97-662-5313', '9630', 'Troy', 'District of Columbia', 'M', '202-685-4127');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (2, 'Hale', 'Crumly', '06-391-0012', '85', 'Prairie Rose', 'New Mexico', 'M', '505-379-1691');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (3, 'Sophi', 'Dommerque', '18-770-6592', '92', 'Grasskamp', 'Florida', 'F', '407-328-6026');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (4, 'Emilio', 'Boribal', '77-085-6410', '6', 'Florence', 'Illinois', 'M', '312-571-4009');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (5, 'Gaultiero', 'Spens', '39-410-3266', '0', 'Westerfield', 'Ohio', 'M', '234-169-3364');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (6, 'Allsun', 'Chatfield', '87-322-6007', '93', 'Kim', 'Alabama', 'F', '205-931-7155');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (7, 'Lila', 'Scarlon', '60-386-6850', '3', 'Little Fleur', 'Texas', 'F', '915-770-1117');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (8, 'Claresta', 'Yukhnev', '93-181-5181', '5157', 'Sheridan', 'Colorado', 'F', '719-113-1139');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (9, 'Barbaraanne', 'Ivanyushin', '49-659-7326', '42', 'Service', 'Texas', 'F', '432-248-5139');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (10, 'Bev', 'Tebbit', '37-481-6218', '86888', 'Talisman', 'California', 'M', '909-644-4657');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (11, 'Miguelita', 'Losselyong', '74-636-7168', '04', 'Bonner', 'Texas', 'F', '210-182-1672');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (12, 'Tara', 'Kinder', '82-269-2011', '29973', 'Independence', 'Ohio', 'F', '513-356-3400');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (13, 'Dennet', 'Kaming', '83-420-4417', '43590', 'Thackeray', 'Alabama', 'M', '334-820-5841');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (14, 'Adham', 'Tongs', '35-974-4352', '11870', 'Fremont', 'Arizona', 'M', '602-641-0858');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (15, 'Ruperta', 'MacIlurick', '96-409-9752', '3635', '5th', 'New York', 'F', '646-480-3372');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (16, 'Pepita', 'Soeiro', '36-103-4701', '1776', 'Susan', 'New Jersey', 'F', '609-849-9355');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (17, 'Sigismondo', 'Davidofski', '99-103-9013', '415', 'Rusk', 'Oregon', 'M', '971-902-0129');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (18, 'Karoly', 'Immins', '72-387-9940', '89', 'Westport', 'Florida', 'F', '727-884-4296');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (19, 'Aksel', 'Issacoff', '48-942-9570', '26', 'Schurz', 'California', 'M', '925-288-9509');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (20, 'Hamlin', 'Bugg', '01-794-9467', '84', 'Marquette', 'Ohio', 'M', '216-606-6063');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (21, 'Jennette', 'Ocheltree', '00-538-1106', '273', 'Cardinal', 'District of Columbia', 'F', '202-600-5185');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (22, 'Shellie', 'Neilson', '14-965-5338', '79844', 'Daystar', 'Iowa', 'F', '563-969-3548');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (23, 'Lethia', 'Mc Meekan', '19-569-1625', '07397', 'Glacier Hill', 'Indiana', 'F', '317-854-3311');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (24, 'Annissa', 'Winborn', '81-134-1206', '24', 'Carpenter', 'California', 'F', '760-984-6113');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (25, 'Axe', 'Pren', '54-379-4563', '6930', 'Spenser', 'Florida', 'M', '727-361-3472');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (26, 'Theodor', 'Grayne', '08-615-6927', '6', 'Brickson Park', 'California', 'M', '951-133-4493');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (27, 'Phedra', 'Harback', '39-886-9577', '492', 'Independence', 'California', 'F', '805-997-1797');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (28, 'Morton', 'Greenroyd', '59-536-4604', '06', 'Drewry', 'New York', 'M', '585-460-9112');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (29, 'Klemens', 'Takkos', '78-135-3194', '434', 'Leroy', 'Texas', 'M', '713-108-9622');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (30, 'Grant', 'Sawfoot', '33-289-1912', '6760', 'Katie', 'Ohio', 'M', '330-374-1942');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (31, 'Murielle', 'Bordis', '71-156-6238', '27655', 'Kropf', 'California', 'F', '619-413-1521');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (32, 'Noel', 'Pocock', '70-886-8476', '33061', 'Melby', 'Texas', 'M', '512-352-3613');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (33, 'Darb', 'Sibille', '70-792-3518', '427', 'Stoughton', 'Texas', 'M', '972-614-1622');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (34, 'Munroe', 'Northway', '38-475-9141', '7298', 'Petterle', 'District of Columbia', 'M', '202-427-4357');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (35, 'Jillayne', 'Kopfen', '61-838-2968', '811', 'Crest Line', 'Alabama', 'F', '251-390-4428');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (36, 'Aland', 'Ingram', '50-984-0041', '94805', 'Grim', 'Tennessee', 'M', '423-182-5562');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (37, 'Johnnie', 'Eakeley', '96-955-1166', '163', 'Green', 'Oklahoma', 'M', '918-894-9659');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (38, 'Marcellus', 'Taggett', '70-557-1987', '206', 'Golf Course', 'District of Columbia', 'M', '202-399-8195');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (39, 'Rickey', 'Catanheira', '05-149-5893', '45055', 'Almo', 'Arizona', 'M', '602-182-9232');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (40, 'Ursuline', 'Belcher', '54-107-1301', '72', '7th', 'Colorado', 'F', '970-414-4653');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (41, 'Willie', 'Durnford', '36-973-0554', '428', 'Browning', 'Indiana', 'M', '812-665-3928');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (42, 'Hobart', 'Farrimond', '33-587-1277', '93438', 'Memorial', 'Montana', 'M', '406-930-1400');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (43, 'Charin', 'Simononsky', '22-076-8027', '40941', 'Tony', 'Colorado', 'F', '719-231-4422');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (44, 'Clayton', 'Scola', '32-472-3611', '11019', 'Bashford', 'Virginia', 'M', '757-666-3573');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (45, 'Cyrus', 'Rispen', '37-924-9952', '96', 'Hintze', 'Texas', 'M', '432-920-6932');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (46, 'Ivan', 'Halliburton', '83-637-1754', '4', 'Clyde Gallagher', 'Texas', 'M', '832-921-0999');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (47, 'Olivero', 'McKevin', '27-350-4433', '24', 'Moose', 'Georgia', 'M', '770-892-1673');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (48, 'David', 'Clews', '95-341-1112', '22', 'Butterfield', 'Ohio', 'M', '937-759-3485');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (49, 'Marleah', 'Merwede', '32-907-2081', '2', 'Helena', 'Ohio', 'F', '937-717-2238');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (50, 'Fanni', 'Tapsfield', '01-592-7822', '5435', 'Carey', 'Alabama', 'F', '205-773-1895');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (51, 'Madel', 'Ropars', '14-350-3937', '5', 'Shelley', 'Hawaii', 'F', '808-301-4917');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (52, 'Amalita', 'MacClure', '33-972-1909', '5309', 'Duke', 'Michigan', 'F', '269-323-5225');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (53, 'Wilone', 'Rainbow', '51-222-8330', '00', 'Burning Wood', 'Alabama', 'F', '251-904-5101');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (54, 'Zena', 'Matyushonok', '93-264-0771', '64', 'Everett', 'Alaska', 'F', '907-476-2704');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (55, 'Janeen', 'Thurstance', '74-179-9866', '996', 'Blue Bill Park', 'Virginia', 'F', '571-737-3931');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (56, 'Corenda', 'Penelli', '31-445-8909', '07', 'Golf Course', 'California', 'F', '415-782-2399');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (57, 'Antonetta', 'Zini', '56-615-0865', '83693', 'Packers', 'Texas', 'F', '281-195-9875');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (58, 'Wells', 'Crass', '67-141-9357', '975', 'Merry', 'Texas', 'M', '915-338-1773');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (59, 'Birdie', 'Matfin', '49-935-3334', '2582', 'Dayton', 'Connecticut', 'F', '860-140-6703');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (60, 'Emmalynne', 'Swalteridge', '68-870-5948', '0', 'Charing Cross', 'New York', 'F', '917-798-8219');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (61, 'Micheal', 'Rope', '28-600-6336', '5', 'Susan', 'New York', 'M', '347-793-7785');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (62, 'Latisha', 'Jerratsch', '53-050-8133', '43', 'Moulton', 'Georgia', 'F', '678-451-4179');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (63, 'Billy', 'Paoloni', '89-193-0035', '8839', 'Forster', 'California', 'F', '415-549-2284');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (64, 'Elmer', 'Shrimpton', '42-971-3900', '5', 'Dorton', 'Georgia', 'M', '706-600-3171');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (65, 'Steward', 'Walwood', '35-119-1400', '5227', 'Donald', 'California', 'M', '818-671-5943');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (66, 'Kissee', 'Hawarden', '29-495-1658', '2', 'Delladonna', 'Georgia', 'F', '404-614-9149');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (67, 'Gustav', 'Sainer', '98-915-6194', '629', 'Green', 'Virginia', 'M', '540-605-4053');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (68, 'Jo-anne', 'Coplestone', '36-576-6571', '569', 'Evergreen', 'New York', 'F', '718-874-4930');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (69, 'Austine', 'Plowright', '44-778-7583', '1085', 'Truax', 'Florida', 'F', '305-657-0678');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (70, 'Flemming', 'Attrey', '08-032-3723', '91', 'Judy', 'Ohio', 'M', '330-780-4346');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (71, 'Eveleen', 'Sutch', '98-242-9329', '3', 'Hansons', 'Kansas', 'F', '785-569-1842');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (72, 'Granville', 'Rappport', '20-951-3221', '41', 'Forest Run', 'California', 'M', '702-119-4635');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (73, 'Geordie', 'Sapseed', '93-337-5310', '4', 'Bashford', 'California', 'M', '818-291-1866');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (74, 'Elane', 'Fattorini', '23-526-4279', '37', 'Bayside', 'Texas', 'F', '979-663-4211');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (75, 'Kesley', 'Price', '62-940-8356', '77653', 'Vermont', 'Nevada', 'F', '702-361-3424');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (76, 'Philippe', 'Maddick', '85-761-7616', '45409', 'Elka', 'Illinois', 'F', '312-279-0324');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (77, 'Lorne', 'Pluthero', '77-698-1285', '461', 'Thackeray', 'Ohio', 'F', '330-227-5683');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (78, 'Clark', 'Barthelmes', '26-507-1795', '21', 'Donald', 'California', 'M', '916-466-5294');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (79, 'Kerrie', 'Courcey', '81-188-3958', '591', 'Troy', 'West Virginia', 'F', '304-314-3583');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (80, 'Bennie', 'Breslauer', '66-600-4621', '77', 'Hooker', 'Texas', 'F', '832-657-3398');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (81, 'Nancey', 'Haith', '74-895-1738', '25', '3rd', 'Oregon', 'F', '971-663-1718');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (82, 'Weber', 'Playdon', '64-460-9368', '36', 'Morningstar', 'Alabama', 'M', '205-810-1419');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (83, 'Reina', 'Jerzycowski', '38-142-5834', '51898', 'Bunker Hill', 'Texas', 'F', '713-972-0077');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (84, 'Kaylee', 'Urch', '54-320-6330', '0857', 'Upham', 'Georgia', 'F', '404-300-1786');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (85, 'Raoul', 'Cossor', '60-685-1147', '3386', 'Golf View', 'Virginia', 'M', '571-285-5094');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (86, 'Kerby', 'Elmore', '25-756-9801', '8', 'John Wall', 'Connecticut', 'M', '203-833-7414');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (87, 'Tabbie', 'Murrey', '58-807-1117', '77714', 'Holmberg', 'Louisiana', 'F', '504-983-4934');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (88, 'Ken', 'Bergstrand', '46-552-5105', '085', 'Packers', 'California', 'M', '805-710-8221');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (89, 'Mabelle', 'Jillett', '86-143-0319', '847', 'Garrison', 'North Carolina', 'F', '704-620-9245');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (90, 'Wilhelmina', 'Courteney', '87-345-7769', '4247', 'Grayhawk', 'California', 'F', '916-177-9699');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (91, 'Briana', 'Gulston', '87-297-0379', '21', 'Autumn Leaf', 'California', 'F', '415-594-7942');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (92, 'Sheelah', 'Tanti', '29-130-5967', '298', 'Weeping Birch', 'Pennsylvania', 'F', '717-630-3575');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (93, 'Hillary', 'Canny', '56-894-9961', '3425', 'Hallows', 'Oklahoma', 'M', '405-557-4109');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (94, 'Randal', 'Garden', '09-382-5963', '9', 'Surrey', 'Texas', 'M', '915-338-0417');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (95, 'Tamma', 'Dillestone', '09-739-7100', '93521', 'Rowland', 'District of Columbia', 'F', '202-320-4464');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (96, 'Dorise', 'Doubrava', '38-167-8867', '49644', 'Scoville', 'Wisconsin', 'F', '920-798-5568');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (97, 'Reynold', 'Pharrow', '27-290-4107', '03', 'Corben', 'West Virginia', 'M', '304-755-0027');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (98, 'Anderea', 'Orhtmann', '75-463-0687', '0', 'Hanson', 'Texas', 'F', '972-714-3012');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (99, 'Joana', 'Pottery', '99-807-3861', '54810', 'Green', 'Connecticut', 'F', '203-712-4686');
insert into customer (cust_ID, custfname, custlname, SSN, housenumber, district, state, gender, phonenumber) values (100, 'Trefor', 'Ochterlonie', '31-293-1751', '8782', 'Mallory', 'Missouri', 'M', '314-543-5265');

insert into reservation (room_ID, date_in, date_out, customer_ID) values (1, '2023-05-05 18:00:00', '2023-06-06 18:00:00', 1);
insert into reservation (room_ID, date_in, date_out, customer_ID) values (1, '2023-06-07 18:00:00', '2023-06-10 18:00:00', 2);
insert into reservation (room_ID, date_in, date_out, customer_ID) values (2, '2023-04-03 18:00:00', '2023-04-06 18:00:00', 3);
insert into reservation (room_ID, date_in, date_out, customer_ID) values (2, '2023-06-08 18:00:00', '2023-06-12 18:00:00', 4);