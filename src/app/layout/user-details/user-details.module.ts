import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { UserDetailsRoutingModule } from './user-details-routing.module';
import { UserDetailsComponent } from './user-details.component';
import { PageHeaderModule } from './../../shared/modules/page-header/page-header.module';

@NgModule({
    imports: [
        CommonModule,
        UserDetailsRoutingModule,
        PageHeaderModule,
        FormsModule,
        HttpModule
    ]
})

export class UserDetailsModule { }

