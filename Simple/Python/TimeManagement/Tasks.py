class Tasks:
    def __init__(self):
        self.tasks = {
            1: {},
            2: {},
            3: {},
        }
        self.task_list = []

    def add_task(self, task_name, estimated_time, buffer_time, priority=3):
        self.tasks[priority][task_name] = [False, estimated_time + buffer_time, estimated_time, buffer_time]

    def set_task_done(self, task_index):
        pass
