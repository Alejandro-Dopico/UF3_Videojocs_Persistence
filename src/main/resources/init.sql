CREATE TABLE games(id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(40) NOT NULL,
developer VARCHAR(40) NOT NULL,
price FLOAT DEFAULT 0,
year INT NOT NULL);
 
INSERT INTO games (id, name, developer, price, year) VALUES (1, 'Resident Evil 5', 'Capcom', 29.99, 2003);
INSERT INTO games (id, name, developer, price, year) VALUES (2, 'Silent Hill 1', 'TeamSilents', 49.99, 2001);