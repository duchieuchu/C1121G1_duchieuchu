import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SocialService {
  private BOOK_URL = 'http://localhost:8080/api/auth';

  constructor(private httpClient: HttpClient) {
  }

  loginWithGoogle(token): Observable<any> {
    return this.httpClient.post(`${this.BOOK_URL}google`, {token}).pipe(
      map(
        response => {
          return response;
        }
      )
    );
  }

  loginWithFacebook(token): Observable<any> {
    return this.httpClient.post(`${this.BOOK_URL}google`, {token}).pipe(
      map(
        response => {
          return response;
        }
      )
    );
  }


}
