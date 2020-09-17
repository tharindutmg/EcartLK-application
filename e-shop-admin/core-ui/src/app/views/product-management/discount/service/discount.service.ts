import { Injectable, SkipSelf, Optional } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { mainURL } from '../../../Common/common-url-main';
import { CommonCustomResponce } from '../../../common/common-custom-responce';
import { Discount } from '../model/discount';

@Injectable({
    providedIn: 'root'
  })
export class DiscountService{
    url : string = mainURL+"discount";

    constructor(private _http: HttpClient){} //@SkipSelf()  


    save(mainModel : Discount){
        return this._http.post<CommonCustomResponce>(this.url,mainModel);
    }

    delete(id: any) {
        return this._http.delete<CommonCustomResponce>(this.url+"/"+id);
      }
     
    getAll() {
        return this._http.get<Discount[]>(this.url);
    }

    getById(id: any) {
        return this._http.get<Discount>(this.url+"/"+id);
    }

    getDiscountsByItemId(itemId: string) {
        return this._http.get<Discount[]>(this.url+"/itemId/"+itemId);
      }
      

}