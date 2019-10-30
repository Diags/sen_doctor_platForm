import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { AdminSettingsComponent } from './admin-settings/admin-settings.component';
import {AdminComponent} from "./admin.component";


@NgModule({
  declarations: [
    AdminHomeComponent,
    AdminLoginComponent,
    AdminRegisterComponent,
    AdminSettingsComponent,
    AdminComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
