import { Component, OnInit, EventEmitter, Output } from '@angular/core';


@Component({
 
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  @Output() messageEvent = new EventEmitter<string>();

  //@Output() searchCourse = new EventEmitter<void>();

  constructor() { }

  ngOnInit() {
  }

  message:string='';

  searchStatus=false;
  blur=true;

  onSearchClick(nameInput: HTMLInputElement){
this.message=nameInput.value;
this.searchStatus=!this.searchStatus;
this.blur=false;
//this.sendMessage();
  }

  onCloseClick(){
    
    this.searchStatus=false;
    this.blur=true;
      }

  sendMessage() {
    this.messageEvent.emit(this.message);
  }

  courses = [{courseName: 'AWS Developers', mentorName: 'Chandan', duration: 20, rating:4},{courseName: 'Spring', mentorName: 'Parth', duration: 30, rating:4},
  {courseName: 'AWS Architect', mentorName: 'Chandan', duration: 20, rating:3},{courseName: 'Mean', mentorName: 'Honey', duration: 25, rating:2},
  {courseName: 'Android', mentorName: 'Yogendra', duration: 20, rating:4},{courseName: 'Arduino', mentorName: 'Chandan', duration: 10, rating:1},
  {courseName: 'Python', mentorName: 'Anirban', duration: 20, rating:4},{courseName: 'Java', mentorName: 'Arushi', duration: 30, rating:4},
  {courseName: 'IT Infrastructure', mentorName: 'Chandan', duration: 40, rating:5},{courseName: 'Mathematics', mentorName: 'Rahul', duration: 20, rating:4}];



}
