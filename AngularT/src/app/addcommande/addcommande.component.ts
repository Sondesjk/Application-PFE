import { Component } from '@angular/core';
import { Commande } from '../models/Commande.model';

import { CommandeService } from '../commande.service';

@Component({
  selector: 'app-addcommande',
  templateUrl: './addcommande.component.html',
  styleUrls: ['./addcommande.component.css']
})
export class AddcommandeComponent {
  commande: Commande = {
    id: -1,
    nom: "",
    prenom: "",
    email: "",
    cin: "",
    telephone: ""
  };

  constructor(private commandeService: CommandeService) { }

  addCommande() {
    this.commandeService.addCommande(this.commande).subscribe(
      (newCommande: Commande) => { 
        console.log("Commande ajoutée avec succès");
        this.resetForm();
      },
      (error: any) => { 
        console.error("Erreur lors de l'ajout de la commande :", error);
      }
    );
  }

  resetForm() {
    this.commande = {
      id: -1,
      nom: "",
      prenom: "",
      email: "",
      cin: "",
      telephone: ""
    };
  }
}
