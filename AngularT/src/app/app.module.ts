import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ProfileComponent } from './profile/profile.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { AjouterComponent } from './ajouterV/ajouter.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AddvoitureComponent } from './addvoiture/addvoiture.component';
import { VoituresListComponent } from './voitures-list/voitures-list.component';
import { LoginComponent } from './login/login.component';
import { UpdateVoitureComponent } from './update-voiture/update-voiture.component';
import { UsersListComponent } from './users-list/users-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { RechercheComponent } from './recherche/recherche.component';
import { CommandeListComponent } from './commande-list/commande-list.component';
import { AddcommandeComponent } from './addcommande/addcommande.component';
import { CommandeComponent } from './commande/commande.component';
import { Commande1Component } from './commande1/commande1.component';
import { Commande2Component } from './commande2/commande2.component';
import { CommandeeComponent } from './commandee/commandee.component';
import { CommandesComponent } from './commandes/commandes.component';
import { AdminComponent } from './admin/admin.component';

imports: [
  FormsModule
]

@NgModule({
  declarations: [
    AppComponent,
   HomeComponent,
    FooterComponent,
    NavbarComponent,
    SignInComponent,
    SignUpComponent,
    ProfileComponent,
    AboutComponent,
    ContactComponent,
    AjouterComponent,
    AddvoitureComponent,VoituresListComponent, LoginComponent, UpdateVoitureComponent, UsersListComponent, AddUserComponent, UpdateUserComponent, RechercheComponent, CommandeListComponent, AddcommandeComponent, CommandeComponent, Commande1Component, Commande2Component, CommandeeComponent, CommandesComponent, AdminComponent, 
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
   HttpClientModule, FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
