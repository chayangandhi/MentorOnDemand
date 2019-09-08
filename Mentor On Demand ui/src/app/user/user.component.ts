import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  user = {
    email: '',
    password:''
  };
  
  loginStatus=true;
  signupStatus=false;

  onClickSignup(){
    this.loginStatus=false;
    this.signupStatus=true;
  }

  onClickLogin(){
this.loginStatus=true;
this.signupStatus=false;
  }



  login()
  {
      this.http.post("localhost:8081/admin/login",this.user).subscribe(resp=>{
        console.log(resp)
      });
  }
  

}

