import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InventoryReceiveComponent } from './inventory-receive/inventory-receive.component';
import { InventoryAssignComponent } from './inventory-assign/inventory-assign.component';


const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Stock Management'
    },
    children: [
      {
        path: '',
        redirectTo: 'inventory-receive'
      },
      {
        path: 'inventory-receive',
        component: InventoryReceiveComponent,
        data: {
          title: 'Inventory Receive'
        },
      },
      {
        path: 'inventory-assign',
        component: InventoryAssignComponent,
        data: {
          title: 'Inventory Assign'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StockManagementRoutingModule {}
