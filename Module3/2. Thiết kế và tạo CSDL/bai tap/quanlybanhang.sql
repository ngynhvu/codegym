CREATE DATABASE QuanLyBanHang;
USE QuanLyBanHang;
CREATE TABLE Customer(
cID int auto_increment not null primary key unique,
cName VARCHAR(45) NOT NULL,
cAGE INT NOT NULL
);
CREATE TABLE Oder(
oID INT auto_increment not null primary key,
cID int not null,
oDate date not null,
oTotalPrice double default 0,
CONSTRAINT KHOA_ID FOREIGN KEY (cID) REFERENCES Customer(cID)
);
CREATE TABLE OrderDetail(
oID int not null,
pID int not null,
odQTY int default 0,
FOREIGN KEY(pID) REFERENCES Product(pID),
FOREIGN KEY(oID) REFERENCES Oder(oID)
);
CREATE TABLE Product(
pID int auto_increment primary key unique,
pName varchar(45),
pPrice double default 0
);