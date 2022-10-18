import {Component, OnInit} from '@angular/core';
import {Book} from '../../model/book';
import {Category} from '../../model/category';
import {FormControl, FormGroup} from '@angular/forms';
import {BookService} from '../../service/book.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AngularFireStorage} from '@angular/fire/storage';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {
  book: Book;
  categoryArray: Category[] = [];

  formBook = new FormGroup({
    bookName: new FormControl(),
    description: new FormControl(),
    price: new FormControl(),
    image: new FormControl(),
    pageNumber: new FormControl(),
    authors: new FormControl(),
    publishingHouse: new FormControl(),
    category: new FormControl(),
  });

  constructor(private bookService: BookService,
              private  router: Router,
              private toast: ToastrService,
              private storage: AngularFireStorage) {
  }

  ngOnInit(): void {
    this.getAllCategory();
  }

  createBook() {
    this.bookService.createBook(this.formBook.value).subscribe(data => {

    }, error => {

    }, () => {
      this.router.navigateByUrl('book/management').then(r => this.toast.success('Thêm mới thành công.', 'Thông Báo'));
    });
  }

  getAllCategory() {
    this.bookService.getAllCategory().subscribe((data) => {
      this.categoryArray = data;
    }, error => {
    }, () => {
      console.log(this.categoryArray);
    });
  }

}
