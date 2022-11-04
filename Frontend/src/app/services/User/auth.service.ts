import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { UserLogin } from 'src/app/models/userLogin';
import { baseUrl, httpOptions } from '../helper';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http : HttpClient) { }

  public authenticate(user : UserLogin) : Observable<any> {
    return this.http.post<any>("http://localhost:8080/login", user);
  }
}
