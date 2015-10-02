CREATE TABLE member (id INT(4) AUTO_INCREMENT, firstName TEXT NOT NULL, lastName TEXT NOT NULL, email TEXT, category INT(4), 
PRIMARY KEY (id), 
FOREIGN KEY (category) REFERENCES category(id));

CREATE TABLE category (id INT(4), name TEXT NOT NULL,
PRIMARY KEY (id));