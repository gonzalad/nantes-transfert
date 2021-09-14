import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
      path: '',
      redirectTo: '/task',
      pathMatch: 'full'
  },
  {
      path: 'task',
      loadChildren: () => import('@app/features/task/task.module').then(m => m.TaskModule)
  },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
