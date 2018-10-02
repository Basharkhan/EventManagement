import { Component, OnInit } from '@angular/core';
import { EventService } from '../event.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {
  private events = []
  constructor(private _eventService:EventService) { }

  ngOnInit() {
    this._eventService.getGeneralEvent().subscribe(
      res => {this.events = res, console.log(this.events)},
      err => console.log(err)
    )
  }

}
