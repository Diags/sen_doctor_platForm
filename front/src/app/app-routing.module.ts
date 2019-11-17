import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";

const routes: Routes = [

  {
    path: 'home', component: AppComponent
  },
  {
    path: 'home',
    loadChildren: './admin/admin.module#AdminModule'
  },
  {
    path: 'home',
    loadChildren: './user/user.module#UserModule'
  },
  {
    path: '**', redirectTo: '/home', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routingComponents = [AppComponent];
