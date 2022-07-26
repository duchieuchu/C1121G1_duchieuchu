import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Todo} from '../model/todo';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private URL_TODO = 'http://localhost:3000/todo';
  todos: Todo[] = [];

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(this.URL_TODO);
  }

  saveTodo(todo: Todo) {
    return this.httpClient.post(this.URL_TODO, todo);
  }

  deleteTodo(id: number) {
    return this.httpClient.delete<Todo>(this.URL_TODO + '/' + id);
  }
}
