import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {
  private _url = "http://localhost:8080/add-special-event";
  private _specialEventsUrl = "http://localhost:8080/specialevents";
  private _checkConflict = "http://localhost:8080/check-conflict";

  constructor(private http: HttpClient) { }

  saveSpecialEvent(event) {
    return this.http.post(this._url, event);
  }

  getSpecialEvents() {
    return this.http.get<any>(this._specialEventsUrl);
  }

  checkConflict(event) {
    return this.http.post(this._checkConflict, event)
  }

}
