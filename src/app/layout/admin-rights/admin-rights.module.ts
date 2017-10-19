import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminRightsRoutingModule } from './admin-rights-routing.module';
import { AdminRightsComponent } from './admin-rights.component';
import { PageHeaderModule } from './../../shared';

import { DatePickerComponent } from '../bs-component/components/date-picker/date-picker.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [
        CommonModule,
        AdminRightsRoutingModule,
        PageHeaderModule,
        NgbModule,
        FormsModule
    ],
    declarations: [AdminRightsComponent]
})
export class AdminRightsModule { }
