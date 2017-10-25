
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { UserDetailsRoutingModule } from './user-details-routing.module';

import { PageHeaderComponent } from './../../shared/modules/page-header/page-header.component';

@NgModule({
    imports: [
        CommonModule,
        UserDetailsRoutingModule,
        FormsModule,
        HttpModule
    ]
})

export class UserDetailsModule { }

