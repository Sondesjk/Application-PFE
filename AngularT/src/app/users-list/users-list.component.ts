import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../models/User.model';

declare var $:any;
@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
  users: any[] = [];


  constructor(private userService: UserService,private router:Router) {}

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((listUser: any) => {
      this.users = listUser;
    });
  }
  
  
 UserToDelete!:User

confirmationDelete(user: User) {
  $('#deleteModal').modal('show'); // Fix typo here
  this.UserToDelete = user;
}

closeDelete(){
  $('#deleteModal').modal('hide');
}
deleteUser()
{
this.userService.deleteUser(this.UserToDelete.id).subscribe(()=>{
console.log("user deleted")
$('♯deleteModal').modal('hide');
window.location.reload();
}

)


}
updateUser(id:number)
{
this.router.navigate(["/updateU",id])
}




}
