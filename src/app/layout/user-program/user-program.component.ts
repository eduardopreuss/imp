import { Component, ViewEncapsulation } from '@angular/core';
import { routerTransition } from '../../router.animations';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-user-program',
    templateUrl: './user-program.component.html',
    styleUrls: ['./user-program.component.scss'],
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
export class UserProgramComponent {
  closeResult: string;

  constructor(private modalService: NgbModal) {}

  open(content) {
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }
}
