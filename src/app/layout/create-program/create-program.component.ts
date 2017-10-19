import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import {Http, RequestOptions} from "@angular/http";
import {Headers} from '@angular/http';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

const now = new Date();

@Component({
    selector: 'app-create-program',
    templateUrl: './create-program.component.html',
    styleUrls: ['./create-program.component.scss'],
    animations: [routerTransition()]
})
export class CreateProgramComponent implements OnInit {
   


  constructor(private http: Http, private options: RequestOptions) {

      let headers = new Headers({ 'Content-Type': 'application/json' });
      this.options = new RequestOptions({ headers: headers });

  }

    onSubmit(form){

        this.http.post('api/createProgram', JSON.stringify(form.value), this.options)
            .map( res => res.json())
            .subscribe();
    }

  ngOnInit() {
  }
}