import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-create',
  templateUrl: './register-create.component.html',
  styleUrls: ['./register-create.component.css']
})
export class RegisterCreateComponent implements OnInit {
  registerFormReactive: FormGroup;
  @Output() submitCreate = new EventEmitter();

  constructor() {
    this.registerFormReactive = new FormGroup({
      id: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-' +
        ']+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$')]),
      password: new FormControl('', [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required]),
      country: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
  }

  createRegisterWithReactive() {
    console.log(this.registerFormReactive.value);
    if (this.registerFormReactive.valid) {
      this.submitCreate.emit(this.registerFormReactive.value);
    }
  }

}
