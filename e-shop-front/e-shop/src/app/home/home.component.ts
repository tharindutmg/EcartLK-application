import { Component, OnInit, AfterViewInit } from '@angular/core';


declare function navigation():any;
  

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  
  ngAfterViewInit(): void {

    navigation(); // nawigation lode by this method
  }

  

  constructor() {
    
    
   }

  ngOnInit() {

    

  }

}
