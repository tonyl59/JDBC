CREATE DATABASE jdbc_exo2;
USE jdbc_exo2;

CREATE TABLE customer(
id int auto_increment primary key,
first_name VARCHAR(150),
last_name VARCHAR(150),
phone VARCHAR(12)
);

CREATE TABLE account(
id int auto_increment primary key,
customer_id int
);

CREATE TABLE account(
id int auto_increment primary key,
amount DOUBLE,
ostatus VARCHAR(150)
);

