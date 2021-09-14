import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Task } from 'src/app/core/models/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor() { }

  findAll(): Observable<Task[]> {
    return of([
        new Task({id: '1246x8', name: 'Tâche 1'}),
    ]);
  }
}
