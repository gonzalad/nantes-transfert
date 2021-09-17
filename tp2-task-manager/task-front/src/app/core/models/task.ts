
export interface TaskData {
  id: string,
  name: string,
}

export class Task {
  id: string;
  name: string;

  constructor(data: TaskData) {
    this.id = data.id;
    this.name = data.name;
  }
}
