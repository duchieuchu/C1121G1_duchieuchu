import {Component, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFormReactive: FormGroup;

  constructor() {
    this.loginFormReactive = new FormGroup({
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }

  ngOnInit(): void {
  }

}
