import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { ProductoDetallado } from '../interfaces';
import { RespuestaProducto } from '../interfaces';
@Injectable({
  providedIn: 'root'
})
export class ProductosService {
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
  url: string = `http://localhost:8080/buscar-productos-nombre`;
  url2: string = `http://localhost:8080/buscar-producto`;
  constructor(private http: HttpClient) { }

  buscarProductosPorNombre(nombre: string){
    return this.http.get<RespuestaProducto>(`${this.url}/${nombre}`);
    //return this.http.get<RespuestaProducto>('http://localhost:8080/buscar-productos-nombre/{nombreProducto}');
  }

  obtenerProductosPorId(id: number){
    return this.http.get<ProductoDetallado>(`${this.url2}/${id}`);
  }
}
