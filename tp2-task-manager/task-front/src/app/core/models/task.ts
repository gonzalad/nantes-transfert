export interface TaskData {
  id: string,
  name: string,
}

export class Task {
  private id: string;
  private name: string;

  constructor(data: TaskData) {
    this.id = data.id;
    this.name = data.name;
  }
}
