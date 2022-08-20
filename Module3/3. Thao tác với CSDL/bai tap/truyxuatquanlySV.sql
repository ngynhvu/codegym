use quanlybanhang;

insert into customer 
values(1,'Minh Quan',10), 
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into product
values(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into oder 
values(1,1,'2006-03-21',null),
(2,2,'2006-03-23',null),
(3,1,'2006-03-16',null);

insert into orderdetail
values(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

select oID, oDate, oTotalPrice from oder;

select C.cID, C.cName, C.cAge, O.oDate from customer C join oder O on C.cID = O.cID
group by C.cID;

select P.pName, P.pPrice, C.cName from customer C join oder O on C.cID = O.cID
join orderdetail OD on OD.oID = O.oID join product P on P.pID = OD.pID
group by P.pName;

select * from customer
where cID not in (select cID from oder);

select O.oID, O.oDate, OD.odQTY*P.pPrice as 'oTotalPrice' from Oder O join orderdetail OD on O.oID = OD.oID 
join product P on OD.pID = P.pPrice;

select * from customer
where cID not in (select cID from oder);
