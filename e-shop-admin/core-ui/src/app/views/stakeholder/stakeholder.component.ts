import { Component, OnInit } from '@angular/core';
import { Stakeholder } from '../system-security/access-group-map/model/stakeholde';
import { ToastrService } from 'ngx-toastr';
import { StakeholderService } from './service/stakeholder.service';

declare function successAlertDismis():any;
declare function dangerAlertDismis():any;

@Component({
  selector: 'app-stakeholder',
  templateUrl: './stakeholder.component.html',
  styleUrls: ['./stakeholder.component.css']
})
export class StakeholderComponent implements OnInit {

  mainTopic : string = "Product";
  modelTopic : string = "Create Product"
  mainModel = new Stakeholder();

  mainModelList : Stakeholder[];
  public search:any = '';
  //initializing p to one
  p: number = 1;
  message : string;

  constructor(private mainService :StakeholderService,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll(){
    this.mainService.getAll().subscribe(data =>{
      console.log(data);
      this.mainModelList = data;
      
  });
  }

  submit(){
    console.log(this.mainModel);
    this.mainService.save(this.mainModel).subscribe(data =>{
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

  delete(id){
    if(confirm("Are you sure to delete")) {
      this.mainService.delete(id).subscribe(data =>{
        console.log(data);
        if(data.key=="success"){
          this.toastr.success(data.message,"Success");
          this.getAll();
        }else{
          
        }
    });
    }
  }


  getById(id:any){
    this.mainService.getById(id).subscribe(data =>{
      console.log(data);
     /*  this.mainModel.code=data.code;
      this.mainModel.description=data.description;
      this.mainModel.id=data.id; */


  });
  }

  clearModel(){
    this.mainModel = new Stakeholder();
  }

  resetForm(form){
    form.reset();
  }

}
