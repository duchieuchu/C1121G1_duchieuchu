import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {Category} from '../../model/category';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productArray: Product[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.productService.getAllProduct().subscribe(data => {
      this.productArray = data;
      console.log(data);
    }, error => {
    });
  }

  deleteDishById(id: number) {
    this.productService.deleteProductById(id).subscribe(value => {

    }, error => {
    }, () => {
      // @ts-ignore
      $('#exampleModal' + id).modal('hide');
      this.getAll();
    });
  }
}
