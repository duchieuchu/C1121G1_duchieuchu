import {Component, OnInit} from '@angular/core';
import {Base} from '../../model/base';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {BaseService} from '../../service/base.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';

@Component({
  selector: 'app-base-list',
  templateUrl: './base-list.component.html',
  styleUrls: ['./base-list.component.css']
})
export class BaseListComponent implements OnInit {
  baseArray: Base[] = [];


  searchForm: FormGroup;
  totalPages: number;
  countTotalPages: number[];
  number: number;
  size: number;

  constructor(private baseService: BaseService, private toast: ToastrService,
              private router: Router,
              private title: Title) {
    this.title.setTitle('Danh sách cơ sở');
  }

  ngOnInit(): void {
    this.getAll();
    this.createSearchForm();
  }

  getAll() {
    this.baseService.getAllList().subscribe(data => {
      this.baseArray = data;
      console.log(data);
    }, error => {
    });
  }

  deleteBaseById(id: number) {
    this.baseService.deleteBase(id).subscribe(value => {
    }, error => {
    }, () => {
      // @ts-ignore
      $('#exampleModal' + id).modal('hide');
      // @ts-ignore
      this.getAll();
      this.router.navigateByUrl('/base/list').then(next => this.toast.success('Xóa thành công'));
    });
  }

  getDishPage(nameBase: string) {
    this.baseService.search(nameBase).subscribe((data: Base[]) => {
      if (data !== null) {
        // @ts-ignore
        this.baseArray = data.content;
        console.log(data);
      } else {
        this.baseArray = [];
      }
    }, error => {
      console.log(error);
    });
  }

  searchBase() {
    // @ts-ignore
    this.getDishPage(this.searchForm.value.nameBase);
  }

  createSearchForm() {
    this.searchForm = new FormGroup({
      nameBase: new FormControl(),
    });
  }
}
