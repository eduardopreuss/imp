import { Component, ViewEncapsulation } from '@angular/core';
import { routerTransition } from '../../router.animations';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-edit-program',
    templateUrl: './program-details.component.html',
    styleUrls: ['./program-details.component.scss'],
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
export class ProgramDetailsComponent {
  closeResult: string;

  constructor(private modalService: NgbModal) {}

  open(content) {
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }
}
