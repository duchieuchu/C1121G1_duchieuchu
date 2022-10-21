import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../model/book';
import {Category} from '../model/category';


@Injectable({
  providedIn: 'root'
})
export class BookService {
  private BOOK_URL = 'http://localhost:8080/api/test';

  constructor(private httpClient: HttpClient) {
  }

  getAllBook(page: number, bookName: string): Observable<Book[]> {
    return this.httpClient.get<Book[]>(
      this.BOOK_URL + '/getAllPageBookByName?page=' + page + '&bookName=' + bookName);
  }

  getBookById(bookId: number): Observable<Book> {
    return this.httpClient.get<Book>(this.BOOK_URL + '/getBookById/' + bookId);
  }

  createBook(book: Book): Observable<Book> {
    return this.httpClient.post<Book>(this.BOOK_URL + '/createBook', book);
  }

  getAllCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.BOOK_URL + '/getAllCategory');
  }

  deleteBookById(bookId: number): Observable<void> {
    // @ts-ignore
    return this.httpClient.patch(this.BOOK_URL + '/deleteBookById/' + bookId);
  }

  editBook(book: Book): Observable<Book> {
    return this.httpClient.patch(this.BOOK_URL + '/editBook', book);
  }

}
