import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { PageHeaderModule } from './../../shared';
import {UserService} from './user.service';


@NgModule({
    imports: [
        CommonModule,
        UserRoutingModule,
        PageHeaderModule,
        FormsModule,
        HttpModule
    ],
    declarations: [UserComponent],
    providers: [UserService]
})
export class UserModule { }
