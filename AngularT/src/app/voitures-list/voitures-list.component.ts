import { Component, OnInit } from '@angular/core';
import { VoitureService } from '../voiture.service';
import { Voiture } from '../models/Voiture.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
declare var $:any;
@Component({
  selector: 'app-voitures-list',
  templateUrl: './voitures-list.component.html',
  styleUrls: ['./voitures-list.component.css']
})
export class VoituresListComponent implements OnInit {
  voitures: Voiture[] =[];

  constructor(private voitureService :VoitureService,private router:Router) {}

  ngOnInit(): void {
    this.voitureService.getAllVoitures().subscribe(listVoiture => 
        {
        this.voitures = listVoiture;
      },
      
    );
  }
  delete(id:number){
    this.voitureService.deleteVoiture(id).subscribe(()=>{
      console.log("voiture deleted")
    }
    )
  }
  //delete2

  VoitureToDelete!:Voiture

confirmationDelete(voiture: Voiture) {
  $('#deleteModal').modal('show'); // Fix typo here
  this.VoitureToDelete = voiture;
}

closeDelete(){
  $('#deleteModal').modal('hide');
}


  deleteVoiture()
  {
this.voitureService.deleteVoiture(this.VoitureToDelete.id).subscribe(()=>{
  console.log("voiture deleted")
  $('♯deleteModal').modal('hide');
  window.location.reload();
  }
  
)
}
updateVoiture(id:number)
{
this.router.navigate(["/update",id])
}

}
