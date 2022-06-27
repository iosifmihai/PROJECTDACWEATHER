import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  name : string ='';
  username : string ='';
  password : string ='';

  user : User = new User(); 

  constructor(private authService : AuthService) { }

  ngOnInit(): void {
  }

  signup()
  {
    this.user.username = this.username;
    this.user.password = this.password;
    this.user.name = this.name;
  }
}
