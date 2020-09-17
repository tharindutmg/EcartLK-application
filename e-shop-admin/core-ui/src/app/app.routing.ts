import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import { DefaultLayoutComponent } from './containers';

import { P404Component } from './views/error/404.component';
import { P500Component } from './views/error/500.component';
import { LoginComponent } from './views/login/login.component';
import { RegisterComponent } from './views/register/register.component';

export const routes: Routes = [
  /* {
    path: '',
    redirectTo: 'dashboard',  //this is original
    pathMatch: 'full',
  }, */
  {
    path: '',
    redirectTo: 'login',  //this is original
    pathMatch: 'full',
  },
  {
    path: '404',
    component: P404Component,
    data: {
      title: 'Page 404'
    }
  },
  {
    path: '500',
    component: P500Component,
    data: {
      title: 'Page 500'
    }
  },
  {
    path: 'login',
    component: LoginComponent,
    data: {
      title: 'Login Page'
    }
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: {
      title: 'Register Page'
    }
  },
  {
    path: '',
    component: DefaultLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'dashboard',
        loadChildren: () => import('./views/dashboard/dashboard.module').then(m => m.DashboardModule)
      },
      {
        path: 'system-security',
        loadChildren: () => import('./views/system-security/system-security.module').then(m => m.SystemSecurity)
      },
      {
        path: 'product-management',
        loadChildren: () => import('./views/product-management/product-management.module').then(m => m.ProductManagementModule)
      },
      {
        path: 'stock-management',
        loadChildren: () => import('./views/stock-management/stock-management.module').then(m => m.StockManagementModule)
      },
      {
        path: 'stakeholder',
        loadChildren: () => import('./views/stakeholder/stakeholder.module').then(m => m.StakeholderModule)
      },
      {
        path: 'icons',
        loadChildren: () => import('./views/icons/icons.module').then(m => m.IconsModule)
      },
      {
        path: 'theme',
        loadChildren: () => import('./views/theme/theme.module').then(m => m.ThemeModule)
      },
    ]
  },
  { path: '**', component: P404Component }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
