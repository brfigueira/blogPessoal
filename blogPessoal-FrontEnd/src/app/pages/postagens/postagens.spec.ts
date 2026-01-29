import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Postagens } from './postagens';

describe('Postagens', () => {
  let component: Postagens;
  let fixture: ComponentFixture<Postagens>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Postagens]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Postagens);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
