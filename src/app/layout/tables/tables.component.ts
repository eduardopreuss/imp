import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-tables',
    templateUrl: './tables.component.html',
    styleUrls: ['./tables.component.scss'],
    animations: [routerTransition()]
})
export class TablesComponent implements OnInit {

    tableHeader: string[];
    thFontWeight: string;
    program: object[];

    constructor() {
        this.tableHeader = ['Title', 'Description', 'Owner', 'Start Date', 'End Date'];

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
    ngOnInit() { }
}
