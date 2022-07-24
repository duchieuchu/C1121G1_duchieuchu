import {Component, OnInit} from '@angular/core';
import {Register} from '../register';

@Component({
  selector: 'app-register-list',
  templateUrl: './register-list.component.html',
  styleUrls: ['./register-list.component.css']
})
export class RegisterListComponent implements OnInit {
  registers: Register[] = [];

  constructor() {
    this.registers.push({
      id: 1,
      email: 'angular2022@gmail.com',
      password: '2022',
      age: 19,
      country: 'VietNam',
      gender: 'Nam',
      phone: '0333333333'
    });
  }

  ngOnInit(): void {
  }

  createRegister($event: any) {
    console.log($event);
    this.registers.push($event);
    this.ngOnInit();

  }
}
