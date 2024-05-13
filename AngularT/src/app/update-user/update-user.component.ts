import { Component, OnInit } from '@angular/core';
import { User } from '../models/User.model';
import { UserService } from '../user.service';
import { ActivatedRoute } from '@angular/router';
declare var $:any;
@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  user!: User;
 userId! :number;
 constructor(private userService:UserService, private route:ActivatedRoute){}
  
  ngOnInit(): void {
    this.userId=+this.route.snapshot.paramMap.get('id')!;
    this.getUser();
  }
  getUser(){
    this.userService.getUserById(this.userId).subscribe(userP =>
      {
        this.user=userP
      }
    )
  }
  confirmUpdate(){
      $('#updateModal').modal('show');
     
    }
  
    closeUpdate() {
      $('#updateModal').modal('hide');
    }
}
