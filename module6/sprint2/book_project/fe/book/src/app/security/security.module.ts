import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SecurityRoutingModule} from './security-routing.module';
import {LoginComponent} from './login/login.component';
import {ResetPasswordComponent} from './reset-password/reset-password.component';

import {ReactiveFormsModule} from '@angular/forms';
import { VerifyResetPasswordComponent } from './verify-reset-password/verify-reset-password.component';


@NgModule({
  declarations: [LoginComponent, ResetPasswordComponent, VerifyResetPasswordComponent],

  imports: [
    CommonModule,
    SecurityRoutingModule,
    ReactiveFormsModule
  ]
})
export class SecurityModule {
}
