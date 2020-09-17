import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryAssignComponent } from './inventory-assign.component';

describe('InventoryAssignComponent', () => {
  let component: InventoryAssignComponent;
  let fixture: ComponentFixture<InventoryAssignComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryAssignComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryAssignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
