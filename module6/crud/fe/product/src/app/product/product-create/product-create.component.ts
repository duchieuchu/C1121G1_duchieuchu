import {Component, OnInit} from '@angular/core';
import {Base} from '../../model/base';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  base: Base;


  constructor() {
  }

  ngOnInit(): void {
  }

}
