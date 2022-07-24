import {Component, OnInit, Output} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFormReactive: FormGroup;

  constructor() {
    this.loginFormReactive = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9.!#$%&’*+/=?^' +
        '_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$')]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }

  checkEmail(email: AbstractControl) {
    let value = email.value;

    if (value.email !== '1@gmail.com') {
      return {'inValidEmail': true};
    }
    return null;
  }

  checkPassword(password: AbstractControl) {
    let value = password.value;

    if (value.password !== '111') {
      return {'inValidPassword': true};
    }
    return null;
  }

  ngOnInit(): void {
  }

}
