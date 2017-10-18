import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { CreateProgramRoutingModule } from './create-program-routing.module';
import { CreateProgramComponent } from './create-program.component';
import { PageHeaderModule } from './../../shared';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [
        CommonModule,
        CreateProgramRoutingModule,
        PageHeaderModule,
        NgbModule,
        FormsModule
    ],
    declarations: [CreateProgramComponent]
})
export class CreateProgramModule { }
