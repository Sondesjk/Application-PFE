import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ProfileComponent } from './profile/profile.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { AjouterComponent } from './ajouterV/ajouter.component';
import { VoituresListComponent } from './voitures-list/voitures-list.component';
import { AddvoitureComponent } from './addvoiture/addvoiture.component';
import { LoginComponent } from './login/login.component';
import { UpdateVoitureComponent } from './update-voiture/update-voiture.component';
import { UsersListComponent } from './users-list/users-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { RechercheComponent } from './recherche/recherche.component';
import { CommandeListComponent } from './commande-list/commande-list.component'; 
import { CommandeComponent } from './commande/commande.component';
import { CommandeeComponent } from './commandee/commandee.component';
import { CommandesComponent } from './commandes/commandes.component';
import { Commande1Component } from './commande1/commande1.component';
import { Commande2Component } from './commande2/commande2.component';
import { AddcommandeComponent } from './addcommande/addcommande.component';
import { AdminComponent } from './admin/admin.component';
const routes: Routes = [

  {path:"home",component:HomeComponent},
  {path:'login',component:SignInComponent},
  {path:'register',component:SignUpComponent},
  {path:'profile',component:ProfileComponent},
  {path:'about',component:AboutComponent},
  {path:'contact',component:ContactComponent},
  {path:'ajouterV',component:AjouterComponent},
  {path:'add',component:AddvoitureComponent},

  {path:'voitures',component:VoituresListComponent},
  {path:'login1',component:LoginComponent},
  {path:'update/:id',component:UpdateVoitureComponent},
  {path:'users',component:UsersListComponent},
  {path:'adduser',component:AddUserComponent},
  {path:'updateU/:id',component:UpdateUserComponent},
  {path:'recherche',component:RechercheComponent},
  {path:'listcommande',component:CommandeListComponent},
  {path:'addcommande',component:AddcommandeComponent},
  {path:'commande',component:CommandeComponent},
  {path:'commandee',component:CommandeeComponent},
  {path:'commandes',component:CommandesComponent},
  {path:'commande1',component:Commande1Component},
  {path:'commande2',component:Commande2Component},
  {path:'admin',component:AdminComponent},
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
