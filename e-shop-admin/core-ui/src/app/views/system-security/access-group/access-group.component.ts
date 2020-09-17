import { Component, OnInit } from '@angular/core';
import { AccessGroupModel } from './model/access-group-model';
import { AcessGroupService } from './service/access-group.service';
import * as $ from 'jquery';
import { ToastrService } from 'ngx-toastr';

declare function successAlertDismis():any;
declare function dangerAlertDismis():any;

@Component({
  selector: 'app-access-group',
  templateUrl: './access-group.component.html',
  styleUrls: ['./access-group.component.css']
})
export class AccessGroupComponent implements OnInit {

  accessGroupModel = new AccessGroupModel();
  accessGroups : AccessGroupModel[];
  public search:any = '';
  //initializing p to one
  p: number = 1;
  message : string;
  

  constructor(private acessGroupService :AcessGroupService,
                    private toastr: ToastrService) { }

  ngOnInit() {

    
    
    this.getAll();
  }

  getAll(){
    this.acessGroupService.getAll().subscribe(data =>{
      console.log(data);
      this.accessGroups = data;
      
  });
  }

  submit(){
    this.acessGroupService.save(this.accessGroupModel).subscribe(data =>{
        console.log(data);
        //debugger
        if(data.key=="success"){
          this.getAll();
          this.message=data.message;
          successAlertDismis();
        }else{
          this.message=data.message;
          dangerAlertDismis()
        }
    });
  }

  deleteAccessGroup(id){
    if(confirm("Are you sure to delete")) {
      this.acessGroupService.deleteAccessGroup(id).subscribe(data =>{
        console.log(data);
        if(data.key=="success"){
          this.toastr.success(data.message,"Success");
          this.getAll();
        }else{
          
        }
    });
    }
    

  }

  getAccessGroupById(accessGroupId){
    this.acessGroupService.getAccessGroupById(accessGroupId).subscribe(data =>{
      console.log(data);
      this.accessGroupModel.code=data.code;
      this.accessGroupModel.description=data.description;
      this.accessGroupModel.accessGroupId=data.accessGroupId;
  });
  }

  clearModel(){
    this.accessGroupModel = new AccessGroupModel();
  }

  resetForm(form){
    form.reset();
  }

 

}
