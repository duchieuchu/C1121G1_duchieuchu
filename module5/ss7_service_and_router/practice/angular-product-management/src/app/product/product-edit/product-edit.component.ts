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
  product: Product;

  constructor(private activatedRoute: ActivatedRoute, private productService: ProductService, private router: Router) {
    activatedRoute.paramMap.subscribe((param: ParamMap) => {
      const id = param.get('id');
      this.product = this.productService.findById(parseInt(id));
    });
  }

  ngOnInit(): void {
    this.editProductFormGroup = new FormGroup({
      id: new FormControl(this.product.id),
      name: new FormControl(this.product.name),
      price: new FormControl(this.product.price),
      description: new FormControl(this.product.description)
    });
  }

  submitEdit() {
    this.productService.edit(this.editProductFormGroup.value);
    this.router.navigateByUrl('/product/list').then();
  }

}
