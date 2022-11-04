import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { AddExpositionComponent } from './pages/admin/exposition/add-exposition/add-exposition.component';
import { ExpositionDetailComponent } from './pages/admin/exposition/exposition-detail/exposition-detail.component';
import { ExpositionListComponent } from './pages/admin/exposition/exposition-list/exposition-list.component';
import { UpdateExpositionComponent } from './pages/admin/exposition/update-exposition/update-exposition.component';
import { HomeComponent } from './pages/admin/home/home.component';
import { AddOeuvreComponent } from './pages/admin/oeuvre/add-oeuvre/add-oeuvre.component';
import { OeuvreDetailComponent } from './pages/admin/oeuvre/oeuvre-detail/oeuvre-detail.component';
import { OeuvreListComponent } from './pages/admin/oeuvre/oeuvre-list/oeuvre-list.component';
import { UpdateOeuvreComponent } from './pages/admin/oeuvre/update-oeuvre/update-oeuvre.component';
import { ProfileComponent } from './pages/admin/profile/profile.component';
import { AddSessionComponent } from './pages/admin/session/add-session/add-session.component';
import { SessionListComponent } from './pages/admin/session/session-list/session-list.component';
import { UpdateSessionComponent } from './pages/admin/session/update-session/update-session.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { SigninComponent } from './pages/signin/signin.component';

const routes: Routes = [
  {
    path : "", 
    component : SigninComponent, 
    pathMatch : "full"
  },
  {
    path : "signin", 
    component : SigninComponent,
     pathMatch : "full"
  },
  {
    path : "admin",
    component : DashboardComponent, 
    children : [
      {
        path : "profile",
        component : ProfileComponent
      },
      {
        path : "home",
        component : HomeComponent
      },
      {
        path : "oeuvre/all",
        component : OeuvreListComponent
      },
      {
        path : "oeuvre/create",
        component : AddOeuvreComponent
      },
      {
        path : "oeuvre/update/:oeuvreId",
        component : UpdateOeuvreComponent
      },
      {
        path : "oeuvre/detail/:oeuvreId",
        component : OeuvreDetailComponent
      },
      {
        path : "session/all",
        component : SessionListComponent
      },
      {
        path : "session/create",
        component : AddSessionComponent
      },
      {
        path : "session/update/:sessionId",
        component : UpdateSessionComponent
      },
      {
        path : "exposition/all",
        component : ExpositionListComponent
      },
      {
        path : "exposition/create",
        component : AddExpositionComponent
      },
      {
        path : "exposition/update/:expoId",
        component : UpdateExpositionComponent
      },
      {
        path : "exposition/detail/:expoId",
        component : ExpositionDetailComponent
      }
    ]
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
