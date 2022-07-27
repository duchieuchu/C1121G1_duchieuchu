import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
   idModal: number;
   nameModal: string;
  p: number = 1;
  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customers = data;
    }, error => {
    });
  }

  deleteCustomer(idModal: number) {
    this.customerService.delete(this.idModal).subscribe(next => {
      // alert('OK');
      this.ngOnInit();
    });
  }

  mo(id: number, name: string) {
    this.idModal = id;
    this.nameModal = name;
  }
}
