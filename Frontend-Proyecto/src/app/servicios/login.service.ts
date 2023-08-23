import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { Usuario, UsuarioLogin } from '../interfaces';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

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
    console.log("ShowError " + errorMessage);
    return throwError(errorMessage);
  }
  constructor(private http: HttpClient) { }

  login(usuarioLogin: UsuarioLogin){
  
    return this.http.post<Usuario>('http://localhost:8080/autenticar-usuario', usuarioLogin, this.httpOptions)
        .pipe(
          retry(0),
          catchError(this.errorHandl)
        );
  }
}


