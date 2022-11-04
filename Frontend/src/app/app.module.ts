import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SigninComponent } from './pages/signin/signin.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { ProfileComponent } from './pages/admin/profile/profile.component';
import { HomeComponent } from './pages/admin/home/home.component';
import { OeuvreListComponent } from './pages/admin/oeuvre/oeuvre-list/oeuvre-list.component';
import { AddOeuvreComponent } from './pages/admin/oeuvre/add-oeuvre/add-oeuvre.component';
import { UpdateOeuvreComponent } from './pages/admin/oeuvre/update-oeuvre/update-oeuvre.component';
import { SessionListComponent } from './pages/admin/session/session-list/session-list.component';
import { AddSessionComponent } from './pages/admin/session/add-session/add-session.component';
import { UpdateSessionComponent } from './pages/admin/session/update-session/update-session.component';
import { ExpositionListComponent } from './pages/admin/exposition/exposition-list/exposition-list.component';
import { AddExpositionComponent } from './pages/admin/exposition/add-exposition/add-exposition.component';
import { UpdateExpositionComponent } from './pages/admin/exposition/update-exposition/update-exposition.component';
import { OeuvreDetailComponent } from './pages/admin/oeuvre/oeuvre-detail/oeuvre-detail.component';
import { ExpositionDetailComponent } from './pages/admin/exposition/exposition-detail/exposition-detail.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';


import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SigninComponent,
    DashboardComponent,
    SidebarComponent,
    ProfileComponent,
    HomeComponent,
    OeuvreListComponent,
    AddOeuvreComponent,
    UpdateOeuvreComponent,
    SessionListComponent,
    AddSessionComponent,
    UpdateSessionComponent,
    ExpositionListComponent,
    AddExpositionComponent,
    UpdateExpositionComponent,
    OeuvreDetailComponent,
    ExpositionDetailComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    MatToolbarModule,
    MatListModule,
    MatTableModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
