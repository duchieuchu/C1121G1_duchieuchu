import {Component, OnInit} from '@angular/core';
import {BaseService} from '../../service/base.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {Base} from '../../model/base';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Employee} from '../../model/employee';

@Component({
  selector: 'app-base-create',
  templateUrl: './base-create.component.html',
  styleUrls: ['./base-create.component.css']
})
export class BaseCreateComponent implements OnInit {
  base: Base;
  formBase = new FormGroup({
    address: new FormControl(),
    name: new FormControl(),
    openDay: new FormControl(),
    baseCode: new FormControl(),
    employee: new FormControl(),
    isDeleted: new FormControl()
  });
  employeeArray: Employee[] = [];

  constructor(private baseService: BaseService, private toast: ToastrService,
              private router: Router,
              private title: Title) {
    this.title.setTitle('Thêm mới cơ sở');
  }

  ngOnInit(): void {
    this.getAll();
    this.getForm();
  }

  getAll() {
    this.baseService.getAllListEmloyee().subscribe(data => {
      this.employeeArray = data;
      console.log(data);
    }, error => {
    });
  }

  getForm() {
    this.formBase = new FormGroup({
      address: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      openDay: new FormControl('', [Validators.required]),
      baseCode: new FormControl(''),
      employee: new FormControl('', [Validators.required]),
      isDeleted: new FormControl('')
    });
  }

  createBase() {
    if (this.formBase.valid) {
      this.baseService.createBase(this.formBase.value).subscribe(data => {
        }, error => {
        },
        () => {
          this.router.navigateByUrl('/base/list').then(next => this.toast.success('Thêm mới thành công.', 'Thông Báo'));
        });
    }
  }
}
