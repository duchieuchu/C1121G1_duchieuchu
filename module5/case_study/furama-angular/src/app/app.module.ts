import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { FacilitiAddComponent } from './faciliti/faciliti-add/faciliti-add.component';
import { FacilitiEditComponent } from './faciliti/faciliti-edit/faciliti-edit.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { CustomerAddComponent } from './customer/customer-add/customer-add.component';
import { ContractListComponent } from './contract/contract-list/contract-list.component';
import { ContractAddComponent } from './contract/contract-add/contract-add.component';
import {AppRoutingModule} from './app-routing.module';
// import {RouterModule} from '@angular/router';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    FacilitiAddComponent,
    FacilitiEditComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerAddComponent,
    ContractListComponent,
    ContractAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
