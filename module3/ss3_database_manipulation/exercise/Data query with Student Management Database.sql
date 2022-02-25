use quanlinhanvien;
select* from student where studentName like 'h%';

select * from class where month(startDate)='12'; 

select*from subject where credit between 3 and 5;

set sql_safe_updates=0;
update student set classID=2 where studentName='Hung' ;
set sql_safe_updates=1;

select student.studentName, subject.SubName,mark from mark
left join student on mark.StudentId=student.StudentId
left join subject on mark.SubId=subject.SubId
order by mark desc,studentName asc;


