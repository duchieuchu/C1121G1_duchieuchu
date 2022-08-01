import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProductBlockService} from '../../service/product-block.service';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product-block-create',
  templateUrl: './product-block-create.component.html',
  styleUrls: ['./product-block-create.component.css']
})
export class ProductBlockCreateComponent implements OnInit {
  products: Product[];
  productBlockForm: FormGroup = new FormGroup({
    id: new FormControl(),
    // code: new FormControl(),
    // product: new FormControl(),
    // quantity: new FormControl(),
    // dateImport: new FormControl(),
    // dateDo: new FormControl(),
    // dateNoUse: new FormControl(),
    code: new FormControl('', [Validators.required, Validators.pattern('^LH-\\d{4}$')]),
    product: new FormControl('', [Validators.required]),
    quantity: new FormControl('', [Validators.required, Validators.min(0)]),
    dateImport: new FormControl('', [Validators.required]),
    dateDo: new FormControl('', [Validators.required]),
    dateNoUse: new FormControl('', [Validators.required]),
  });

  constructor(private productBlockService: ProductBlockService, private router: Router, private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.getAll().subscribe(products => {
      this.products = products;
    });
  }

  submit() {
    if (this.productBlockForm.valid) {
      // tslint:disable-next-line:radix
      this.productBlockForm.value.id = parseInt(this.productBlockForm.value.id);
      this.productBlockService.saveProductBlock(this.productBlockForm.value).subscribe(data => {
      }, error => {
      }, () => {
        this.router.navigateByUrl('/product-block-list');
      });
    }
  }

}
