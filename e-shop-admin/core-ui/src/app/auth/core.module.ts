import { ModuleWithProviders, NgModule, Optional, SkipSelf } from '@angular/core';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClient } from '@angular/common/http';
import { AuthenticationInterceptor } from './auth-interceptors.service';
import { CommonModule, DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import { LoginService } from '../views/login/login.service';
import { AcessGroupService } from '../views/system-security/access-group/service/access-group.service';
import { NavigationService } from '../navigation/service/navigation.service';
import { AccessControlService } from '../views/system-security/access-control/service/access-control.service';
import { AcessGroupMapService } from '../views/system-security/access-group-map/service/access-group-map.service';
import { ProductCategoryService } from '../views/product-management/product-category/service/product-category.service';
import { ProductService } from '../views/product-management/product/service/product.service';
import { ItemService } from '../views/product-management/item/service/item.service';
import { DiscountService } from '../views/product-management/discount/service/discount.service';
import { StakeholderService } from '../views/stakeholder/service/stakeholder.service';


/* export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
} */

@NgModule({
  imports: [
   // CommonModule,
    HttpClientModule,
    /* TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }), */
    //RouterModule.forRoot([]),
  ],
  declarations: [],
  //providers: [DatePipe]
})
export class CoreModule {
 /*  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only');
    }
  } */

  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CoreModule,
      providers: [
        LoginService,
        AcessGroupService,
        NavigationService,
        AccessControlService,
        AcessGroupMapService,
        ProductCategoryService,
        ProductService,
        ItemService,
        DiscountService,
        StakeholderService,
        {provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true},
        
      ]
    };
  }
}