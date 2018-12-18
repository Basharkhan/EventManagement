import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { SpecialEvent } from '../special-event';

@Component({
  selector: 'app-checkbox-database',
  templateUrl: './checkbox-database.component.html',
  styleUrls: ['./checkbox-database.component.css']
})
export class CheckboxDatabaseComponent implements OnInit {  
  specialEvent: SpecialEvent;
  constructor(private rest: RestService) { }
  selected: []

  ngOnInit() {
    this.rest.getSpecialEvents()
      .subscribe(
        data => this.specialEvent = data,
      )
  }

  getSelectedCategories() {
    this.specialEvent.forEach(event => {
      const selectedSubEvents = event.subEvents;
      this.selected = selectedSubEvents.filter(s => s.selected);
      console.log(this.selected);
    });
    this.rest.checkConflict(this.selected)
    .subscribe(
      res => console.log('Success', res),
      err => console.log('Falied', err)
    )

  }  

  // checkConflict() {
  //     this.rest.checkConflict(this.selected)
  //       .subscribe(
  //         res => console.log('Success', res),
  //         err => console.log('Falied', err)
  //       )
  // }

}
