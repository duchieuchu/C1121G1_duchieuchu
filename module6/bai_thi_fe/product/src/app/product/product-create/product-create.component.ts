import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productTypeArray: Category[] = [];
  product: Product;
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    code: new FormControl('', ),
    name: new FormControl('', ),
    price: new FormControl('', ),
    status: new FormControl('', ),
    importDate: new FormControl('', ),
    categoryId: new FormControl(''),

    made: new FormControl('' ),
    gas: new FormControl('' ),

    sweat: new FormControl('' ),

    author: new FormControl('' ),
    typeBook: new FormControl('' ),
    publicationDate: new FormControl('' ),
  });

  constructor(private productService: ProductService, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllCategory();
    this.getInfo();
  }

  getAllCategory() {
    this.productService.getAllCategory().subscribe(categorys => {
      this.productTypeArray = categorys;
    });
  }

  submit() {
    let product=this.productForm.value;
    this.productService.saveProduct(product).subscribe(data => {
    }, error => {
    }, () => {
      this.router.navigateByUrl('/product/list');
    });
    console.log(product)
  }

  getInfo() {
    let value = $('#categoryId').val();
    if (value === '') {
      $('#code').hide();
      $('#name').hide();
      $('#price').hide();
      $('#importDate').hide();
      $('#category').hide();
      $('#status').hide();

      $('#gas').hide();
      $('#made').hide();

      $('#sweat').hide();

      $('#typeBook').hide();
      $('#publicationDate').hide();
      $('#author').hide();
    }
    if (value === '1') {
      $('#code').show();
      $('#name').show();
      $('#price').show();
      $('#importDate').show();
      $('#category').show();
      $('#status').show();

      $('#gas').show();
      $('#made').show();

      $('#sweat').hide();

      $('#typeBook').hide();
      $('#publicationDate').hide();
      $('#author').hide();
    }
    if (value === '2') {
      $('#code').show();
      $('#name').show();
      $('#price').show();
      $('#importDate').show();
      $('#category').show();
      $('#status').show();

      $('#gas').hide();
      $('#made').show();

      $('#sweat').show();

      $('#typeBook').hide();
      $('#publicationDate').hide();
      $('#author').hide();
    }
    if (value === '3') {
      $('#code').show();
      $('#name').show();
      $('#price').show();
      $('#importDate').show();
      $('#category').show();
      $('#status').show();

      $('#gas').hide();
      $('#made').hide();

      $('#sweat').hide();

      $('#typeBook').show();
      $('#publicationDate').show();
      $('#author').show();
    }
  }
}
