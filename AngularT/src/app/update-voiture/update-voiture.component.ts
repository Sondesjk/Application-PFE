import { Component, OnInit } from '@angular/core';
import { Voiture } from '../models/Voiture.model';
import { VoitureService } from '../voiture.service';
import { ActivatedRoute } from '@angular/router';


declare var $:any;
@Component({
  selector: 'app-update-voiture',
  templateUrl: './update-voiture.component.html',
  styleUrls: ['./update-voiture.component.css']
})
export class UpdateVoitureComponent implements OnInit  {
 
  voiture!: Voiture;
voitureId!: number;
constructor(private voitureService:VoitureService,private route:ActivatedRoute){}
  ngOnInit(): void {
  this.voitureId=+this.route.snapshot.paramMap.get('id') !; 
  this.getVoiture();
  }
  getVoiture(){
    this.voitureService.getVoitureById(this.voitureId).subscribe(voitureP =>
      {
        this.voiture=voitureP
      }
    )
  }

  confirmupdate() {
    $('#updateModal').modal('show');
   
  }

  closeUpdate() {
    $('#updateModal').modal('hide');
  }
updateVoiture(){
  if(this.voiture){
  this.voitureService.updateVoiture(this.voitureId,this.voiture).subscribe(updateVoiture=>
    {
      console.log("Update",updateVoiture)
      $('#updateModal').modal('hide');
    })
}
 
  }}

