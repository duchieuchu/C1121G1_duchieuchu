import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {Book} from '../../model/book';
import {FormControl, FormGroup} from '@angular/forms';
import {BookService} from '../../service/book.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

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

  constructor(private title: Title,
              private bookService: BookService) {
    this.title.setTitle('Cửa hàng sách');
  }

  ngOnInit(): void {
    this.getBookPage(0, '');
    this.createSearchForm();
    // this.getAllDishType();
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
