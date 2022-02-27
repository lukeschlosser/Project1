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
('A4','Cloud Popcorn',3.65,'Chip');

INSERT INTO stock(product_id,quantity) VALUES
('A1',5),
('A2',5),
('A3',5),
('A4',5);

COMMIT TRANSACTION;