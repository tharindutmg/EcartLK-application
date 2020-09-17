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
import { InventoryAssignComponent } from './inventory-assign/inventory-assign.component';
import { InventoryReceiveComponent } from './inventory-receive/inventory-receive.component';
import { StockManagementRoutingModule } from './stock-management-routing.module';


@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    StockManagementRoutingModule,
    Ng2SearchPipeModule,
    NgxPaginationModule//add here
    //HttpClientModule
  ],
  declarations: [ InventoryAssignComponent,
                InventoryReceiveComponent,
                ],
  /* providers:[AcessGroupService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true},
  ] */
  
})
export class StockManagementModule {

  constructor( @Optional() @SkipSelf() parentModule:StockManagementModule){
    if(parentModule){
      throw new Error("AccessGroupModule module is alrady load. import ti to app module only");
    }
  }

 }
