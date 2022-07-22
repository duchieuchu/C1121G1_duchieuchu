import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1: number;
  number2: number;
  result: string;

  addition(number1: number, number2: number): string {
    return (Number(number1) + Number(number2)).toString();
  }

  subtraction(number1: number, number2: number): string {
    return (Number(number1) - Number(number2)).toString();
  }

  multiplication(number1: number, number2: number): string {
    return (Number(number1) * Number(number2)).toString();
  }

  division(number1: number, number2: number): string {
    return (Number(number1) / Number(number2)).toString();
  }

  calculator(s: string, number1: number, number2: number) {
    switch (s) {
      case '+':
        this.result = this.addition(number1, number2);
        break;
      case '-':
        this.result = this.subtraction(number1, number2);
        break;
      case 'x':
        this.result = this.multiplication(number1, number2);
        break;
      case '/':
        if (number2 === 0) {
          this.result = 'Unknown';
        } else {
          this.result = this.division(number1, number2);
        }
        break;
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
