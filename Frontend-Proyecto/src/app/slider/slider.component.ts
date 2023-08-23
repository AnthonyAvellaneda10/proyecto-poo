import { Component, OnInit } from '@angular/core';
import { CargaScriptsService } from '../carga-scripts.service';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.scss']
})
export class SliderComponent implements OnInit {

  constructor(private cargaScripts:CargaScriptsService) {
    cargaScripts.carga(["slider"]);
    
   }

  ngOnInit(): void {
  }

}
