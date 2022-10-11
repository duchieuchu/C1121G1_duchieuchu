import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {Book} from '../../model/book';

@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {
  bookArray: Book[] = [];

  totalPages: number;
  countToTalPage: number[];
  number: number;
  size: number;

  constructor(private title: Title) {
    this.title.setTitle('Cửa hàng sách');
  }

  ngOnInit(): void {
  }

}
