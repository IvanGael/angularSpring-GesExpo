import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exposition } from 'src/app/models/exposition';
import {baseUrl, httpOptions} from '../helper';

@Injectable({
  providedIn: 'root'
})
export class ExpositionService {

  constructor(private http : HttpClient) { }

  //add exposition
  public addExpo(expo : Exposition) : Observable<Exposition>{
    return this.http.post<Exposition>(`${baseUrl}/exposition/create`, expo);
  }

  //get all expositions
  public getExpoList() : Observable<Exposition[]>{
    return this.http.get<Exposition[]>(`${baseUrl}/exposition/all`);
  }

  //get exposition by id
  public getExpoById(id : number) : Observable<Exposition>{
    return this.http.get<Exposition>(`${baseUrl}/exposition/${id}`, httpOptions);
  }

  //delete exposition
  public deleteExpo(id : number) : Observable<any>{
    return this.http.delete(`${baseUrl}/exposition/${id}`, httpOptions);
  }

  //update exposition
  public updateExpo(expo : Exposition, id : number) : Observable<Exposition>{
    return this.http.put<Exposition>(`${baseUrl}/exposition/update/${id}`, expo);
  }
  
}
