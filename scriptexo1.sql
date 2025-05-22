-- fichier pour l'exercice 1 JDBC 22-05-2025
CREATE DATABASE exo1;
USE exo1;

CREATE TABLE etudiant(
id int auto_increment primary key,
first_name VARCHAR(150),
last_name VARCHAR(150),
classe int,
date VARCHAR(150)
)
;
SELECT * FROM etudiant;
