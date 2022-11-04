import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Session } from 'src/app/models/session';
import {baseUrl, httpOptions} from '../helper';


@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http : HttpClient) { }

  //add session
  public addSession(session : Session) : Observable<Session>{
    return this.http.post<Session>(`${baseUrl}/session/create`, session);
  }

  //get all sessions
  public getSessionList() : Observable<Session[]>{
    return this.http.get<Session[]>(`${baseUrl}/session/all`);
  }

  //get session by id
  public getSessionById(id : number) : Observable<Session>{
    return this.http.get<Session>(`${baseUrl}/session/${id}`, httpOptions);
  }

  //delete session
  public deleteSession(id : number) : Observable<any>{
    return this.http.delete(`${baseUrl}/session/${id}`, httpOptions);
  }

  //update session
  public updateSession(session : Session, id : number) : Observable<Session>{
    return this.http.put<Session>(`${baseUrl}/session/update/${id}`, session);
  }
}
