import { Component, OnInit, ViewChild } from '@angular/core';
import { NavigationService } from '../../../navigation/service/navigation.service';
import { Navidation } from '../../../navigation/model/navigation';
import { FormArray } from '@angular/forms';
import { AccessControle } from './model/access-control';
import { AcessGroupService } from '../access-group/service/access-group.service';
import { AccessGroupModel } from '../access-group/model/access-group-model';
import { AccessControlService } from './service/access-control.service';

declare function closeModel() : any;

@Component({
  selector: 'app-access-control',
  templateUrl: './access-control.component.html',
  styleUrls: ['./access-control.component.css']
})
export class AccessControlComponent implements OnInit {

  constructor(private navigationService:NavigationService,
              private acessGroupService : AcessGroupService,
              private accessControlService : AccessControlService) { }

  public search:any = '';
  //initializing p to one
  p: number = 1;
  message : string;
  navigations:Navidation[];

  @ViewChild('closebutton') closebutton;

  ngOnInit() {
    
  }

  accessGroupId : any;
  accessGroupDes : any;

  submit(){
    console.log(this.checkArray);
    Array.from(this.checkArray.values());
    this.accessControlService.save(Array.from(this.checkArray.values())).subscribe(data=>{
      console.log(data);
      this.reset()

    })

  }

  reset(){
    this.navigations=null;
    this.accessGroupDes ='';
  }

  
  getNavigation(){
    this.navigationService.getNavigation().subscribe(data=>{
      this.navigations=data
    })
  }

 parent:any;
 checkArray= new Set<AccessControle>();
 //accessControleArray= new List<AccessControle>();
 accessCintrole : any;
 correctName  = new AccessControle();
  onCheckboxChange(e,node,name,parent) {

    if(e.target.checked){
      this.accessCintrole = new AccessControle();
      if(node=="M"){
        this.accessCintrole.name = name;
        this.accessCintrole.accessGroupId = this.accessGroupId;
        this.accessCintrole.navigationId = e.target.value;
        this.accessCintrole.navigationChildrenId = null;
      }else{
        this.accessCintrole.name = name;
        this.accessCintrole.accessGroupId = this.accessGroupId;
        this.accessCintrole.navigationChildrenId = e.target.value;
        this.accessCintrole.navigationId = parent;
      }
      this.checkArray.add(this.accessCintrole);

      //this.accessControleArray =  Array.from(new Set(this.checkArray));
    }else{
      
      this.checkArray.forEach(value => {
        if(value.name==name){
          this.correctName = value
        }
        this.checkArray.delete(this.correctName); 
        console.log(value);               
      });
         
    }
    
    
   
    
    console.log(this.checkArray);
  }

  accessGroups: AccessGroupModel[]
  getAllAccessGroup(){
    this.acessGroupService.getAll().subscribe(data => {
      this.accessGroups=data;
    })
  }

  setAccessGroupId(accessGroupId:any,accessGroupDes:any){
    this.accessGroupDes=accessGroupDes;
    this.accessGroupId=accessGroupId;
    this.getNavigation();
    /* closeModel() */
    this.closebutton.nativeElement.click();
  }

}
