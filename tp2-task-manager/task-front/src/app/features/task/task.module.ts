import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';

import { TaskRoutingModule } from './task-routing.module';
import { TaskListComponent } from './task-list/task-list.component';


@NgModule({
  declarations: [
    TaskListComponent
  ],
  imports: [
    MatTableModule,
    CommonModule,

    TaskRoutingModule,
  ],
  exports: [
    TaskListComponent
  ]
})
export class TaskModule { }
