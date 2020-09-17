import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { mainURL } from '../../../Common/common-url-main';
import { AccessControle } from '../model/access-control';
import { CommonCustomResponce } from '../../../common/common-custom-responce';


@Injectable()
export class AccessControlService{
  

    constructor(private _http: HttpClient){}
    
    url : string = mainURL+"access-control";
    
    save(accessCintrole:AccessControle[]) {
        return this._http.post<CommonCustomResponce>(this.url,accessCintrole);
    }
    

    
}