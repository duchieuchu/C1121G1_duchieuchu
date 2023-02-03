import {Component, OnInit} from '@angular/core';
import {BookService} from '../service/book.service';
import {Book} from '../model/book';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  bookArray: Book[] = [];

  constructor(private bookService: BookService) {
  }

  ngOnInit(): void {
  }

  getAll() {
    this.bookService.getAllProduct().subscribe(data => {
      this.bookArray = data;
      console.log(data);
    }, error => {
    });
  }
}
