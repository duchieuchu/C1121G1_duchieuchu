import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {HomeComponent} from './home/home.component';
import {CategoryModule} from './category/category.module';
import {ProductModule} from './product/product.module';
import {AppRoutingModule} from './app-routing.module';
import {RouterModule} from '@angular/router';
import {ToastrModule} from 'ngx-toastr';
import {BaseModule} from './base/base.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    CategoryModule,
    ProductModule,
    AppRoutingModule,
    BaseModule,
    RouterModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
