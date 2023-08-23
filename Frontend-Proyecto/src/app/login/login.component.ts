import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CargaScriptsService } from '../carga-scripts.service';
import { UsuarioLogin } from '../interfaces';
import { Usuario } from '../interfaces';
import { LoginService } from '../servicios/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  email: string = '';
  password: string = '';
  mensaje: string = '';
  error: string = "";
  form?: FormGroup;
  usuarioLogin?: UsuarioLogin;
  usuario?: Usuario;
  
  constructor(private cargaScripts:CargaScriptsService, private router:Router, private loginService:LoginService) {
    cargaScripts.cargaStyles(["adminlte.min","all.min","icheck-bootstrap.min"]);
    
   }

  ngOnInit(): void {
  }

  iniciarSesion(){
    let usuarioLogin: UsuarioLogin;

    usuarioLogin = {
      email: this.email,
      contraseña: this.password
    }

    this.loginService.login(usuarioLogin).subscribe( data => {
      if(data){
        this.usuario = data;
        this.router.navigate(['home']);
      }
    },err => {this.mensaje = err;});
  }

  registrate(){
    this.router.navigate(['registro']);
  }
}
