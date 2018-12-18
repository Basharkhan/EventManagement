import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSpecialEventComponent } from './add-special-event.component';

describe('AddSpecialEventComponent', () => {
  let component: AddSpecialEventComponent;
  let fixture: ComponentFixture<AddSpecialEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddSpecialEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSpecialEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
