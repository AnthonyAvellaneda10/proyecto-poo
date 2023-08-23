import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { from, Observable, throwError } from "rxjs";
import { Producto, RespuestaProducto } from "./interfaces";
import { retry, catchError } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })
  export class ApiService {
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
      console.log(errorMessage);
      return throwError(errorMessage);
    }
    constructor(private http: HttpClient) { }
    
    obternerProductos(): Observable<RespuestaProducto> {


      /*return this.http.post<RespuestaProductos>('http://localhost:8080/obtener-productos', null, this.httpOptions)
        .pipe(
          retry(1),
          catchError(this.errorHandl)
        );*/

      return this.http.get<RespuestaProducto>('http://localhost:8080/obtener-productos');
    }

    /*buscarProductos(string: Producto.nombre): Observable<RespuestaProducto>{
      return this.http.get<RespuestaProducto>('http://localhost:8080//buscar-productos-nombre/{nombreProducto}');
    }*/
  }
  