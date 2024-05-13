import { Component, NgModule } from '@angular/core';
import { UserService } from '../user.service';
import { error } from 'jquery';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Voiture } from '../models/Voiture.model';
@NgModule({
  imports: [
    FormsModule
  ],
})
export class AppModule { }
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = "";
  password: string = "";
voiture!:Voiture;
  constructor(private userService: UserService,private router: Router) {}

  login() {
    if (this.username && this.password) { // Vérifiez si les valeurs sont définies
      this.userService.login(this.username, this.password).subscribe(
        () => {
          localStorage.setItem("voiture",JSON.stringify(this.voiture));
          localStorage.setItem("isloggedIn","true");

          console.log("Utilisateur connecté");
          this.router.navigate(["home"]);
        },
        error => {
          console.error("Erreur lors de la connexion :", error);
        }
      );
    } else {
      console.error("Veuillez fournir un nom d'utilisateur et un mot de passe.");
    }
  }
  
}
