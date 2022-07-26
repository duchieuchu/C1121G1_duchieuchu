import {Injectable} from '@angular/core';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [
    {
      id: 1,
      name: 'Nguyễn Thị Hào',
      birthday: '1995-12-09',
      gender: 'Nữ',
      idCard: '202022012',
      phone: '0999999999',
      email: 'hao@gmail.com',
      address: '23 Nguyễn Hoàng, Đà Nẵng',
      customerType: 'Diamond'
    },
    {
      id: 2,
      name: 'Trần Đại Danh',
      birthday: '1970-11-07',
      gender: 'Nam',
      idCard: '202022012',
      phone: '0999999999',
      email: 'danh@gmail.com',
      address: 'K77/22 Thái Phiên, Quảng Trị',
      customerType: 'Gold'
    },
    {
      id: 3,
      name: 'Tôn Nữ Mộc Châu',
      birthday: '2005-12-06',
      gender: 'Nam',
      idCard: '202022012',
      phone: '0999999999',
      email: 'chau@gmail.com',
      address: '37 Yên Thế, Đà Nẵng',
      customerType: 'Diamond'
    },
    {
      id: 4,
      name: 'Nguyễn Mỹ Kim',
      birthday: '1984-04-08',
      gender: 'Nữ',
      idCard: '202022012',
      phone: '0999999999',
      email: 'kim@gmail.com',
      address: 'K123/45 Lê Lợi, Hồ Chí Minh',
      customerType: 'Diamond'
    }
    // {id: 5, name: '', birthday: '', gender: '', idCard: '', phone: '', email: '', address: ''},
    // {id: 6, name: '', birthday: '', gender: '', idCard: '', phone: '', email: '', address: ''},
  ];

  constructor() {
  }

  getAllCustomer() {
    return this.customers;
  }

  saveCustomer(customer) {
    this.customers.push(customer);
  }

  findById(id: number) {
    let customerNeedFind: Customer;
    for (const customer of this.customers) {
      if (customer.id === id) {
        customerNeedFind = customer;
      }
    }
    return customerNeedFind;
  }

  edit(value: Customer) {
    console.log(value);
    for (let i = 0; i < this.customers.length; i++) {
      console.log(this.customers[i]);
      if (this.customers[i].id === value.id) {
        this.customers[i] = value;
        console.log(this.customers[i]);
      }
    }
  }

  delete(id: number) {
    for (let i = 0; i < this.customers.length; i++) {
      if (this.customers[i].id === id) {
        for (let j = i; j < this.customers.length; j++) {
          this.customers[j] = this.customers[j + 1];
        }
        this.customers.pop();
      }
    }
  }
}
