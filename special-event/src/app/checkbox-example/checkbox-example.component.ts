import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { SpecialEvent } from '../special-event';

@Component({
  selector: 'app-checkbox-example',
  templateUrl: './checkbox-example.component.html',
  styleUrls: ['./checkbox-example.component.css']
})
export class CheckboxExampleComponent implements OnInit {

  students = [{id: 1, name: 'James', address: 'Dhaka', selected: false}, 
              {id: 2, name: 'James', address: 'Dhaka', selected: false}, 
              {id: 3, name: 'John', address: 'Dhaka', selected: false}];

  specialEvents: []

  constructor(private rest: RestService) { }

  ngOnInit() {
    this.rest.getSpecialEvents()
      .subscribe(
        data => this.specialEvents = data,
        err => console.log(err)
      )
  }

  getSelectedCategories() {
  //specialEvents: SpecialEvent;
      const selected = this.students.filter(c => c.selected);
    console.log(selected);
  }

}
