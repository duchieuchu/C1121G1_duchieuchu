import {Component, Input, OnInit, SimpleChanges} from '@angular/core';
import {Student} from '../student';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
// tslint:disable-next-line:no-input-rename
  @Input('std') student: Student = {id: 5, name: 'Haitt', point: 5, dateOfBirth: '1990-02-02'};

  constructor() {
  }

  ngOnInit(): void {
  }

  changeNameStudent(value: any) {
    this.student.name = value;
  }

  ngOnchanges(changes: SimpleChanges): void {
    console.log(changes);
    console.log('hello');
  }
}
