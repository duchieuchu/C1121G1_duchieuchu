import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {
  customerForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    birthday: new FormControl(),
    gender: new FormControl(),
    idCard: new FormControl(),
    phone: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    customerType: new FormControl()
  });

  constructor(private customerService: CustomerService, private router: Router) {
  }

  ngOnInit(): void {
  }

  submit() {
    if (this.customerForm.valid) {
      this.customerForm.value.id = parseInt(this.customerForm.value.id);
      this.customerService.saveCustomer(this.customerForm.value).subscribe(data => {
      }, error => {
      }, () => {
        this.router.navigateByUrl('/customer-list');
      });
    }
  }

  // submit() {
  //   const customer = this.customerForm.value;
  //   this.customerService.saveCustomer(customer);
  //   this.customerForm.reset();
  // }

}
