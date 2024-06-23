DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer AS SELECT * FROM CSVREAD('classpath:table/customer_visa.csv');