import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Book} from '../model/book';
import {Observable} from 'rxjs';
import {Category} from '../model/category';


@Injectable({
  providedIn: 'root'
})
export class BookService {
  private URL_PIGSTY = 'http://localhost:8080/book/';

  constructor(private http: HttpClient) {
  }

  createPigsty(book: Book): Observable<Book> {
    return this.http.post(this.URL_PIGSTY + '/createBook', book);
  }

  getAllProduct(): Observable<Book[]> {
    return this.http.get<Book[]>(this.URL_PIGSTY + '/getAllBook');
  }

  getAllCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(this.URL_PIGSTY + '/getAllCategory');
  }

}
