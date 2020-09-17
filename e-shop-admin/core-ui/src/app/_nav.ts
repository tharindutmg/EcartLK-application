import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    icon: 'icon-speedometer',
    badge: {
      variant: 'info',
      text: 'NEW'
    },
    children:null,
  },
  {
    name: 'System Security',
    url: '/system-security',
    icon: 'cui-shield',
    badge:null,
    children: [
      {
        name: 'Access Group',
        url: '/system-security/access-group',
        icon: 'fa fa-circle-o'
      },
      {
        name: 'Access Control',
        url: '/system-security/access-control',
        icon: 'fa fa-circle-o'
      },
    ]
  },
  
  {
    name: 'Pages',
    url: '/pages',
    icon: 'icon-star',
    children: [
      {
        name: 'Login',
        url: '/login',
        icon: 'icon-star'
      },
      {
        name: 'Register',
        url: '/register',
        icon: 'icon-star'
      },
      {
        name: 'Error 404',
        url: '/404',
        icon: 'icon-star'
      },
      {
        name: 'Error 500',
        url: '/500',
        icon: 'icon-star'
      }
    ]
  },
  {
    name: 'Disabled',
    url: '/dashboard',
    icon: 'icon-ban',
    badge: {
      variant: 'secondary',
      text: 'NEW'
    },
    attributes: { disabled: true },
  },
  
];
