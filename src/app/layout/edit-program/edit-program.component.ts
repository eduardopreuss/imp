import { Component, ViewEncapsulation } from '@angular/core';
import { routerTransition } from '../../router.animations';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-edit-program',
    templateUrl: './edit-program.component.html',
    styleUrls: ['./edit-program.component.scss'],
    animations: [routerTransition()],
    encapsulation: ViewEncapsulation.None,
    styles: [`
      .dark-modal .modal-content {
        background-color: #1d60a3;
        color: white;
      }
      .dark-modal .close {
        color: white;
      }
    `]
})
export class EditProgramComponent {
  closeResult: string;
  startDate: NgbDateStruct;
  endDate: NgbDateStruct;
  date: {year: number, month: number};
  getStartDate() {
      this.startDate = {year: 2017, month: 8, day: 17};
  }
  getEndDate() {
      this.endDate = {year: 2019, month: 8, day: 17};
  }
  constructor(private modalService: NgbModal) {
    // this.getStartDate();
    // this.getEndDate();
  }

  open(content) {
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }
}
