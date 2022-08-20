USE quanlysinhvien;

SELECT * FROM student 
WHERE StudentName like 'h%';

SELECT * FROM class 
where month(StartDate) = 12;

update student 
set ClassId=2
where StudentName like 'Hung';
select * from student;

SELECT * FROM subject
WHERE Credit between 3 and 5;

select StudentName, SubName, Mark from student stu
inner join Mark  mark on stu.StudentId = mark.StudentId
 inner join `Subject` sub on sub.SubId=mark.SubId
 order by mark.Mark desc, stu.StudentName asc;