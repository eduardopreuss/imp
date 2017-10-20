import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProgramDetailsRoutingModule } from './program-details-routing.module';
import { ProgramDetailsComponent } from './program-details.component';
import { PageHeaderModule } from './../../shared';

import { DatePickerComponent } from '../bs-component/components/date-picker/date-picker.component';

@NgModule({
    imports: [
        CommonModule,
        ProgramDetailsRoutingModule,
        PageHeaderModule
    ],
    declarations: [ProgramDetailsComponent]
})
export class ProgramDetailsModule { }
