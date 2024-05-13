import { Component } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  submitForm() {
    // Your code to handle form submission goes here
    // For demonstration purposes, let's just display an alert
    alert("Message sent successfully!");
  }
}
