import { Component, OnInit } from '@angular/core';
import { Item } from '../item/model/item';
import { Discount } from './model/discount';
import { DiscountService } from './service/discount.service';
import { ToastrService } from 'ngx-toastr';
import { ItemService } from '../item/service/item.service';

declare function successAlertDismis():any;
declare function dangerAlertDismis():any;

@Component({
  selector: 'app-discount',
  templateUrl: './discount.component.html',
  styleUrls: ['./discount.component.css']
})
export class DiscountComponent implements OnInit {

  mainTopic : string = "Discount";
  modelTopic : string = "Create Discount"
  mainModel = new Discount();

  mainModelList : Discount[];
  itemList : Item[];
  public search:any = '';
  //initializing p to one
  p: number = 1;
  message : string;
  
  bsDatepicker

  constructor(private mainService :DiscountService,private itemService :ItemService,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.mainModel.effectiveDate = new Date();
  }

  /* getAll(){
    this.mainService.getAll().subscribe(data =>{
      console.log(data);
      this.mainModelList = data;
      
    });
  } */

  getDiscountsByItemId(id){
    this.mainService.getDiscountsByItemId(id).subscribe(data =>{
      console.log(data);
      this.mainModelList = data;
      
    });
  }

  getAllItem(){
    this.itemService.getAll().subscribe(data =>{
      console.log(data);
      this.itemList = data;
      
    });
  }

  submit(){
    this.mainService.save(this.mainModel).subscribe(data =>{
        console.log(data);
        //debugger
        if(data.key=="success"){
          this.getDiscountsByItemId(this.mainModel.itemId);
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
          this.getDiscountsByItemId(this.mainModel.itemId);
          this.toastr.success(data.message,"Success");
          //this.getAll();
        }else{
          
        }
    });
    }
  }

  selectItem(id:any){
      this.itemService.getById(id).subscribe(data =>{
        this.mainModel.itemId=data.id;
        this.mainModel.itemDiscription=data.itemDisplayName;
        this.mainModel.sellPrice=data.sellPrice;
        console.log(data.sellPrice);
      });
  }

  getById(id:any){
    
    this.mainService.getById(id).subscribe(data =>{
      console.log(data);

      this.selectItem(data.itemId);
      //let newDate = new Date(data.effectiveDate);

      this.mainModel.effectiveDate= new Date(data.effectiveDate);
      this.mainModel.fixedAmount=data.fixedAmount;
      this.mainModel.id=data.id;
      this.mainModel.percentage=data.percentage;


  });
  }

  calculate(value){

    var fxAmount = +this.mainModel.fixedAmount;
    var slPrice = +this.mainModel.sellPrice;

    var presnt= +this.mainModel.percentage;

    var formatedNum = 0;

    if(value=="F"){
      presnt = (fxAmount / slPrice)*100
      this.mainModel.percentage =  presnt.toFixed(2).toString();
    }else{
      fxAmount = slPrice * presnt / 100;
      this.mainModel.fixedAmount = new Intl.NumberFormat('en-IN', { maximumSignificantDigits: 3 }).format(fxAmount);
    }

  }

  clearModel(){
    this.mainModel = new Discount();
  }

  resetForm(form){
    form.reset();
  }


}
