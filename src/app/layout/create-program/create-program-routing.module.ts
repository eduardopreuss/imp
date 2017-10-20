import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CreateProgramComponent } from './create-program.component';

const routes: Routes = [
    { path: '', component: CreateProgramComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreateProgramRoutingModule { }
