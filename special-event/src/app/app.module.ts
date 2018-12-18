import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { AddSpecialEventComponent } from './add-special-event/add-special-event.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ShowSpecialEventComponent } from './show-special-event/show-special-event.component';
import { CheckboxExampleComponent } from './checkbox-example/checkbox-example.component';
import { TimePickerComponent } from './time-picker/time-picker.component';
import { CheckboxDatabaseComponent } from './checkbox-database/checkbox-database.component';

@NgModule({
  declarations: [
    AppComponent,
    AddSpecialEventComponent,
    ShowSpecialEventComponent,
    CheckboxExampleComponent,
    TimePickerComponent,
    CheckboxDatabaseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
