import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginUserComponent} from "./login-user/login-user.component";
import {RegisterUserComponent} from "./register-user/register-user.component";
import {ProfilUserComponent} from "./profil-user/profil-user.component";
import {UserComponent} from "./user.component";


const routes: Routes = [
  {
    path: 'user', component:UserComponent,
    children:[
      {
        path:'loginuser', component:LoginUserComponent,
      },
      {
        path:'register',component:RegisterUserComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
