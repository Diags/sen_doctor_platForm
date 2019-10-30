import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { LoginUserComponent } from './login-user/login-user.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { ProfilUserComponent } from './profil-user/profil-user.component';
import {UserComponent} from "./user.component";
import { ProfesionnalsComponent } from '../profesionnals/profesionnals.component';
import { ProfesionnalDetailsComponent } from '../profesionnal-details/profesionnal-details.component';


@NgModule({
  declarations: [
    LoginUserComponent,
    RegisterUserComponent,
    ProfilUserComponent,
    UserComponent,
    ProfesionnalsComponent,
    ProfesionnalDetailsComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
  ]
})
export class UserModule { }
