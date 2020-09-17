import { Injectable, SkipSelf, Optional } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { mainURL } from '../../../Common/common-url-main';
import { CommonCustomResponce } from '../../../common/common-custom-responce';
import { ProductCategory } from '../model/product-category';

@Injectable({
    providedIn: 'root'
  })
export class ProductCategoryService{
    url : string = mainURL+"product-category";

    constructor(private _http: HttpClient){} //@SkipSelf()  


    save(mainModel : ProductCategory){
        return this._http.post<CommonCustomResponce>(this.url,mainModel);
    }

    delete(id: any) {
        return this._http.delete<CommonCustomResponce>(this.url+"/"+id);
      }
     
    getAll() {
        return this._http.get<ProductCategory[]>(this.url);
    }

    getById(id: any) {
        return this._http.get<ProductCategory>(this.url+"/"+id);
    }
      

}