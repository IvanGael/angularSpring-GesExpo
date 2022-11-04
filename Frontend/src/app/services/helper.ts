import { HttpHeaders } from '@angular/common/http';

let baseUrl = "http://localhost:8080/api";
const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json', 
    })
  };
  
export {
    baseUrl,
    httpOptions
}
