import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  id: number;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.id = +param.get('id');
    });
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe(data => {
      this.products = data;
    }, error => {
    });
  }

  getAll() {
    this.productService.getAll();
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(value => {
      this.ngOnInit();
    });
  }
}
