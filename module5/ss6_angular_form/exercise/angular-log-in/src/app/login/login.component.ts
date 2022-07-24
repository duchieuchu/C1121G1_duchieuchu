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
        '_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$'), this.checkEmail]),
      password: new FormControl('', [Validators.required, Validators.minLength(6), this.checkPassword])
    });
  }

  checkEmail(email: AbstractControl) {
    let value = email.value;

    if (value !== '1@gmail.com') {
      return {'invalidEmail': true};
    }
    return null;
  }

  checkPassword(password: AbstractControl) {
    let value = password.value;

    if (value !== '1111111') {
      return {'invalidPassword': true};
    }
    return null;
  }

  ngOnInit(): void {
  }

}
