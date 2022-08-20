insert into customer 
values(2, 3, 'Phạm Xuân Diệu', '1992-08-08',1, '865342123', '0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị'),
	  (3, 1, 'Trương Đình Nghệ', '1990-02-27',1, '488645199', '0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh'),
      (4, 1, 'Dương Văn Quan', '1981-07-08',1, '543432111', '0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng'),
      (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09',0, '795453345', '0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai'),
      (6, 4, 'Tôn Nữ Ngọc Châu', '2005-12-06',0, '732434215', '0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng'),
      (7, 1, 'Nguyễn Mỹ Kim', '1984-04-08',0, '856453123', '0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh'),
      (8, 3, 'Nguyễn Thị Hào', '1999-04-08',0, '965656433', '0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum'),
      (9, 1, 'Trần Đại Danh', '1994-07-01',1, '432341235', '0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi'),
      (10, 2, 'Nguyễn Tâm Đắc', '1989-07-01',1, '344343432', '0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng');
      
insert into division
values(1, 'Sale-Marketing'),
	  (2, 'Hành chính'),
      (3, 'Phục vụ'),
      (4, 'Quản Lý');
insert into education_degree 
values(1, 'Trung cấp'),
      (2, 'Cao đẳng'),
      (3, 'Đại hoc'),
      (4, 'Sau đại học');
insert into position_table
values(1, 'Quản Lý'),
	  (2, 'Nhân viên');

insert into rent_type(rent_type_id,rent_type_name)
values (1, 'year'),
	   (2, 'month'),
       (3, 'day'),
       (4, 'hour');
       
insert into attach_service
values(1, 'Karaoke',10000,'giờ', 'tiện nghi, hiện đại'),
	  (2, 'Thuê xe máy',10000,'chiếc', 'hỏng 1 xe'),
      (3, 'Thuê xe đạp',20000,'chiếc', 'tốt'),
      (4, 'Buffet buổi sáng',15000,'suất', 'đầy đủ đồ ăn, tráng miệng'),
      (5, 'Buffet buổi trưa',90000,'suất', 'đầy đủ đồ ăn, tráng miệng'),
      (6, 'Buffet buổi tối',16000,'suất', 'đầy đủ đồ ăn, tráng miệng');