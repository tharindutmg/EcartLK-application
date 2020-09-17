import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SingleProductComponent } from './single-product/single-product.component';
import { ProductsComponent } from './products/products.component';
import { CheckoutComponent } from './checkout/checkout.component';
/* import { DisplayProductsComponent } from './display-products/display-products.component';
import { AboutComponent } from './about/about.component';
import { CheckoutComponent } from './checkout/checkout.component'; */

const routes: Routes = [
  {
      path: '',
      component: HomeComponent,
  },
  {
    path: 'single',
    component: SingleProductComponent,
  },
  {
    path: 'products',
    component: ProductsComponent,
  },
  {
    path: 'checkut',
    component: CheckoutComponent,
  },
  
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = 
[
  HomeComponent,
  SingleProductComponent,
  ProductsComponent,
  CheckoutComponent,
]
