import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private BOOK_URL = 'http://localhost:8080/book/';

  constructor(private httpClient: HttpClient) {
  }

  getAllPageBookByName(page: number, bookName: string): Observable<Book[]> {
    return this.httpClient.get<Book[]>(this.BOOK_URL + '/getAllPageBookByName?page='
      + page + '&bookName=' + bookName);
  }
}
