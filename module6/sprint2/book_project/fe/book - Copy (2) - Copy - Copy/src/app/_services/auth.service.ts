import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TokenStorageService} from './token-storage.service';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;

  constructor(private http: HttpClient,
              private tokenStorageService: TokenStorageService) {
  }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(user): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password
    }, httpOptions);
  }

  isAdminLoggedIn() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    const user = this.tokenStorageService.getUser();
    this.roles = user.roles;
    if (this.isLoggedIn && this.roles.includes('ROLE_ADMIN')) {
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    const user = this.tokenStorageService.getUser();
    this.roles = user.roles;
    if (this.isLoggedIn && this.roles.includes('ROLE_USER')) {
      return true;
    } else {
      return false;
    }
  }

  isLogIn() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      return true;
    } else {
      return false;
    }
  }
}
