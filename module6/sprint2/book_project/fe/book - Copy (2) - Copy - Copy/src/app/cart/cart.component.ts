import {Component, OnInit} from '@angular/core';
import {Book} from '../model/book';
import {CartService} from '../service/cart.service';
import {Title} from '@angular/platform-browser';
import {DataService} from '../service/data.service';
import {render} from 'creditcardpayments/creditCardPayments';
import {TokenStorageService} from '../_services/token-storage.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  carts: any = [];
  book: Book;

  totalPrice: number = this.cartService.getTotalPrice();
  totalQuantity: number = this.cartService.getTotalQuantity();
  usd: number;
  usdString: string;

  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;

  constructor(private  cartService: CartService,
              private dataService: DataService,
              private tokenStorageService: TokenStorageService,
              private title: Title) {
    render({
      id: '#myPayPalButtons',
      currency: 'USD',
      value: this.convertToUSD(this.totalPrice),
      onApprove: (details => {
        alert('Transaction Successfully');
      })
    });
    this.title.setTitle('Giỏ hàng');
  }

  convertToUSD(vnd: number) {
    this.usd = vnd / 25000;
    this.usdString = String(this.usd);
    return this.usdString;
  }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
    }

    // tslint:disable-next-line:variable-name
    const _this = this;
    setTimeout(() => {
      _this.dataService.changeData({
        quantity: _this.cartService.getTotalQuantity()
      });
    }, 1);
    this.carts = this.cartService.getCart();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  total(cart: any) {
    return cart.quantity * cart.price;
  }

  updateQuantity(index: number, event: any) {
    let quantity = parseInt(event.target.value, 10);
    quantity = quantity > 0 ? quantity : 1;
    quantity = quantity <= 999 ? quantity : 999;
    event.target.value = quantity;
    this.carts[index].quantity = quantity;
    this.cartService.saveCart(this.carts);
    this.totalPrice = this.cartService.getTotalPrice();
    this.totalQuantity = this.cartService.getTotalQuantity();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  decrease(index: number, quantity: any) {
    let decreaseQuantity = parseInt(quantity, 10) - 1;
    decreaseQuantity = decreaseQuantity > 0 ? decreaseQuantity : 1;
    this.carts[index].quantity = decreaseQuantity;
    this.cartService.saveCart(this.carts);
    this.totalPrice = this.cartService.getTotalPrice();
    this.totalQuantity = this.cartService.getTotalQuantity();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  increase(index: number, quantity: any) {
    let increaseQuantity = parseInt(quantity, 10) + 1;
    increaseQuantity = increaseQuantity <= 999 ? increaseQuantity : 999;
    this.carts[index].quantity = increaseQuantity;
    this.cartService.saveCart(this.carts);
    this.totalPrice = this.cartService.getTotalPrice();
    this.totalQuantity = this.cartService.getTotalQuantity();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  deleteCart(index: number) {
    // tslint:disable-next-line:variable-name
    const _this = this;
    _this.carts.splice(index, 1);
    _this.cartService.saveCart(_this.carts);
    this.totalPrice = this.cartService.getTotalPrice();
    this.totalQuantity = this.cartService.getTotalQuantity();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  deleteAll() {
    sessionStorage.clear();
    this.carts = [];
    // this.carts.saveCart(this.carts);
    this.totalPrice = this.cartService.getTotalPrice();
    this.totalQuantity = this.cartService.getTotalQuantity();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

}
