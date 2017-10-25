import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PeopleDetailListComponent } from './people-detail-list.component';

describe('PeopleDetailListComponent', () => {
  let component: PeopleDetailListComponent;
  let fixture: ComponentFixture<PeopleDetailListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PeopleDetailListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PeopleDetailListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
