import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productArray: Product[] = [];

  totalPages: number;
  countTotalPages: number[];
  number: number;
  size: number;

  constructor(private productService: ProductService, private toast: ToastrService,
              private router: Router,
              private title: Title) {
  }

  ngOnInit(): void {
    this.getDishPage(0);
  }

  getDishPage(page: number) {
    this.productService.getProductPage(page).subscribe((data: Product[]) => {
      if (data !== null) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
        // @ts-ignore
        this.productArray = data.content;
        // @ts-ignore
        this.size = data.size;
      } else {
        this.productArray = [];
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

  deleteProductById(id: number) {
    this.productService.deleteProduct(id).subscribe(value => {
    }, error => {
    }, () => {
      // @ts-ignore
      $('#exampleModal' + id).modal('hide');
      this.getDishPage(0);
      this.router.navigateByUrl('/product/list').then(next => this.toast.success('Xóa thành công'));
    });
  }



}
