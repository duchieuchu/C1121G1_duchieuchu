import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Base} from '../model/Base';
import {Employee} from '../model/employee';


@Injectable({
  providedIn: 'root'
})
export class BaseService {
  private URL_BASE = 'http://localhost:8080/base';

  constructor(private httpClient: HttpClient) {
  }

  getAllList(): Observable<Base[]> {
    return this.httpClient.get<Base[]>(this.URL_BASE + '/getAllBaseList');
  }

  getAllListEmloyee(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.URL_BASE + '/getAllEmployeeList');
  }
  search(nameBase: string): Observable<Base[]> {
    return this.httpClient.get<Base[]>(this.URL_BASE + '/searchList?name' + nameBase);
  }


  deleteBase(id: number): Observable<Base> {
    // @ts-ignore
    return this.httpClient.patch<Base>(this.URL_BASE + `/deleteBase/${id}`);
  }

  createBase(base: Base): Observable<Base> {
    return this.httpClient.post(this.URL_BASE + '/createBase', base);
  }

}
