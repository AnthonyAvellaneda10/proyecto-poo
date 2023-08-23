import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../ApiService';
import { Producto } from '../interfaces';
import { DataService } from '../servicios/data.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
 
  lista: Producto[] = [];
  producto?: Producto = undefined;
  constructor(
    private api: ApiService,
    public dataService: DataService,
    private router: Router,
    private actRoute: ActivatedRoute
  ) { }
  ngOnInit(): void {
    this.api.obternerProductos().subscribe( data => {
      this.lista = data.productos;
    });
   
  }
  removeCart(idProducto: number){

  }
  
}
