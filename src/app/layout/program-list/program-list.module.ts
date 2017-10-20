import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProgramListRoutingModule } from './program-list-routing.module';
import { ProgramListComponent } from './program-list.component';
import { PageHeaderModule } from './../../shared';

import { DatePickerComponent } from '../bs-component/components/date-picker/date-picker.component';

@NgModule({
    imports: [
        CommonModule,
        ProgramListRoutingModule,
        PageHeaderModule
    ],
    declarations: [ProgramListComponent]
})
export class ProgramListModule { }
