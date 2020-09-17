import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DisplayProductsComponent } from './display-products/display-products.component';
import { SingleProductComponent } from './single-product/single-product.component';
import { AboutComponent } from './about/about.component';
import { CheckoutComponent } from './checkout/checkout.component';

const routes: Routes = [
  {
      path: '',
      component: HomeComponent,
  },
  {
    path: 'products',
    component: DisplayProductsComponent,
  },
  {
    path: 'single',
    component: SingleProductComponent,
  },
  {
    path: 'about',
    component: AboutComponent,
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
  DisplayProductsComponent,
  SingleProductComponent,
  AboutComponent,
  CheckoutComponent,
]
