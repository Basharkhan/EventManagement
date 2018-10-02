import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {Http,Headers} from '@angular/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _registerUrl = "http://localhost:8080/register"
  private _loginUrl = "http://localhost:8080/login/"
  constructor(private http: HttpClient) { }

  registerUser(user){
    return this.http.post<any>(this._registerUrl, user)
  }

  // login(user){
  //   return this.http.get<any>(this._loginUrl+user.username+'/'+user.password)    
  // }

  // saveEmployees(employee:Employee): Observable<Employee>{
  //   return this._http.post<Employee>(this.baseUrl, employee, this.httpOptions);    
  // }


  login(user){
    return this.http.get<any>('http://localhost:8080/login/'+user.username+'/'+user.password)
  }


  isLoggedIn(){
    if(sessionStorage.getItem('user'))
      return true
    else{      
      return false
    }
  }

}
