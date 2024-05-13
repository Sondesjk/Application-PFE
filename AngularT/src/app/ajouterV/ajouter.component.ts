import { Component } from '@angular/core';
import { Voiture } from '../models/Voiture.model';

@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.component.html',
  styleUrls: ['./ajouter.component.css']
})
export class AjouterComponent {
voitures: Voiture[]=[
  {
  id:1,
    marque:"luxe",
   annee:"2023",
   prix:"467774",
   matricule:"bmw",
   numDeChoussi:"56543"
  },
  {
  id:2,
  marque:"Golf",
 annee:"2022",
 prix:"984574",
 matricule:"Golf",
 numDeChoussi:"873489"
},
{
id:1,
    marque:"DMX",
   annee:"2024",
   prix:"22000",
   matricule:"bmw",
   numDeChoussi:"76543"
  }
] 

voitureClick(voiture:Voiture){
  console.log("voiture Clicked",voiture);
}

}
