import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ReactiveFormComponent} from './reactive-form/reactive-form.component';
import {TemplateDrivenFormComponent} from './template-driven-form/template-driven-form.component';

const routes: Routes = [
  {path: 'reactive', component: ReactiveFormComponent},
  {path: 'template-driven', component: TemplateDrivenFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
