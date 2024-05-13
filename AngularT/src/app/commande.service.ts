import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Commande } from './models/Commande.model';
@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private apiUrl = "http://localhost:8080/commande/";

  constructor(private httpClient: HttpClient) { }

  getAllCommandes(): Observable<Commande[]> {
    return this.httpClient.get<Commande[]>(this.apiUrl + "getAllcommandes");
  }
  addCommande(commande: Commande): Observable<any> {
    return this.httpClient.post<any>(this.apiUrl + "addCommande", commande);
  }
}

