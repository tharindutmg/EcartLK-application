import { Injectable, SkipSelf, Optional } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Stakeholder } from '../../system-security/access-group-map/model/stakeholde';
import { CommonCustomResponce } from '../../common/common-custom-responce';
import { mainURL } from '../../Common/common-url-main';

@Injectable({
    providedIn: 'root'
  })
export class StakeholderService{
    
    url : string = mainURL+"stakeholder";

    constructor(private _http: HttpClient){} //@SkipSelf()  


    save(mainModel : Stakeholder){
        return this._http.post<CommonCustomResponce>(this.url,mainModel);
    }

    delete(id: any) {
        return this._http.delete<CommonCustomResponce>(this.url+"/"+id);
      }
     
    getAll() {
        return this._http.get<Stakeholder[]>(this.url);
    }

    getById(id: any) {
        return this._http.get<Stakeholder>(this.url+"/"+id);
    }
      

}