import { Component, OnDestroy, OnInit } from '@angular/core';
import { Task } from '@app/core/models/task';
import { TaskService } from '@app/shared/task/task.service';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit, OnDestroy {

  tasks: Task[] = [];
  private destroyed$ = new Subject<boolean>();
  displayedColumns: string[] = ['id', 'name'];

  constructor(private taskService: TaskService) {
    this.taskService.findAll().pipe(
      takeUntil(this.destroyed$),
    )
    .subscribe(tasks => this.tasks = tasks);
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.destroyed$.next(true);
    this.destroyed$.complete();
  }
}
