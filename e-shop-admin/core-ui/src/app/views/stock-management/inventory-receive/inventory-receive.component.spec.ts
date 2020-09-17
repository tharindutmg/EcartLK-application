import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryReceiveComponent } from './inventory-receive.component';

describe('InventoryReceiveComponent', () => {
  let component: InventoryReceiveComponent;
  let fixture: ComponentFixture<InventoryReceiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryReceiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryReceiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
