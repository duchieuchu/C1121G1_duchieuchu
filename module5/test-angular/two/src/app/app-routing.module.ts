import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentCreateComponent} from './student-create/student-create.component';
import {StudentListComponent} from './student-list/student-list.component';

const routes: Routes = [
  {path: 'create', component: StudentCreateComponent},
  {path: '', component: StudentListComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
