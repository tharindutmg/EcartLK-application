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
import { AccessGroupComponent } from './access-group/access-group.component';
import { SystemSecurityRoutingModule } from './system-security-routing.module';
import { AccessControlComponent } from './access-control/access-control.component';
import { AccessGroupMapComponent } from './access-group-map/access-group-map.component';


@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    SystemSecurityRoutingModule,
    Ng2SearchPipeModule,
    NgxPaginationModule//add here
    //HttpClientModule
  ],
  declarations: [ AccessGroupComponent,
                  AccessControlComponent, 
                  AccessGroupMapComponent ],
  /* providers:[AcessGroupService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true},
  ] */
  
})
export class SystemSecurity {

  constructor( @Optional() @SkipSelf() parentModule:SystemSecurity){
    if(parentModule){
      throw new Error("AccessGroupModule module is alrady load. import ti to app module only");
    }
  }

 }
