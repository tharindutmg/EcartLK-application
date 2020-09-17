import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StakeholderComponent } from './stakeholder.component';


const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Stakeholder'
    },
    children: [
      {
        path: '',
        redirectTo: 'stakeholdercrd'
      },
      {
        path: 'stakeholdercrd',
        component: StakeholderComponent,
        data: {
          title: 'Stakeholder'
        },
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StakeholderRoutingModule {}
