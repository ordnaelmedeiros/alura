import {Component} from '@angular/core';
import {Http} from '@angular/http';

@Component({
    selector: 'app',
    templateUrl: './app/app.component.html'
})
export class AppComponent {

    fotos:Object[] = [];

    constructor(http:Http) {

        http.get('v1/fotos')
        .map(res => res.json())
        .subscribe(
            fotos => this.fotos = fotos,
            erro => console.log(erro)
        );

    }

}