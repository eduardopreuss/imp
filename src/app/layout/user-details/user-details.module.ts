
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserDetailsRoutingModule } from './user-details-routing.module';
import { UserDetailsComponent } from './user-details.component';

@NgModule({
  imports: [
    CommonModule,
    UserDetailsRoutingModule,
    NgbModule
  ],
  declarations: [UserDetailsComponent]
})
export class UserDetailsModule { }
