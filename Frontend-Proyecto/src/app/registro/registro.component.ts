import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario, UsuarioNuevo } from '../interfaces';
import { RegistroService } from '../servicios/registro.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent implements OnInit {
  nombre: string = '';
  apellido: string = '';
  email: string = '';
  password: string = '';
  usuarioNuevo?: UsuarioNuevo;
  usuario?: Usuario;
  mensaje: string = '';
  constructor(private router:Router, private registroService: RegistroService) { }

  ngOnInit(): void {
  }

  registrarse(){
    let usuarioNuevo: UsuarioNuevo;

    usuarioNuevo = {
      email: this.email,
      contraseña: this.password,
      nombres: this.nombre,
      apellidos: this.apellido
    }

    this.registroService.registrar(usuarioNuevo).subscribe( data => {
      if(data){
        this.usuario = data;
        this.router.navigate(['home']);
      }
    },err => {this.mensaje = err;});
  }
  iniciaSesion(){
    this.router.navigate(['login']);
  }
}
