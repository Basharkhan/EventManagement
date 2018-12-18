import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckboxDatabaseComponent } from './checkbox-database.component';

describe('CheckboxDatabaseComponent', () => {
  let component: CheckboxDatabaseComponent;
  let fixture: ComponentFixture<CheckboxDatabaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckboxDatabaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckboxDatabaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
