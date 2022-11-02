import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {Book} from '../../model/book';
import {FormControl, FormGroup} from '@angular/forms';
import {BookService} from '../../service/book.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {CartService} from '../../service/cart.service';
import {DataService} from '../../service/data.service';

@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {
  bookArray: Book[] = [];

  searchForm: FormGroup;
  totalPages: number;
  countTotalPages: number[];
  number: number;
  size: number;

  carts: any = this.cartService.getCart();
  constructor(private title: Title,
              private bookService: BookService,
              private cartService: CartService,
              private dataService: DataService) {
    this.title.setTitle('Cửa hàng sách');
  }

  ngOnInit(): void {
    this.getBookPage(0, '');
    this.createSearchForm();

    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  onAddToCart(book: any) {
    const index = this.carts.findIndex((item: any) => {
      return item.id === book.id;
    });

    if (index >= 0) {
      this.carts[index].quantity += 1;
    } else {
      const cartItem: any = {
        id: book.id,
        bookName: book.bookName,
        price: book.price,
        quantity: 1,
        image: book.image,
      };
      this.carts.push(cartItem);
      console.log(cartItem);
    }

    this.cartService.saveCart(this.carts);
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });

  }



  createSearchForm() {
    this.searchForm = new FormGroup({
      bookName: new FormControl()
    });
  }


  getBookPage(page: number, bookName: string) {
    this.bookService.getAllBook(page, bookName).subscribe((data: Book[]) => {
      if (data !== null) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
        // @ts-ignore
        this.bookArray = data.content;
        this.bookArray.forEach((book: Book) => {
          Object.assign(book, {quantity: 1, total: book.price});
        });
        // @ts-ignore
        this.size = data.size;
      } else {
        this.bookArray = [];
      }
    }, error => {
      console.log(error);
    });
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getBookPage(numberPage, this.searchForm.value.bookName);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getBookPage(numberPage, this.searchForm.value.bookName);
    }
  }

  goItem(i: number) {
    this.getBookPage(i, this.searchForm.value.bookName);
  }

  goStart() {
    this.getBookPage(0, this.searchForm.value.bookName);
  }

  goEnd() {
    this.getBookPage(this.totalPages - 1, this.searchForm.value.bookName);
  }


}
