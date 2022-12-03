import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAbstractComponent } from './edit-abstract/edit-abstract.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  { path: 'register', component:RegisterComponent },
  { path: 'login', component:LoginComponent },
  {path: '', component: LoginComponent},
  { path: 'editAbstract', component:EditAbstractComponent },
  {path: 'logout', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
