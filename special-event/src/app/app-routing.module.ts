import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AddSpecialEventComponent } from './add-special-event/add-special-event.component';
import { ShowSpecialEventComponent } from './show-special-event/show-special-event.component';
import { CheckboxExampleComponent } from './checkbox-example/checkbox-example.component';
import { TimePickerComponent } from './time-picker/time-picker.component';
import { CheckboxDatabaseComponent } from './checkbox-database/checkbox-database.component';

const routes: Routes = [
  {path: 'add-special-event', component: AddSpecialEventComponent},
  {path: 'show-special-event', component: ShowSpecialEventComponent},
  {path: 'checkbox', component: CheckboxExampleComponent},
  {path: 'time-picker', component: TimePickerComponent},
  {path: 'checkbox-database', component: CheckboxDatabaseComponent}
]


@NgModule({
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
