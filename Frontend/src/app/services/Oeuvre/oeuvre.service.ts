import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Oeuvre } from 'src/app/models/oeuvre';
import {baseUrl, httpOptions} from '../helper';


@Injectable({
  providedIn: 'root'
})
export class OeuvreService {

  constructor(private http : HttpClient) { }



  //add oeuvre
  public addOeuvre(oeuvre : Oeuvre): Observable<Oeuvre>{
    return this.http.post<Oeuvre>(`${baseUrl}/oeuvre/create`, oeuvre);
  }

  //get all oeuvres
  public getOeuvreList() : Observable<Oeuvre[]> {
    return this.http.get<Oeuvre[]>(`${baseUrl}/oeuvre/all`);
  }

  //get oeuvre by id
  public getOeuvreById(id : number) : Observable<Oeuvre> {
    return this.http.get<Oeuvre>(`${baseUrl}/oeuvre/${id}`, httpOptions);
  }

  //delete oeuvre
  public deleteOeuvre(id : number) : Observable<any> {
    return this.http.delete(`${baseUrl}/oeuvre/${id}`, httpOptions);
  }

  //update oeuvre
  public updateOeuvre(oeuvre : Oeuvre, id : number) : Observable<Oeuvre>{
    return this.http.put<Oeuvre>(`${baseUrl}/oeuvre/update/${id}`, oeuvre);
  }

  public getOeuvreImage(id : number){
    return this.http.get(`${baseUrl}/oeuvre/${id}/image`, httpOptions)
  }

}


