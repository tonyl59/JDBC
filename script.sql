-- Fichier pour la demo de base JDBC
CREATE DATABASE demo_jdbc;
USE demo_jdbc;

CREATE TABLE users(
id int auto_increment primary key,
first_name VARCHAR(150),
last_name VARCHAR(150)
);

SELECT * FROM users;

