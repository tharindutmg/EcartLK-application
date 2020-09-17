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
import { StakeholderComponent } from './stakeholder.component';
import { StakeholderRoutingModule } from './stakeholder-routing.module';


@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    StakeholderRoutingModule,
    Ng2SearchPipeModule,
    NgxPaginationModule//add here
    //HttpClientModule
  ],
  declarations: [ StakeholderComponent,
                ],
  /* providers:[AcessGroupService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true},
  ] */
  
})
export class StakeholderModule {

  constructor( @Optional() @SkipSelf() parentModule:StakeholderModule){
    if(parentModule){
      throw new Error("AccessGroupModule module is alrady load. import ti to app module only");
    }
  }

 }
