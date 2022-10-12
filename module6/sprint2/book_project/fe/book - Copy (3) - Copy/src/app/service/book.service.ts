import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private BOOK_URL = 'http://localhost:8080/book';


  constructor() {
  }
}
