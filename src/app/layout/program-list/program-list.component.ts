import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-program-list',
    templateUrl: './program-list.component.html',
    styleUrls: ['./program-list.component.scss'],
    animations: [routerTransition()]
})
export class ProgramListComponent {
tableHeader: string[];
    thFontWeight: string;
    program: object[];

    constructor() {
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
            },
            {
                title: 'Pink October',
                description: 'Program for Cancer fighting',
                owner: 'Parkash, Adilah',
                startDate: '10/01/2017',
                endDate: '10/31/2017'
            },
            {
                title: 'Blue November',
                description: 'Program for Mens fighting cancer',
                owner: 'Doe, John',
                startDate: '11/01/2017',
                endDate: '11/31/2017'
            },
            {
                title: 'Christamas Night',
                description: 'A very special night for giving gifts',
                owner: 'Claus, Santa',
                startDate: '12/25/2017',
                endDate: '12/26/2017'
            },
        ];
    }
}
