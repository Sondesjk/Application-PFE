import { Component } from '@angular/core';
import { User } from '../models/User.model';
import { UserService } from '../user.service';
import { error } from 'jquery';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {

  user :User={
    id:-1,
  firstname:"",
lastname:"",
email:"",
username:"",
password:"",
confpassword:"",
address:""

}
constructor(private userService:UserService){}
addUser(){
  this.userService.addUser(this.user).subscribe(newUser=>
    {
    console.log("User added")
    this.resetForm()
  },error=>{
    console.error("Erreur",error)
  })
}
resetForm(){
  this.user={
    id:-1,
  firstname:"",
lastname:"",
email:"",
username:"",
password:"",
confpassword:"",
address:""
 
  }
}
}
