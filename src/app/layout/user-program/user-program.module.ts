import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserProgramRoutingModule } from './user-program-routing.module';
import { UserProgramComponent } from './user-program.component';
import { PageHeaderModule } from './../../shared';

import { DatePickerComponent } from '../bs-component/components/date-picker/date-picker.component';

@NgModule({
    imports: [
        CommonModule,
        UserProgramRoutingModule,
        PageHeaderModule
    ],
    declarations: [UserProgramComponent]
})
export class UserProgramModule { }
