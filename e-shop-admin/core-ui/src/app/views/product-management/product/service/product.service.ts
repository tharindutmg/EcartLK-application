import { Injectable, SkipSelf, Optional } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { mainURL } from '../../../Common/common-url-main';
import { CommonCustomResponce } from '../../../common/common-custom-responce';
import { Product } from '../model/product';

@Injectable({
    providedIn: 'root'
  })
export class ProductService{
    url : string = mainURL+"product";

    constructor(private _http: HttpClient){} //@SkipSelf()  


    save(mainModel : Product){
        return this._http.post<CommonCustomResponce>(this.url,mainModel);
    }

    delete(id: any) {
        return this._http.delete<CommonCustomResponce>(this.url+"/"+id);
      }
     
    getAll() {
        return this._http.get<Product[]>(this.url);
    }

    getById(id: any) {
        return this._http.get<Product>(this.url+"/"+id);
    }
      

}