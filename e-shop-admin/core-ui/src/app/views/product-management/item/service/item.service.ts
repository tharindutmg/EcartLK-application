import { Injectable, SkipSelf, Optional } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { mainURL } from '../../../Common/common-url-main';
import { CommonCustomResponce } from '../../../common/common-custom-responce';
import { Item } from '../model/item';

@Injectable({
    providedIn: 'root'
  })
export class ItemService{
  
    url : string = mainURL+"item";

    constructor(private _http: HttpClient){} //@SkipSelf()  


    save(mainModel : Item){
        return this._http.post<CommonCustomResponce>(this.url,mainModel);
    }

    delete(id: any) {
        return this._http.delete<CommonCustomResponce>(this.url+"/"+id);
      }
     
    getAll() {
        return this._http.get<Item[]>(this.url);
    }

    getById(id: any) {
        return this._http.get<Item>(this.url+"/"+id);
    }

    showTemporyImage(image: File,number) {
        const formdata: FormData = new FormData();
        formdata.append('file', image);
        formdata.append('number', number);
        return this._http.post<Item>(this.url+"/temporyImage",formdata);
    }
      

}