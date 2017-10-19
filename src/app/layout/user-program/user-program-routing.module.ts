import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserProgramComponent } from './user-program.component';

const routes: Routes = [
    { path: '', component: UserProgramComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserProgramRoutingModule { }
