import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TaskListComponent} from "./task-list/task-list.component";
import {TaskItemEditComponent} from "./task-item-edit/task-item-edit.component";
import {TaskItemCreateComponent} from "./task-item-create/task-item-create.component";


const routes: Routes = [
  { path: 'list', component: TaskListComponent},
  { path: 'create', component: TaskItemCreateComponent},
  { path: 'edit/:id', component: TaskItemEditComponent},
  { path: '', redirectTo: '/list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
