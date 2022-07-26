import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productForm: FormGroup;
  id: number;

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.id = +param.get('id');
      return this.productService.findById(this.id).subscribe(
        next => {
          return this.productForm = new FormGroup({
            id: new FormControl(next.id),
            name: new FormControl(next.name),
            price: new FormControl(next.price),
            description: new FormControl(next.description)
          });
        }
      );
    });
  }

  ngOnInit(): void {
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(next => {
      alert('xoa thanh cong');
      this.router.navigateByUrl('/product/list');
    });
  }
}
