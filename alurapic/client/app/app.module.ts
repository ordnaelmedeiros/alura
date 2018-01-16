import 'rxjs/add/operator/map';

import { routing } from './app.routes';

import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { FotoModule } from './foto/foto.module';
import { PainelModule } from './painel/painel.module';

import { AppComponent }   from './app.component';
import { ListagemComponent } from './listagem/listagem.component';
import { CadastroComponent } from './cadastro/cadastro.component';

import { FormsModule } from '@angular/forms';

@NgModule({
  imports:[
    routing,
    BrowserModule,
    HttpModule,
    FormsModule,
    
    FotoModule,
    PainelModule
  ],
  declarations: [
    AppComponent,
    ListagemComponent,
    CadastroComponent
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule {

}