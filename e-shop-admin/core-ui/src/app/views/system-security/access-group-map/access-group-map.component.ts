import { Component, OnInit } from '@angular/core';
import { AcessGroupService } from '../access-group/service/access-group.service';
import { AccessGroupModel } from '../access-group/model/access-group-model';
import { AccessGroupMap } from './model/access-group-map';
import { AcessGroupMapService } from './service/access-group-map.service';
import { Stakeholder } from './model/stakeholde';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-access-group-map',
  templateUrl: './access-group-map.component.html',
  styleUrls: ['./access-group-map.component.css']
})
export class AccessGroupMapComponent implements OnInit {

  accessGroups : AccessGroupModel[];
  stakeholders : Stakeholder[];
  //stakeholde : Stakeholder;
  accessGroupMapModel = new AccessGroupMap();
  public search:any = '';
  //initializing p to one
  p: number = 1;

  constructor(private acessGroupService :AcessGroupService,
              private acessGroupMapService : AcessGroupMapService,
              private toastr: ToastrService) { }

  ngOnInit() {
  }

  submit(){
    this.acessGroupMapService.save(this.accessGroupMapModel).subscribe(data =>{
      console.log(data);
      if(data.key=="success"){
        this.toastr.success(data.message,"Success");
        this.accessGroupMapModel=new AccessGroupMap();
      }else{
        
      }
      
    })
  }

  getAllAccessGroup(){
    this.acessGroupService.getAll().subscribe(data => {
      console.log(data);
      this.accessGroups = data;
    })
  }

  setAccessGroupId(id : string){
    this.acessGroupService.getAccessGroupById(id).subscribe(data => {
      console.log(data);
      this.accessGroupMapModel.accessGroupDes = data.description;
      this.accessGroupMapModel.accessGroupId = data.accessGroupId;
    })
  }

  getAllUsers(){
    console.log("ok");
    this.acessGroupMapService.getAllStakeholde().subscribe(data => {
      console.log(data);
      this.stakeholders = data;
    })
  }

  getStakeholderById(id : string){
    this.acessGroupMapService.getStakeholdeById(id).subscribe(data => {
      console.log(data);
      this.accessGroupMapModel.userName = data.firstName;
    })

  }

  resetForm(form){
    form.reset();
  }

}
