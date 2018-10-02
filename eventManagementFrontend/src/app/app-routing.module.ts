import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventsComponent } from './events/events.component';
import { SpecialEventsComponent } from './special-events/special-events.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuardGuard } from './auth-guard.guard';

const routes: Routes = [
  {
    path: ' ',
    redirectTo: 'generalevents',
    pathMatch: 'full'
  },
  {path: 'generalevents', component: EventsComponent},
  {path: 'specialevents', component: SpecialEventsComponent, canActivate: [AuthGuardGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
