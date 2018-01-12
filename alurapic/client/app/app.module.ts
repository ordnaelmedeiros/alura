import 'rxjs/add/operator/map';

import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }   from './app.component';
import { FotoModule } from './foto/foto.module';

@NgModule({
  imports:      [ BrowserModule, HttpModule, FotoModule ],
  declarations: [ AppComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule {

}