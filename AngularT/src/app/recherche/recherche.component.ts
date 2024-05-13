import { Component, OnInit } from '@angular/core';
import { VoitureService } from '../voiture.service';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {
  constructor(private voitureService: VoitureService) { } // Injection du service
  ngOnInit(): void {
    // Recherchez une voiture dès que le composant est initialisé
    this.recherche('Modèle de voiture');
  }
  modele: string = "";
  recherche(modele: string): void {
    this.voitureService.rechercheVoiture(modele).subscribe(
      (resultat) => {
        console.log("Résultat de la recherche :", resultat);
        // Traitez le résultat ici
      },
      (erreur) => {
        console.error("Erreur lors de la recherche :", erreur);
        // Gérez l'erreur ici
      }
    );
  }
}
