import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserDetailsComponent } from './user-details.component';

const routes: Routes = [
    { path: '', component: UserDetailsComponent }
];

@NgModule({

})

export class UserDetailsRoutingModule { }
