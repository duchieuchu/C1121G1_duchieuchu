import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {
  productForm: FormGroup;

  constructor() {
  }

  ngOnInit(): void {
    this.getForm();
  }

  getForm() {
    this.productForm = new FormGroup({
      name: new FormControl(''),
      price: new FormControl('')
    });
  }

  log() {
    console.log(this.productForm);
  }

}
