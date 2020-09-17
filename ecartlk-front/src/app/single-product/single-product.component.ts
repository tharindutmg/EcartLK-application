import { AfterViewInit, Component, ElementRef, ViewChild, OnInit } from '@angular/core';
//import $ from 'jquery';
import * as $ from 'jquery';
declare var $: any;
import 'magnific-popup';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent implements OnInit {


 

  constructor() { }

  ngOnInit() {
    $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
    });
  }
  
}
