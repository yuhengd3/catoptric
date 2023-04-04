package catoptric;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService s) {
        taskService = s;
    }

    @Get("/{id}")
    String executeTask(int id) {

        return taskService.executeTask(id);
    }
}
