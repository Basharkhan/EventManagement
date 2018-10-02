import { Injectable } from '@angular/core';
import { HttpClient } from '../../node_modules/@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class EventService {
  private _specialEventsUrl = "http://localhost:8080/specialevents"
  private _generalEventsUrl = "http://localhost:8080/generalevents"
  constructor(private http:HttpClient) { }

  getSpecialEvents(){
    return this.http.get<any>(this._specialEventsUrl)
  }

  getGeneralEvent(){
    return this.http.get<any>(this._generalEventsUrl)
  }

}
