import {Component, Input} from '@angular/core';
import {Http} from '@angular/http';

@Component({
    selector: 'foto',
    templateUrl: './app/foto/foto.component.html'
})
export class FotoComponent {

    @Input() titulo:string;
    @Input() url:string;
    descricao:string;
    
    constructor() {

    }

}