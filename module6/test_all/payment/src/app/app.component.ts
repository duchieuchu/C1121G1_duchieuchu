import {Component} from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'payment';

  constructor() {
    render({
      id: '#myPayPalButtons',
      currency: 'USD',
      value: '10',
      onApprove: (details => {
        alert('Transaction Successfully');
      })
    });
  }
}
