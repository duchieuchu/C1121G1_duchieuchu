import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {BookModule} from './book/book.module';
import {ShareModule} from './share/share.module';
import {ToastrModule} from 'ngx-toastr';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import {authInterceptorProviders} from './_helpers/auth.interceptor';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { Error401PageComponent } from './error401-page/error401-page.component';
import { Error403PageComponent } from './error403-page/error403-page.component';
import { Error404PageComponent } from './error404-page/error404-page.component';
import {AuthGuard} from './authguard/auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    CartComponent,
    CheckoutComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
    Error401PageComponent,
    Error403PageComponent,
    Error404PageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    BookModule,
    ShareModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-right',
        preventDuplicates: true,
      }
    )
  ],
  providers: [authInterceptorProviders, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
