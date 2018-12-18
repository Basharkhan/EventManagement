import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { eventNames } from 'cluster';

@Component({
  selector: 'app-show-special-event',
  templateUrl: './show-special-event.component.html',
  styleUrls: ['./show-special-event.component.css']
})
export class ShowSpecialEventComponent implements OnInit {

  selected: []
  specialEvents = []
  constructor(private rest: RestService) { }  


  ngOnInit() {
    this.rest.getSpecialEvents()
      .subscribe(
        data => this.specialEvents = data,
        error => console.log(error)
        )
  }


  getSelectedCategories() {
    this.specialEvents.forEach(event => {
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

}
