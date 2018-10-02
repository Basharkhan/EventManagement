import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerUserData = {};
  username: string;
  email: string;
  password: string
  constructor(private _auth: AuthService, private router: Router) { }

  ngOnInit() {
  }

  registerUser(){
    const user = {
      username: this.username,
      email: this.email,
      password: this.password
    }

    this._auth.registerUser(user).subscribe(
      data => {
        if(data == "ok"){
          this.router.navigate(['/login'])          
        }
        else{
          alert("User already exist")
        }
      }
    )
  }

}
