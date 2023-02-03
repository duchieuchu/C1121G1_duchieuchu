import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BaseListComponent} from './base-list/base-list.component';
import {BaseCreateComponent} from './base-create/base-create.component';


const routes: Routes = [
  {path: 'base/list', component: BaseListComponent},
  {path: 'base/create', component: BaseCreateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BaseRoutingModule { }
