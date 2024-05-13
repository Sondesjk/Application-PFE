import { Component, OnInit } from '@angular/core';
import { CommandeService } from '../commande.service';
import { Commande } from '../models/Commande.model';

@Component({
  selector: 'app-commande-list',
  templateUrl: './commande-list.component.html',
  styleUrls: ['./commande-list.component.css']
})
export class CommandeListComponent implements OnInit {
  commandes:Commande[]=[];
  router: any;
  constructor(private commandeService :CommandeService){}
  ngOnInit(): void {
    this.commandeService.getAllCommandes().subscribe(list=>
      {
        this.commandes=list;
      }
    )
  }
}
