import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { routerTransition } from '../../router.animations';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-program-list',
    templateUrl: './program-list.component.html',
    styleUrls: ['./program-list.component.scss'],
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
export class ProgramListComponent {
tableHeader: string[];
    thFontWeight: string;
    program: object[];
    closeResult: string;

    constructor(private modalService: NgbModal) {
        this.tableHeader = ['Title', 'Description', 'Owner', 'Start Date', 'End Date', 'Actions'];

            this.program = [{
                title: 'Dell IT Academy',
                description: 'Program developed for the purpose of hiring new interns',
                owner: 'Muller, Nelson',
                startDate: '08/01/2017',
                endDate: '01/31/2018'
            },
            {
                title: 'U@Dell',
                description: 'Talent Aquisition Program',
                owner: 'Fernandes, Gabriela',
                startDate: '01/01/2017',
                endDate: '12/31/2017'
            },
            {
                title: 'Tests Program',
                description: 'Program for testing software',
                owner: 'Callegari, Daniel',
                startDate: '01/01/2017',
                endDate: '12/31/2017'
            },
            {
                title: 'DevTeamCoop',
                description: 'Software development program created for undergraduate students!!!',
                owner: 'Dell, Michael',
                startDate: '01/01/2017',
                endDate: '12/31/2017'
            }
        ];
    }
    open(content) {
        this.modalService.open(content, { windowClass: 'dark-modal' });
    }
}
