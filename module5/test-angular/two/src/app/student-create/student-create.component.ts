import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from '../student';
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  studentCreate: Student = {};
  @Output() submitCreate = new EventEmitter();
  studentFormReactive: FormGroup;


  constructor() {
    this.studentFormReactive = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.min(0)]),
      name: new FormControl('TienNVT', [Validators.required, Validators.minLength(5)]),
      dateOfBirth: new FormControl(),
      point: new FormControl('', this.validateCustomPoint)
    });
  }

  ngOnInit(): void {
  }

  validateCustomPoint(point: AbstractControl) {
    let value = point.value;
    if (value < 0) {
      return {'invalid0': true};
    }
    return null;
  }

  createStudent() {
    this.submitCreate.emit(this.studentCreate);
    this.studentCreate = {id: 0};
  }

  createStudentWithTemplate(registerForm: NgForm) {
    console.log(registerForm);
    this.submitCreate.emit(registerForm.value);

  }

  createStudentWithReactive() {
    console.log(this.studentFormReactive.value);
    if (this.studentFormReactive.valid) {
      this.submitCreate.emit(this.studentFormReactive.value);
    }
  }
}
