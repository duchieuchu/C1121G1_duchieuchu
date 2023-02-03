import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BaseRoutingModule } from './base-routing.module';
import { BaseListComponent } from './base-list/base-list.component';
import { BaseCreateComponent } from './base-create/base-create.component';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [BaseListComponent, BaseCreateComponent],
  imports: [
    CommonModule,
    BaseRoutingModule,
    ReactiveFormsModule
  ]
})
export class BaseModule { }
