import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowSpecialEventComponent } from './show-special-event.component';

describe('ShowSpecialEventComponent', () => {
  let component: ShowSpecialEventComponent;
  let fixture: ComponentFixture<ShowSpecialEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowSpecialEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowSpecialEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
