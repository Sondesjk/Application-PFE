import { Component } from '@angular/core';
import { Voiture } from '../models/Voiture.model';
import { VoitureService } from '../voiture.service';

@Component({
  selector: 'app-addvoiture',
  templateUrl: './addvoiture.component.html',
  styleUrls: ['./addvoiture.component.css']
})
export class AddvoitureComponent {
  voiture :Voiture={
    id:-1,
    marque:"",
    annee:"",
    prix:"",
    matricule:"",
    numDeChoussi:""
  }
  constructor(private voitureService:VoitureService){}


  addVoiture(){
    this.voitureService.addvoiture(this.voiture).subscribe(
      newVoiture => {
        console.log("voiture added");
        this.resetForm();
      },
      error => {
        console.error("Error adding voiture:", error);
        // Handle the error here, such as displaying a message to the user
      }
    );
  }
resetForm(){
  this.voiture={
    id:-1,
    marque:"",
    annee:"",
    prix:"",
    matricule:"",
    numDeChoussi:""
  }
}
}