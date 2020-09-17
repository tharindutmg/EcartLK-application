import {Component } from '@angular/core';
import { navItems } from '../../_nav';
import { NavigationService } from '../../navigation/service/navigation.service';
import { Navidation } from '../../navigation/model/navigation';
import { Badge } from './model/badge';
import { Children } from './model/children';
import { Attribute } from '@angular/compiler';
import { Attributes } from './model/attributes';

@Component({
  selector: 'app-dashboard',
  templateUrl: './default-layout.component.html',
})
export class DefaultLayoutComponent {
  public sidebarMinimized = false;
  public navItems :any;

  toggleMinimize(e) {
    this.sidebarMinimized = e;
  }

  constructor(private navigationService:NavigationService){
    this.getNavigation();
    //this.navItems= navItems;
  }
  row=new Navidation();
  badgeSingle =new Badge();
  childrenSingle =new Children;
  main:any;

  getNavigation(){
    this.navigationService.getNavigation().subscribe(data =>{
      console.log("navigation------------------------------");
      console.log(data);
      /* this.main = new Array<Navidation>();
      this.main.push(data) */
      

      this.main = new Array<Navidation>();
      data.forEach(navigation => {
        this.row= new Navidation();
        this.row.url=navigation.url;
        this.row.name=navigation.name;
        this.row.icon=navigation.icon;

        this.row.badge=navigation.badge;

        if(navigation.children!=null){
          let chilSingleMain =new Array<Children>();
          navigation.children.forEach(chiObj=>{
           // debugger
            if(chiObj.navigationId==navigation.navigationId){
              this.childrenSingle =new Children;

              this.childrenSingle.icon=chiObj.icon;
              this.childrenSingle.name=chiObj.name;
              this.childrenSingle.url=chiObj.url;

              chilSingleMain.push(this.childrenSingle);
              this.row.children=chilSingleMain;
            }
          })
        }
        this.row.attributes=navigation.attributes;

        this.main.push(this.row);
      })

      this.navItems=this.main;

    });
     
       
  
  }
 
}
