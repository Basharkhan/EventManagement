import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUserData = {}
  username: string;
  password: string;

  constructor(private router: Router, private authService: AuthService) { }  
  ngOnInit() {
  }

  loginUser(){
    const user = {
      username : this.username,
      password : this.password
    }
  
    this.authService.login(user).subscribe(
        data =>{
          if(data._body == ""){
            alert("Incorrect username or password")
          }
          else {
            sessionStorage.setItem('user', JSON.stringify(data))
            this.router.navigate(['/specialevents'])
          }
        }
      )
  }

}
