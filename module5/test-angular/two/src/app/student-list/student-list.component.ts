import {Component, OnInit} from '@angular/core';
import {Student} from '../student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];
  temp: Student;

  constructor() {
    this.students.push({id: 1, name: 'haitt', dateOfBirth: '1990-02-02', point: 5});
  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:no-shadowed-variable
  detailStudent(std, Student) {
    this.temp = std;
  }

  addStudent($event: any) {
    console.log($event);
    this.students.push($event);
    this.ngOnInit();
  }
}
