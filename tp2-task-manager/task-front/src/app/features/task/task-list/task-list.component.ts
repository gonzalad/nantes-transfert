import { Component, OnDestroy, OnInit } from '@angular/core';
import { Task } from '@app/core/models/task';
import { TaskService } from '@app/shared/task/task.service';
import { Subject, Subscription } from 'rxjs';
import { map, takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit, OnDestroy {

  tasks: TaskDomain[] = [];
  private destroyed$ = new Subject<boolean>();
  displayedColumns: string[] = ['id', 'name'];

  constructor(private taskService: TaskService) {
  }

  ngOnInit(): void {
    this.taskService.findAll()
      .pipe(
        map(taches => taches.map(t => ({identifiant: t.id}))),
        takeUntil(this.destroyed$),
      )
    .subscribe(tasks => this.tasks = tasks);
  }

  ngOnDestroy(): void {
    this.destroyed$.next(true);
    this.destroyed$.complete();
  }
}

export interface TaskDomain {
  identifiant: string;
}
