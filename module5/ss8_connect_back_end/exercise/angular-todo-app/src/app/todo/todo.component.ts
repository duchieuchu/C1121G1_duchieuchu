import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Todo} from '../model/todo';
import {TodoService} from '../service/todo.service';

// tslint:disable-next-line:variable-name
let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();

  constructor(private todoService: TodoService) {
  }

  ngOnInit(): void {
    this.todoService.getAll().subscribe(data => {
      this.todos = data;
    }, error => {
    });
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: this.todos.length + 1,
        content: value,
        complete: false
      };
      this.todoService.saveTodo(todo).subscribe(() => {
        this.content.reset();
        this.ngOnInit();
      });
    }
  }

  deleteTodo(id: number) {
    this.todoService.deleteTodo(id).subscribe(value => {
      this.ngOnInit();
    });
  }
}
