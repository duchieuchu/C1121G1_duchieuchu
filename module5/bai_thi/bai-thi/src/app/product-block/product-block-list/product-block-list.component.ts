import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductBlockService} from '../../service/product-block.service';
import {ProductBlock} from '../../model/product-block';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-block-list',
  templateUrl: './product-block-list.component.html',
  styleUrls: ['./product-block-list.component.css']
})
export class ProductBlockListComponent implements OnInit {
  products: Product[];
  productBlocks: ProductBlock[] = [];
  idModal: number;
  nameModal: string;
  p: number = 1;
  searchForm: FormGroup;

  constructor(private productBlockService: ProductBlockService, private productService: ProductService) {
    this.searchForm = new FormGroup({
      searchName: new FormControl()
    });
  }

  ngOnInit(): void {
    this.getAll();
    this.getAllProduct();
  }

  getAll() {
    this.productBlockService.getAllProductBlock().subscribe(data => {
      this.productBlocks = data;
      console.log(data);
    }, error => {
    });
  }

  getAllProduct() {
    this.productService.getAll().subscribe(products => {
      this.products = products;
    });
  }

  deleteProductBlock(idModal: number) {
    this.productBlockService.delete(idModal).subscribe(next => {
      // @ts-ignore
      $('#exampleModal' + idModal).modal('hide');
    }, error => {
    }, () => {
      this.ngOnInit();
    });
  }

  mo(id: number, name: string) {
    this.idModal = id;
    this.nameModal = name;
  }

  searchByName() {
    console.log(this.searchForm.value);
    this.productBlockService.getAllProductBlockByName(this.searchForm.value.searchName).subscribe(data => {
      this.productBlocks = data;
    });
  }
}
