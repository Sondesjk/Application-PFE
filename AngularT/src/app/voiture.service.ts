// Dans voiture.service.ts

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Voiture } from './models/Voiture.model';
import { User } from './models/User.model';

@Injectable({
  providedIn: 'root'
})
export class VoitureService {
  private apiUrl = "http://localhost:8080/voiture/"
  

  constructor(private httpClient:HttpClient) { }

  getAllVoitures(): Observable<any[]> 
  {
    return this.httpClient.get<any[]>(this.apiUrl+"getAllvoitures")
  }
  
  addvoiture(voiture:Voiture): Observable<any> 
  {
    return this.httpClient.post<Voiture>(this.apiUrl+"add",voiture)
  }
  deleteVoiture(id:number): Observable<any> 
  {
    return this.httpClient.delete<Voiture>(this.apiUrl+"delete/"+id)

  }
  updateVoiture(id:number,voiture:Voiture):Observable<Voiture>
  {
    return this.httpClient.put<Voiture>(this.apiUrl+"update/"+id,voiture)
  }
  getVoitureById(id:number):Observable<Voiture>
  {
    return this.httpClient.get<Voiture>(this.apiUrl+"get/"+id)
  }
  rechercheVoiture(modele: string): Observable<Voiture> {
    return this.httpClient.get<Voiture>(this.apiUrl + "recherche/" + modele);
  }
}

