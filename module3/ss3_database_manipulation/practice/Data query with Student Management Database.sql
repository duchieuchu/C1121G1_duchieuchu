use quanlinhanvien;
select *from student ;
select *from student where status= true;
select * from subject where credit <10;

select S.studentid,s.studentname,c.classname
from student s join class c on s.ClassId = c.ClassID
where c.ClassName='A1';

select S.studentId,S .StudentName,m.mark,sub.subName
from student s join mark M on s.StudentId = M.StudentId join subject sub on m.SubId= sub.SubId
where sub.subName ='CF';