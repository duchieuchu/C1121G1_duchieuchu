SELECT * FROM `student-management`.student;
insert into student 
values (1,"A",18,"VietNam"),(2,"B",19,"VietNam"),(3,"C",18,"VietNam"),(4,"C",19,"VietNam"),(5,"D",18,"VietNam");
update student
set name="E"where id_student=4;