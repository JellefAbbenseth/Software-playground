class Tasks:
    def __init__(self):
        self.tasks = {
            1: {},
            2: {},
            3: {},
        }
        self.task = []
        self.priority = 1

    def add_task(self, task_name, estimated_time, buffer_time, priority=3):
        self.tasks[priority][task_name] = [False, estimated_time + buffer_time, estimated_time, buffer_time]

    def set_task_done(self):
        if len(self.task) > 0:
            self.tasks[self.priority][self.task[0]][0] = True
            self.task = []
        self.set_next_task()

    def set_next_task(self):
        if len(self.task) == 0:
            retry = True
            while retry:
                time_needed = 0
                if len(self.tasks[self.priority]) > 0:
                    priority_task = self.tasks[self.priority]
                    for key in priority_task:
                        if priority_task[key][0] is False and priority_task[key][1] > time_needed:
                            time_needed = priority_task[key][1]
                            task_name = key
                if time_needed != 0:
                    retry = False
                    self.task = [task_name, time_needed]
                else:
                    self.priority += 1

    def get_next_task(self):
        if len(self.task) == 0:
            self.set_task_done()
        return self.task
