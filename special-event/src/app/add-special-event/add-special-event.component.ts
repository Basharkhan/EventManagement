import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { RestService } from '../rest.service';
@Component({
  selector: 'app-add-special-event',
  templateUrl: './add-special-event.component.html',
  styleUrls: ['./add-special-event.component.css']
})
export class AddSpecialEventComponent implements OnInit {

  specialEventForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private rest: RestService) { }
  time = {hour: 13, minute: 30};
  ngOnInit() {
    this.specialEventForm = this.formBuilder.group({
      eventName: [''],
      eventAddress: [''],
      eventDescription: [''],
      url: [''],
      organizerName: [''],
      eventDate: [''],
      category: [''],
      country: [''],  
      subEvents: this.formBuilder.array([this.formBuilder.group({name: '', startTime: '', endTime: ''})])    
    })
  }

  addSubEvent() {
    this.subEvents.push(this.formBuilder.group({name: '', startTime: '', endTime: ''}))
  }

  get subEvents() {
    return this.specialEventForm.get('subEvents') as FormArray;
  }

  onSubmit() {
    console.log(this.specialEventForm.value);
    this.rest.saveSpecialEvent(this.specialEventForm.value)
      .subscribe(
        data => console.log("Success", data),
        error => console.log("Error", error)
      )
  }

  countries = [
    {name: "United States"},
    {name: "Bangladesh"},
    {name: "India"},
    {name: "Pakistan"},
    {name: "Australia"},
    {name: "Canada"},
    {name: "Brazil"},
    {name: "England"}
  ];

  categories = [
    {name: "Development"},
    {name: "Educational, Education"},
    {name: "Food"},
    {name: "IT, Technology, Artificial Intelligence, AI, Science"},
    {name: "Science"},
    {name: "Commerce"},
    {name: "Business"},
    {name: "Govnment"},
    {name: "Summit"},
    {name: "Conference"}
  ];

}
