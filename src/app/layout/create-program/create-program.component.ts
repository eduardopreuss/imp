import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

const now = new Date();

@Component({
    selector: 'app-create-program',
    templateUrl: './create-program.component.html',
    styleUrls: ['./create-program.component.scss'],
    animations: [routerTransition()]
})
export class CreateProgramComponent implements OnInit {
    model: NgbDateStruct;
    model2: NgbDateStruct;
    date: {year: number, month: number};
    selectToday() {
      this.model = {year: now.getFullYear(), month: now.getMonth() + 1, day: now.getDate()};
    }
    constructor() { }
    ngOnInit() {}
}
