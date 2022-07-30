from Tasks import Tasks

tasks = Tasks()

# task_name, estimated_time, buffer_time, priority=3
task_name = "test"
estimated_time = 20
buffer_time = 5
priority = 1

tasks.add_task(task_name, estimated_time, buffer_time, priority)
tasks.add_task("test2", estimated_time, buffer_time)

print(tasks.get_next_task())
tasks.set_task_done()
print(tasks.get_next_task())
