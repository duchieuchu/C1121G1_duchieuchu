import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  editProductFormGroup: FormGroup;
  product: Product = {};
  id: number;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private router: Router) {
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.id = parseInt(param.get('id'));
      this.productService.findById(this.id).subscribe(product => {
          this.editProductFormGroup = new FormGroup({
            id: new FormControl(product.id),
            name: new FormControl(product.name),
            price: new FormControl(product.price),
            description: new FormControl(product.description)
          });
        }
      );
    });
  }

  submitEdit(id: number) {
    const product = this.editProductFormGroup.value;
    this.productService.editProduct(id, product).subscribe(
      next => {
        this.router.navigateByUrl('/product/list').then();
      }
    );
  }

}
