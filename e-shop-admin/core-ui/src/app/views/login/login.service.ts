import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { UserModel } from './model/UserModel';
import { mainURL } from '../Common/common-url-main';


@Injectable()
export class LoginService{

    constructor(private _http: HttpClient){}
    
    login : string = mainURL+"login";
    url : string = mainURL+"accessGroups";
    

    loginCheck(userModel:UserModel){
      
      console.info(this._http)
      console.info(userModel)
      return this._http.post<UserModel>(this.login,userModel);
    }


    /* getQues(colorCode) {
      return this._http.get<Question>(this._url_getQues+colorCode);
    }

    getQuesoption(questionId) {
      return this._http.get<QuesOption[]>(this._url_getQuesoption+questionId);
    }

    getQuesAll(){
      return this._http.get<Question[]>(this._url_getQuesAll);
    } */



    
    
}