import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccessGroupComponent } from './access-group/access-group.component';
import { AccessControlComponent } from './access-control/access-control.component';
import { AccessGroupMapComponent } from './access-group-map/access-group-map.component';


const routes: Routes = [
  {
    path: '',
    data: {
      title: 'System Security'
    },
    children: [
      {
        path: '',
        redirectTo: 'accessGroup'
      },
      {
        path: 'access-group',
        component: AccessGroupComponent,
        data: {
          title: 'Access Group'
        },
      },
      {
        path: 'access-control',
        component: AccessControlComponent,
        data: {
          title: 'Access Control'
        }
      },
      {
        path: 'access-group-map',
        component: AccessGroupMapComponent,
        data: {
          title: 'Access Group Map'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemSecurityRoutingModule {}
