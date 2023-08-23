import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../ApiService';
import { Producto } from '../interfaces';
import { DataService } from '../servicios/data.service';
import { ProductosService } from '../servicios/productos.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  lista: Producto[] = [];
  nombre: string = '';
  producto?: Producto = undefined;
  @Output()
  enviar: EventEmitter<string> = new EventEmitter<string>();

  busqueda: string = '';
  opcion: string = '';

  constructor(private router:Router, private api:ApiService, private dataService: DataService, private productosService: ProductosService) { }

  ngOnInit(): void {
  }
  iniciaSesion(){
    this.router.navigate(['login']);
  }
  buscarProducto(){
    this.productosService.buscarProductosPorNombre(this.busqueda).subscribe( data => {
      console.log("listado busqueda : " + data.productos);
      this.dataService.productos = data.productos;
      console.log(this.dataService.productos);
      this.opcion = "mostrar";
      this.dataService.opcion = this.opcion;
    });
  } 
  /*verCarrito(){
    console.log("Viendo carro: ")
    this.router.navigate(['cart']);
  } */
  paginaPrincipal(){
    this.router.navigate(['home']);
  }
}
