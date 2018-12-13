import { Component } from '@angular/core';
import { Headers, Http} from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private http: Http) {}

  chargeCreditCard() {
    let form = document.getElementsByTagName("form")[0];
    (<any>window).Stripe.card.createToken({
      number: form.cardNumber.value,
      exp_month: form.expMonth.value,
      exp_year: form.expYear.value,
      cvc: form.cvc.value
    }, (status: number, response: any) => {
      if (status === 200) {
        let token = response.id;
        this.chargeCard(token);
      } else {
        console.log(response.error.message);
      }
    });
  }
  
  chargeCard(token: string) {
    const headers = new Headers({'token': token, 'amount': 200});
    this.http.post('http://localhost:8080/payment/charge', {}, 
    {headers: headers}).subscribe(
      resp => console.log(resp)
    )
  }

  hello() {
    this.http.get('http://localhost:8080/payment/get')
  }

}
