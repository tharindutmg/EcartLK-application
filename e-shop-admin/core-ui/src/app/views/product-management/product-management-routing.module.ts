import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ProductComponent } from './product/product.component';
import { ItemComponent } from './item/item.component';
import { DiscountComponent } from './discount/discount.component';


const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Product Management'
    },
    children: [
      {
        path: '',
        redirectTo: 'product-category'
      },
      {
        path: 'product-category',
        component: ProductCategoryComponent,
        data: {
          title: 'Product Category'
        },
      },
      {
        path: 'product',
        component: ProductComponent,
        data: {
          title: 'Product'
        }
      },
      {
        path: 'item',
        component: ItemComponent,
        data: {
          title: 'Item'
        }
      },
      {
        path: 'discount',
        component: DiscountComponent,
        data: {
          title: 'Discount'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductManagementRoutingModule {}
