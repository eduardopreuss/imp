import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-user-details',
    templateUrl: './user-details.component.html',
    styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

    tableHeader: string[];
    program: object[];

    constructor() {
        this.tableHeader = ['Title', 'Start Date', 'End Date', 'Role', 'Status'];

        this.program = [{
            title: 'Dell IT Academy',
            startDate: '08/01/2017',
            endDate: '01/31/2018',
            role: 'Coordinator',
            status: 'Active'
        },
        {
            title: 'U@Dell',
            startDate: '01/01/2017',
            endDate: '12/31/2017',
            role: 'Coordinator',
            status: 'Active'
        },
        {
            title: 'Tests Program',
            startDate: '01/01/2017',
            endDate: '12/31/2017',
            role: 'Coordinator',
            status: 'Active'
        },
        {
            title: 'DevTeamCoop',
            startDate: '01/01/2017',
            endDate: '12/31/2017',
            role: 'Coordinator',
            status: 'Active'
        }]
    }

    ngOnInit() {
    }
}
