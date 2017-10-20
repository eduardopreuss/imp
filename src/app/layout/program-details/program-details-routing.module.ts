import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProgramDetailsComponent } from './program-details.component';

const routes: Routes = [
    { path: '', component: ProgramDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProgramDetailsRoutingModule { }
