import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { mainURL } from '../../views/Common/common-url-main';
import { Navidation } from '../model/navigation';


@Injectable()
export class NavigationService{

    constructor(private _http: HttpClient){}
    
    url : string = mainURL+"navigation";
    

    getNavigation(){
      return this._http.get<Navidation[]>(this.url);
    }

    
}