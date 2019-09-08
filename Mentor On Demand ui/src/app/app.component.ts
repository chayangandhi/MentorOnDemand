import { Component } from '@angular/core';
import { LoginStatusService } from 'src/app/login-status.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Mentor On Demand';
  constructor(private userStatus:LoginStatusService) { }

user=true;
mentor=false;
admin=false;

searchStatus=true;

loginCheck:boolean=false;
fromUser(){
this.loginCheck=this.userStatus.getLoginStatus();
}

onUserClick(){
  this.user=!this.user;
  this.mentor=false;
  this.admin=false;
  this.searchStatus=false;
}

onMentorClick(){
  this.user=false;
  this.mentor=!this.mentor;
  this.admin=false;
  this.searchStatus=false;
}

onAdminClick(){
  this.user=false;
  this.mentor=false;
  this.admin=!this.admin;
  this.searchStatus=false;
}




}
