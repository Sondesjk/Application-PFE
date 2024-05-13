import { Component } from '@angular/core';
import { QRCodeModule } from 'angularx-qrcode'; // Importez QRCodeModule depuis angularx-qrcode

@Component({
  selector: 'app-qrcode',
  templateUrl: './qrcode.component.html',
  styleUrls: ['./qrcode.component.css']
})
export class QRcodeComponent {
  carInfo: string = ''; // Informations sur la voiture à encoder dans le QR code
  qrCodeValue: string = ''; // Valeur du QR code à afficher

  constructor() {} // Pas besoin d'injecter de service

  generateQRCode(): void {
    // Générer le QR code à partir des informations de la voiture
    this.qrCodeValue = this.carInfo; // Utilisez simplement les informations de la voiture sans besoin de service
  }
}
