import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Producto, ProductoDetallado } from '../interfaces';
import { ProductosService } from '../servicios/productos.service';

@Component({
  selector: 'app-detalle-producto',
  templateUrl: './detalle-producto.component.html',
  styleUrls: ['./detalle-producto.component.scss']
})
export class DetalleProductoComponent implements OnInit {
  producto?: Producto = undefined;
  productoDetalle?: ProductoDetallado = undefined;
  lista: Producto[] = [];
  indice:number = 0;
  indice2:number = 0;
  constructor(private productosService: ProductosService, private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    this.indice = Number(this.activatedRoute.snapshot.paramMap.get('codigo'));
    console.log("Indice: " + this.indice);
    this.productosService.obtenerProductosPorId(this.indice).subscribe( data => {
      console.log("Data: " + data);
      this.productoDetalle = data;
      console.log("this.producto: " + this.productoDetalle);
    });
  }

}
