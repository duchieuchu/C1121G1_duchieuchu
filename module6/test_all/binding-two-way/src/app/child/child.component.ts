import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent  {
@Output() goToParent = new EventEmitter<String>()

  addInfo(value: string){
  this.goToParent.emit(value)
  }
  constructor() { }

  ngOnInit(): void {
  }

}
