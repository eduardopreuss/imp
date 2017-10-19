import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditProgramRoutingModule } from './edit-program-routing.module';
import { EditProgramComponent } from './edit-program.component';
import { PageHeaderModule } from './../../shared';

import { DatePickerComponent } from '../bs-component/components/date-picker/date-picker.component';

@NgModule({
    imports: [
        CommonModule,
        EditProgramRoutingModule,
        PageHeaderModule
    ],
    declarations: [EditProgramComponent]
})
export class EditProgramModule { }
