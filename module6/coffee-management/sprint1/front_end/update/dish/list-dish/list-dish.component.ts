import {Component, OnInit} from '@angular/core';
import {Dish} from "../../model/dish";
import {DishService} from "../../service/dish.service";
import {FormControl, FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-dish',
  templateUrl: './list-dish.component.html',
  styleUrls: ['./list-dish.component.css']
})
export class ListDishComponent implements OnInit {
  dishArray: Dish[] = [];
  p: number = 0;
  searchForm: FormGroup;
  totalPages: number;
  countTotalPages: number[];
  number: number;
  size: number;


  constructor(private dishService: DishService,private toast : ToastrService,private router:Router) {

  }

  ngOnInit(): void {
    this.getDishPage(0);
    this.createSearchForm();
  }

  getDishPage(page: number) {
    this.dishService.getDishPage(page).subscribe((data: Dish[]) => {
      if (data !== null) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
        // @ts-ignore
        this.dishArray = data.content;
        // @ts-ignore
        this.size = data.size;
      } else {
        this.dishArray = [];
      }
    }, error => {
      console.log(error);
    });
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getDishPage(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getDishPage(numberPage);
    }
  }
  goItem(i: number) {
    this.getDishPage(i);
  }


  deleteDishById(id: number) {
    this.dishService.deleteDishById(id).subscribe(value => {
    }, error => {
    }, () => {
      // @ts-ignore
      $('#exampleModal' + id).modal('hide');
      this.getDishPage(0);
      this.router.navigateByUrl('/dish').then(next => this.toast.success('Xóa thành công'));
    });
  }

  createSearchForm() {
    this.searchForm = new FormGroup({
      dishName: new FormControl(),
      dishCode: new FormControl(),
      dishPrice: new FormControl(),
      dishTypeId: new FormControl()
    });
  }

  searchDish() {
    this.dishService.getDishPageSearch(this.searchForm.value).subscribe((value: Dish[]) => {

      if (value !=null){
        // @ts-ignore
        this.dishArray = value.content;
        console.log(value)
      }else{
        this.dishArray =[];
      }

    });
  }
}
