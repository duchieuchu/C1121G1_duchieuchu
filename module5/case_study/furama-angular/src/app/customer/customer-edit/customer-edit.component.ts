import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Customer} from '../../model/customer';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  editCustomerFormGroup: FormGroup;
  customer: Customer;
  idEditCustomer: number;

  constructor(private activatedRoute: ActivatedRoute, private customerService: CustomerService, private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.idEditCustomer = parseInt(param.get('id'));
      this.customerService.getCustomerById(this.idEditCustomer).subscribe(customer => {
        this.editCustomerFormGroup = new FormGroup({
          id: new FormControl(customer.id),
          name: new FormControl(customer.name),
          birthday: new FormControl(customer.birthday),
          gender: new FormControl(customer.gender),
          idCard: new FormControl(customer.idCard),
          phone: new FormControl(customer.phone),
          email: new FormControl(customer.email),
          address: new FormControl(customer.address),
          customerType: new FormControl(customer.customerType)
        });
      });
    });
    // this.editCustomerFormGroup = new FormGroup({
    //   id: new FormControl(this.customer.id),
    //   name: new FormControl(this.customer.name),
    //   birthday: new FormControl(this.customer.birthday),
    //   gender: new FormControl(this.customer.gender),
    //   idCard: new FormControl(this.customer.idCard),
    //   phone: new FormControl(this.customer.phone),
    //   email: new FormControl(this.customer.email),
    //   address: new FormControl(this.customer.address),
    //   customerType: new FormControl(this.customer.customerType)
    // });
  }

  submitEdit(id: number) {
    const customer = this.editCustomerFormGroup.value;
    this.customerService.editCustomer(id, customer).subscribe(next => {
      this.router.navigateByUrl('/customer-list').then();
    });
  }

  // submitEdit() {
  //   this.customerService.edit(this.editCustomerFormGroup.value);
  //   this.router.navigateByUrl('customer-list').then();
  // }
}
