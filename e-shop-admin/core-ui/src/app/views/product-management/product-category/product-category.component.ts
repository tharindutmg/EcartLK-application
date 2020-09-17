import { Component, OnInit } from '@angular/core';
import { ProductCategory } from './model/product-category';
import { ProductCategoryService } from './service/product-category.service';
import { ToastrService } from 'ngx-toastr';

declare function successAlertDismis():any;
declare function dangerAlertDismis():any;

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css']
})
export class ProductCategoryComponent implements OnInit {

  mainTopic : string = "Product Category";
  modelTopic : string = "Create Product Category"
  mainModel = new ProductCategory();

  mainModelList : ProductCategory[];
  public search:any = '';
  public productCatSearch:any = '';
  //initializing p to one
  p: number = 1;
  message : string;

  constructor(private mainService :ProductCategoryService,
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

  getById(id){
    this.mainService.getById(id).subscribe(data =>{
      console.log(data);
      this.mainModel.code=data.code;
      this.mainModel.description=data.description;
      this.mainModel.id=data.id;
  });
  }

  clearModel(){
    this.mainModel = new ProductCategory();
  }

  resetForm(form){
    form.reset();
  }

}
