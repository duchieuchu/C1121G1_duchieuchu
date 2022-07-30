import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {HomeComponent} from './home/home.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerAddComponent} from './customer/customer-add/customer-add.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {RouterModule, Routes} from '@angular/router';
import {ProductBlockListComponent} from './product-block/product-block-list/product-block-list.component';
import {ProductBlockCreateComponent} from './product-block/product-block-create/product-block-create.component';
// import {FacilitiAddComponent} from './faciliti/faciliti-add/faciliti-add.component';
// import {ContractAddComponent} from './contract/contract-add/contract-add.component';
// import {ContractListComponent} from './contract/contract-list/contract-list.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-add', component: CustomerAddComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},
  {path: 'product-block-list', component: ProductBlockListComponent},
  {path: 'product-block-add', component: ProductBlockCreateComponent},
  // {path: 'faciliti-add', component: FacilitiAddComponent},
  // {path: 'contract-list', component: ContractListComponent},
  // {path: 'contract-add', component: ContractAddComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
