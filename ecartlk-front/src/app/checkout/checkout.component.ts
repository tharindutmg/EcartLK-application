import { Component, OnInit } from '@angular/core';

import * as $ from 'jquery';
declare var $: any;
import 'magnific-popup';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor() { }

  ngOnInit() {

    $('.close3').on('click', function (c) {
      $('.rem3').fadeOut('slow', function (c) {
        $('.rem3').remove();
      });
    });

    $('.close2').on('click', function (c) {
      $('.rem2').fadeOut('slow', function (c) {
        $('.rem2').remove();
      });
    });

    $('.close1').on('click', function (c) {
      $('.rem1').fadeOut('slow', function (c) {
        $('.rem1').remove();
      });
    });

    $('.value-plus').on('click', function () {
      var divUpd = $(this).parent().find('.value'),
        newVal = parseInt(divUpd.text(), 10) + 1;
      divUpd.text(newVal);
    });
  
    $('.value-minus').on('click', function () {
      var divUpd = $(this).parent().find('.value'),
        newVal = parseInt(divUpd.text(), 10) - 1;
      if (newVal >= 1) divUpd.text(newVal);
    });


    $('.popup-with-zoom-anim').magnificPopup({
      type: 'inline',
      fixedContentPos: false,
      fixedBgPos: true,
      overflowY: 'auto',
      closeBtnInside: true,
      preloader: false,
      midClick: true,
      removalDelay: 300,
      mainClass: 'my-mfp-zoom-in'
    });

    $(".dropdown").hover(
      function () {
        $('.dropdown-menu', this).stop(true, true).slideDown("fast");
        $(this).toggleClass('open');
      },
      function () {
        $('.dropdown-menu', this).stop(true, true).slideUp("fast");
        $(this).toggleClass('open');
      }
    );


  }



  

}
