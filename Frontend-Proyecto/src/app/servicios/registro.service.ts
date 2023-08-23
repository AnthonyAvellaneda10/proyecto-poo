import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { Usuario, UsuarioLogin, UsuarioNuevo } from '../interfaces';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json;charset=utf-8'
    })
  };
  errorHandl(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    errorMessage = error.error.message;
    console.log(errorMessage);
    return throwError(errorMessage);
  }
  constructor(private http: HttpClient) { }

  registrar(usuarioNuevo: UsuarioNuevo){
  
    return this.http.post<Usuario>('http://localhost:8080/registrar-usuario', usuarioNuevo, this.httpOptions)
        .pipe(
          retry(0),
          catchError(this.errorHandl)
        );
  }
}