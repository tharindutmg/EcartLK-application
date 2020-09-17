import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccessGroupMapComponent } from './access-group-map.component';

describe('AccessGroupMapComponent', () => {
  let component: AccessGroupMapComponent;
  let fixture: ComponentFixture<AccessGroupMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccessGroupMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccessGroupMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
