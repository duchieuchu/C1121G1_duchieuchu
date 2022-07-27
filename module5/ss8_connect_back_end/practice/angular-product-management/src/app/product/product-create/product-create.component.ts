import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  // ko nen
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });

  constructor(private productService: ProductService, private router: Router) {
  }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.productForm);
    if (this.productForm.valid) {
      this.productForm.value.id = parseInt(this.productForm.value.id);
      this.productService.saveProduct(this.productForm.value).subscribe(data => {
      }, error => {
      }, () => {
        this.router.navigateByUrl('/list');
      });
    }
  }

  // submit() {
  //   const product = this.productForm.value;
  //   this.productService.saveProduct(product);
  //   this.productForm.reset();
  // }
}
