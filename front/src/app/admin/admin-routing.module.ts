import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminHomeComponent} from "./admin-home/admin-home.component";
import {AdminLoginComponent} from "./admin-login/admin-login.component";
import {AdminRegisterComponent} from "./admin-register/admin-register.component";
import {AdminComponent} from "./admin.component";


const routes: Routes = [

  {
    path:'professional', component:AdminComponent,
    children:[
      {
        path:'loginprofessional', component:AdminLoginComponent
      },
      {
        path:'registerprofessional', component:AdminRegisterComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
