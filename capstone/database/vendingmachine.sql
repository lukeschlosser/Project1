BEGIN TRANSACTION;
DROP TABLE IF EXISTS stock,product CASCADE;

CREATE TABLE product (
	product_id varchar(10) NOT NULL Primary key, -- slot_location
	name varchar(30) NOT NULL,
	price money NOT NULL,
	type varchar(10) NOT NULL
);

CREATE TABLE stock (
	stock_id serial,
	product_id varchar(10) NOT NULL, -- slot_location
	quantity int NOT NULL DEFAULT 0,
	constraint pk_stock primary key (stock_id),
	constraint FK_stock_product foreign key (product_id) references product(product_id)
);

INSERT INTO product (product_id, name, price, type) VALUES 
('A1','Potato Crisps',3.05,'Chip'),
('A2','Stackers',1.45,'Chip'),
('A3','Grain Waves',2.75,'Chip'),
('A4','Cloud Popcorn',3.65,'Chip'),
('B1','Moonpie',1.80,'Candy'),
('B2','Cowtales',1.50,'Candy'),
('B3','Wonka Bar',1.50,'Candy'),
('B4','Crunchie',1.75,'Candy'),
('C1','Cola',1.25,'Drink'),
('C2','Dr. Salt',1.50,'Drink'),
('C3','Mountain Melter',1.50,'Drink'),
('C4','Heavy',1.50,'Drink'),
('D1','U-Chews',0.85,'Gum'),
('D2','Little League Chew',0.95,'Gum'),
('D3','Chiclets',0.75,'Gum'),
('D4','Triplemint',0.75,'Gum');

INSERT INTO stock(product_id,quantity) VALUES 
('A1',5),
('A2',5),
('A3',5),
('A4',5),
('B1',5),
('B2',5),
('B3',5),
('B4',5),
('C1',5),
('C2',5),
('C3',5),
('C4',5),
('D1',5),
('D2',5),
('D3',5),
('D4',5);

COMMIT TRANSACTION;