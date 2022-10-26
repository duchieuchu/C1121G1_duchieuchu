import {Component, OnInit} from '@angular/core';
import {Book} from '../../model/book';
import {Title} from '@angular/platform-browser';
import {FormControl, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {BookService} from '../../service/book.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-book-management',
  templateUrl: './book-management.component.html',
  styleUrls: ['./book-management.component.css']
})
export class BookManagementComponent implements OnInit {
  bookArray: Book[] = [];
  categoryArray: Category[] = [];

  searchForm: FormGroup;
  totalPages: number;
  countTotalPages: number[];
  number: number;
  size: number;

  constructor(private title: Title,
              private bookService: BookService,
              private toast: ToastrService,
              private router: Router) {
    this.title.setTitle('Quản lí sách');
  }

  ngOnInit(): void {
    this.getBookPage(0, '');
    this.createSearchForm();
  }

  createSearchForm() {
    this.searchForm = new FormGroup({
      bookName: new FormControl()
    });
  }

  searchBook() {
    this.getBookPage(0, this.searchForm.value.bookName);
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

  deleteBookById(bookId: number) {
    this.bookService.deleteBookById(bookId).subscribe(data => {

    }, error => {

    }, () => {
      this.ngOnInit();
      // this.router.navigateByUrl('/book/management').then(r => this.toast.success('Xóa thành công.', 'Thông Báo'));
      this.toast.success('Xóa thành công.', 'Thông Báo');
    });

  }
}
