import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../ApiService';
import { Producto } from '../interfaces';
import { DataService } from '../servicios/data.service';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.scss']
})
export class ListadoComponent implements OnInit {
  nombre: string = '';
  lista: Producto[] = [];
  lista2: Producto[] = [];
  producto?: Producto = undefined;
  indice: number = -1;
  cantidad2: number = 0;
  cart: any;

  constructor(private api: ApiService, public dataService: DataService, private router: Router) { }

  ngOnInit(): void {
    this.api.obternerProductos().subscribe( data => {
      this.lista = data.productos;
    });
    //this.dataService.currentCart.subscribe(editCart => (this.cart= editCart)); //<= Always get current value!

    //this.getProduct();
  }

  /*async getProduct() {
    const data = await this.productService.getAll();
    // console.log('data-', data);
    if(data){
      this.products = data.data;
      console.log('this.products-', this.products);
    }
  }*/

  agregarCarrito(cantidad: number, producto: Producto){
    /*this.cart.lista2.push(producto);
    this.cart.cart = this.cart*/
    this.cantidad2 = this.cantidad2 + cantidad;
    console.log("this cantidad 2: " + this.cantidad2)

    this.lista2.push(producto);
    this.dataService.productos2 = this.lista2;
    console.log(this.lista2)
    console.log(producto.idProducto);
    console.log(producto.imagen);
    console.log(producto.marca);
    console.log(producto.precioUnitario);
  }
}
