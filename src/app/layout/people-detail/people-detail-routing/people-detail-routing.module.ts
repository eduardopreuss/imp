import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PeopleDetailListComponent } from '../people-detail-list.component';

const routes: Routes = [
  { path: '', component: PeopleDetailListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PeopleListRoutingModule { }
