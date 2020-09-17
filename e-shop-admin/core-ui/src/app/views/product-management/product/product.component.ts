import { Component, OnInit } from '@angular/core';
import { Product } from './model/product';
import { ProductService } from './service/product.service';
import { ToastrService } from 'ngx-toastr';
import { ProductCategoryService } from '../product-category/service/product-category.service';
import { ProductCategory } from '../product-category/model/product-category';

declare function successAlertDismis():any;
declare function dangerAlertDismis():any;

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  mainTopic : string = "Product";
  modelTopic : string = "Create Product"
  mainModel = new Product();

  mainModelList : Product[];
  productCatList : ProductCategory[];
  public search:any = '';
  //initializing p to one
  p: number = 1;
  message : string;

  constructor(private mainService :ProductService,private productCatService :ProductCategoryService,
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

  getAllProductCat(){
    this.productCatService.getAll().subscribe(data =>{
      console.log(data);
      this.productCatList = data;
      
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

  selectPrdCat(prdCatId:any){
      this.productCatService.getById(prdCatId).subscribe(data =>{
        this.mainModel.productCategoryId=data.id;
        this.mainModel.prdCatCode=data.description;
      });
  }

  getById(id:any){
    this.mainService.getById(id).subscribe(data =>{
      console.log(data);
      this.selectPrdCat(data.productCategoryId)
      this.mainModel.code=data.code;
      this.mainModel.description=data.description;
      this.mainModel.id=data.id;


  });
  }

  clearModel(){
    this.mainModel = new Product();
  }

  resetForm(form){
    form.reset();
  }

}
