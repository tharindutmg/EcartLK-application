import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from "rxjs/internal/Observable";

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor{
    
    
    /* intercept(req: import("@angular/common/http").HttpRequest<any>, next: import("@angular/common/http").HttpHandler): import("rxjs").Observable<import("@angular/common/http").HttpEvent<any>> {
        
        const token = localStorage.getItem("jwttoken");

        if(token){
            const cloned = req.clone({
                headers: req.headers.set("Authorization","Bearer " + token)
            });

            return next.handle(cloned);
        }else{
            return next.handle(req);
        }
    } */

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let token = window.localStorage.getItem('jwttoken');
        console.log(token);
        if (token) {
            request = request.clone({
                setHeaders: {
                    Authorization: 'Bearer ' + token
                }
            });
            console.log(request.headers);
        }
        return next.handle(request);
    }

}