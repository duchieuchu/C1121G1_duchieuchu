import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private BOOK_URL = 'http://localhost:8080/book/';

  constructor(private httpClient: HttpClient) {
  }

  // getAllPageBookByName()
//  getDishPage(page: number,dishName:string,dishCode:String,dishPrice:string,dishTypeId:string): Observable<Dish[]> {
//
//     return this.httpClient.get<Dish[]>(this.URL_DISH + "/searchDish?page="
//       + page+"&dishName="+dishName+"&dishCode="+dishCode+"&dishPrice="+dishPrice+"&dishTypeId="+dishTypeId,
//       {headers: new HttpHeaders({'authorization': this.header})});
//   }
}
