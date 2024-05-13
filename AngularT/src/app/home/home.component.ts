import { Component, OnInit } from '@angular/core';
import { User } from '../models/User.model';

declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentUser!: User;

  ngOnInit(): void {
    const userData = localStorage.getItem("user");
    if (userData) {
      this.currentUser = JSON.parse(userData);
    }
  }

  voitureService: any;

  confirmDelete() {
    $('#deleteModal').modal('show');
  }

  users: User[] = [
    {
      id: 1,
      firstname: "sondes",
      lastname: "jakhlouti",
      email: "akhloutisondes@gmail.com",
      username: "sondes",
      password: "",
      confpassword: "",
      address: "tunis"
    },
    {
      id: 2,
      firstname: "samira",
      lastname: "jakhlouti",
      email: "jakhloutis@gmail.com",
      username: "samira",
      password: "",
      confpassword: "",
      address: "tunis"
    },
    {
      id: 3,
      firstname: "aya",
      lastname: "benali",
      email: "aya@gmail.com",
      username: "aya",
      password: "",
      confpassword: "",
      address: "tunis"
    }
  ];
}
