import { Component, OnInit } from '@angular/core';
import { Item } from './model/item';
import { ProductCategory } from '../product-category/model/product-category';
import { ProductService } from '../product/service/product.service';
import { ProductCategoryService } from '../product-category/service/product-category.service';
import { ToastrService } from 'ngx-toastr';
import { ItemService } from './service/item.service';
import { Product } from '../product/model/product';

declare function successAlertDismis():any;
declare function dangerAlertDismis():any;

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  
  mainTopic : string = "Item";
  modelTopic : string = "Create Item"
  mainModel = new Item();

  mainModelList : Item[];
  productCatList : ProductCategory[];
  productList : Product[];
  public search:any = '';
  //initializing p to one
  p: number = 1;
  message : string;

  constructor(private mainService :ItemService,private productService :ProductService,private productCatService :ProductCategoryService,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.getAll();
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

  getAllProduct(){
    this.productService.getAll().subscribe(data =>{
      console.log(data);
      this.productList = data;
      
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
        this.mainModel.productCatDiscription=data.description;
      });
  }

  selectPrd(prdId:any){
    this.productService.getById(prdId).subscribe(data =>{
      this.mainModel.productId=data.id;
      this.mainModel.productDiscription=data.description;
    });
}

  getById(id:any){
    this.mainService.getById(id).subscribe(data =>{
      this.mainModel=data
      this.temporyImage_1="data:image/PNG;base64,"+data.imageData1;
      this.temporyImage_2="data:image/PNG;base64,"+data.imageData2;
      this.temporyImage_3="data:image/PNG;base64,"+data.imageData3;
      this.temporyImage_4="data:image/PNG;base64,"+data.imageData4;

      this.mainModel.imageName1=data.imageName1;
  });
  }

  selectedFiles: FileList;
  selected : boolean=false;
  fileUploadError: boolean=false;
  temporyImage_1:string="assets/uploade/default_image.gif";
  temporyImage_2:string="assets/uploade/default_image.gif";
  temporyImage_3:string="assets/uploade/default_image.gif";
  temporyImage_4:string="assets/uploade/default_image.gif";
  selectFile(event,number) {
    this.selectedFiles = event.target.files;
    this.mainService.showTemporyImage(this.selectedFiles.item(0),number).subscribe(data=>{
      if(number=="1"){
        this.mainModel.imageData1=data.imageData1;
        this.mainModel.imageName1=data.imageName1;
        this.temporyImage_1="data:image/PNG;base64,"+data.imageData1;
      }else if (number=="2"){
        this.mainModel.imageData2=data.imageData2;
        this.mainModel.imageName2=data.imageName2;
        this.temporyImage_2="data:image/PNG;base64,"+data.imageData2;
      }else if (number=="3"){
        this.mainModel.imageData3=data.imageData3;
        this.mainModel.imageName3=data.imageName3;
        this.temporyImage_3="data:image/PNG;base64,"+data.imageData3;
      }else if (number=="4"){
        this.mainModel.imageData4=data.imageData4;
        this.mainModel.imageName4=data.imageName4;
        this.temporyImage_4="data:image/PNG;base64,"+data.imageData4;
      }
      
    });
  }

  public resetImage(){
    this.temporyImage_1="assets/uploade/default_image.gif";
    this.temporyImage_2="assets/uploade/default_image.gif";
    this.temporyImage_3="assets/uploade/default_image.gif";
    this.temporyImage_4="assets/uploade/default_image.gif";
  }

  clearModel(){
    this.mainModel = new Item();
  }

  resetForm(form){
    form.reset();
  }

}
