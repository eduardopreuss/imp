import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EditProgramRoutingModule } from './edit-program-routing.module';
import { EditProgramComponent } from './edit-program.component';
import { PageHeaderModule } from './../../shared';

import { DatePickerComponent } from '../bs-component/components/date-picker/date-picker.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [
        CommonModule,
        EditProgramRoutingModule,
        PageHeaderModule,
        NgbModule,
        FormsModule
    ],
    declarations: [EditProgramComponent]
})
export class EditProgramModule { }
