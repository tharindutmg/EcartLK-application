import { Component } from '@angular/core';
import { UserModel } from './model/UserModel';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent {

  userModel = new UserModel();
  jwtHelperService: any;

  constructor(private loginService: LoginService, private router: Router) {

  }

  login() {
    console.info(this.userModel);
    this.loginService.loginCheck(this.userModel).subscribe(data => {
      console.info(data);

      let jwtData = data.jwttoken.split('.')[1]
      let decodedJwtJsonData = window.atob(jwtData)
      let decodedJwtData = JSON.parse(decodedJwtJsonData)

      localStorage.setItem("jwttoken", data.jwttoken);
      localStorage.setItem("userName", decodedJwtData.sub);
      localStorage.setItem("role", data.role);


      this.router.navigate(["/dashboard"])
    });
  }
}
