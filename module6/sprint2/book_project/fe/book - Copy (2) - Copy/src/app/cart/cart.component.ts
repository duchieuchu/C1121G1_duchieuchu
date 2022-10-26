import {Component, OnInit} from '@angular/core';
import {Book} from '../model/book';
import {CartService} from '../service/cart.service';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  public books: any = [];
  public grandTotal !: number;

  constructor(private  cartService: CartService,
              private title: Title) {
    this.title.setTitle('Giỏ hàng');
  }

  ngOnInit(): void {
    this.cartService.getBooks().subscribe(res => {
      this.books = res;
      this.grandTotal = this.cartService.getTotalPrice();
    });
  }

  removeItem(item: any) {
    this.cartService.removeCartItems(item);
  }

  emptyCart() {
    this.cartService.removeAllCart();
  }

}
