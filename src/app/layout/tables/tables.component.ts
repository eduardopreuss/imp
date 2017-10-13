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

    constructor() { 
        this.tableHeader = ['Title', 'Description', 'Owner', 'Start Date', 'End Date'];
        
    }
    ngOnInit() { }
}
