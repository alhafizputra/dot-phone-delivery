DROP TABLE IF EXISTS CUSTOMER;  
CREATE TABLE CUSTOMER (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) NOT NULL,  
phone_no VARCHAR(50) NOT NULL,
address VARCHAR(50)
);  

DROP TABLE IF EXISTS PRODUCT;  
CREATE TABLE PRODUCT (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) NOT NULL,  
code VARCHAR(50) NOT NULL
);  