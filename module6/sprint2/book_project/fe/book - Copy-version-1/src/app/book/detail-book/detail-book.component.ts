import {Component, OnInit} from '@angular/core';
import {BookService} from '../../service/book.service';
import {Book} from '../../model/book';
import {Title} from '@angular/platform-browser';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {FormControl, FormGroup} from '@angular/forms';
import {CartService} from '../../service/cart.service';
import {DataService} from '../../service/data.service';

@Component({
  selector: 'app-detail-book',
  templateUrl: './detail-book.component.html',
  styleUrls: ['./detail-book.component.css']
})
export class DetailBookComponent implements OnInit {
  public book: Book;

  carts: any = this.cartService.getCart();

  constructor(private bookService: BookService,
              private title: Title,
              private activatedRoute: ActivatedRoute,
              private toast: ToastrService,
              private router: Router,
              private cartService: CartService,
              private dataService: DataService) {
    this.title.setTitle('Chi tiết sách');
  }

  ngOnInit(): void {
    this.getParamId();
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
    }

    this.cartService.saveCart(this.carts);
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });

  }
  getParamId() {
    this.activatedRoute.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      this.bookService.getBookById(+id).subscribe(data => {
        if (data == null) {
          this.toast.error('Thao tác của bạn không đúng nên đã quay lại danh sách.', 'Thông Báo');
          this.router.navigateByUrl('/book/management').then();
        }
        this.book = data;

      });
    });
  }


}
