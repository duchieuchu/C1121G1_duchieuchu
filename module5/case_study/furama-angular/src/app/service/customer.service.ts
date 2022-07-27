import {Injectable} from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [];
  private URL_CUSTOMER = 'http://localhost:3000/customer';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.URL_CUSTOMER);
  }

  saveCustomer(customer: Customer) {
    return this.httpClient.post<Customer>(this.URL_CUSTOMER, customer);
  }

  delete(id: number): Observable<Customer> {
    return  this.httpClient.delete<Customer>(this.URL_CUSTOMER + '/' + id);
  }

  getCustomerById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.URL_CUSTOMER + '/' + id);
  }

  editCustomer(id: number, customer: Customer) {
    return this.httpClient.patch(this.URL_CUSTOMER + '/' + id, customer);
  }

  // saveCustomer(customer) {
  //   this.customers.push(customer);
  // }

  // findById(id: number) {
  //   let customerNeedFind: Customer;
  //   for (const customer of this.customers) {
  //     if (customer.id === id) {
  //       customerNeedFind = customer;
  //     }
  //   }
  //   return customerNeedFind;
  // }

  // edit(value: Customer) {
  //   console.log(value);
  //   for (let i = 0; i < this.customers.length; i++) {
  //     console.log(this.customers[i]);
  //     if (this.customers[i].id === value.id) {
  //       this.customers[i] = value;
  //       console.log(this.customers[i]);
  //     }
  //   }
  // }


  // delete(id: number) {
  //   for (let i = 0; i < this.customers.length; i++) {
  //     if (this.customers[i].id === id) {
  //       for (let j = i; j < this.customers.length; j++) {
  //         this.customers[j] = this.customers[j + 1];
  //       }
  //       this.customers.pop();
  //     }
  //   }
  // }
}
