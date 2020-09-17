import { NgModule, Optional, SkipSelf } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { CommonModule } from '@angular/common';
import { error } from '@angular/compiler/src/util';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import { ProductManagementRoutingModule } from './product-management-routing.module';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ProductComponent } from './product/product.component';
import { ItemComponent } from './item/item.component';
import { DiscountComponent } from './discount/discount.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';


@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    ProductManagementRoutingModule,
    Ng2SearchPipeModule,
    BsDatepickerModule.forRoot(),
    NgxPaginationModule//add here
    //HttpClientModule
  ],
  declarations: [ ProductCategoryComponent,ProductComponent,ItemComponent, DiscountComponent ],
  /* providers:[AcessGroupService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true},
  ] */
  
})
export class ProductManagementModule {

  constructor( @Optional() @SkipSelf() parentModule:ProductManagementModule){
    if(parentModule){
      throw new Error("AccessGroupModule module is alrady load. import ti to app module only");
    }
  }

 }
