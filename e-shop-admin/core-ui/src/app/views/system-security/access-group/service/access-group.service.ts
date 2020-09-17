import { Injectable, SkipSelf, Optional } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AccessGroupModel } from '../model/access-group-model';
import { mainURL } from '../../../Common/common-url-main';
import { CommonCustomResponce } from '../../../common/common-custom-responce';

@Injectable({
    providedIn: 'root'
  })
export class AcessGroupService{
    url : string = mainURL+"accessGroups";

    constructor(private _http: HttpClient){} //@SkipSelf()  


    save(accessGroupModel : AccessGroupModel){
        return this._http.post<CommonCustomResponce>(this.url,accessGroupModel);
    }

    deleteAccessGroup(id: any) {
        return this._http.delete<CommonCustomResponce>(this.url+"/"+id);
      }
     
    getAll() {
        return this._http.get<AccessGroupModel[]>(this.url);
    }

    getAccessGroupById(accessGroupId: any) {
        return this._http.get<AccessGroupModel>(this.url+"/"+accessGroupId);
    }
      

}