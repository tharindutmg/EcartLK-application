import { Injectable, SkipSelf, Optional } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { mainURL } from '../../../Common/common-url-main';
import { CommonCustomResponce } from '../../../common/common-custom-responce';
import { Stakeholder } from '../model/stakeholde';
import { AccessGroupMap } from '../model/access-group-map';

@Injectable({
    providedIn: 'root'
  })
export class AcessGroupMapService{
  
    url : string = mainURL+"accessGroupMap";
    stakeholder : string = mainURL+"stakeholder";

    constructor(private _http: HttpClient){} //@SkipSelf()  


    save(accessGroupMapModel : AccessGroupMap){
        return this._http.post<CommonCustomResponce>(this.url,accessGroupMapModel);
    }
    getAllStakeholde() {
        return this._http.get<Stakeholder[]>(this.stakeholder);
    } 

    getStakeholdeById(id:string) {
        return this._http.get<Stakeholder>(this.stakeholder+"/id/"+id);
    } 
  
     
    /* getAll() {
        return this._http.get<AccessGroupModel[]>(this.url);
    } */ 

 
      

}