import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { DetalleProductoComponent } from './detalle-producto/detalle-producto.component';
import { HomeComponent } from './home/home.component';
import { ListadoComponent } from './listado/listado.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';

const routes: Routes = [
  {path:"home",           component: HomeComponent},
  {path:"productos",  component: ListadoComponent},
  {path:"login",      component: LoginComponent},
  {path:"detalle-producto/:codigo",  component: DetalleProductoComponent},
  {path:"registro",   component: RegistroComponent},
  {path: "cart",      component: CartComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
