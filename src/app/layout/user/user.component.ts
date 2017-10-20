import { Component, OnInit } from '@angular/core';
import {routerTransition} from '../../router.animations';
import {Http, RequestOptions} from '@angular/http';
import {Headers} from '@angular/http';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
    animations: [routerTransition()]
})
export class UserComponent implements OnInit {


  constructor(private http: Http, private options: RequestOptions) {

      const headers = new Headers({ 'Content-Type': 'application/json' });
      this.options = new RequestOptions({ headers: headers });

  }

    onSubmit(form){
        this.http.post('api/user', JSON.stringify(form.value), this.options).subscribe();
    }

  ngOnInit() {
  }

}
