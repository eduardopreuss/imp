import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminRightsComponent } from './admin-rights.component';

const routes: Routes = [
    { path: '', component: AdminRightsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRightsRoutingModule { }
