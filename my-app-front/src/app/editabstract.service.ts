import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Abstract } from './abstract';

@Injectable({
  providedIn: 'root'
})
export class EditabstractService {

  baseUrl="http://localhost:8081/summary"
  constructor(private httpClient:HttpClient) { }

  submitAbstract(abstract:Abstract):Observable<any>{
    console.log(abstract);
    return this.httpClient.post(`${this.baseUrl}`,abstract)
  }
}