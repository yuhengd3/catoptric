package catoptric;

import jakarta.inject.Singleton;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class TaskService {
    private final Map<Integer, Task> allowedTasks = new HashMap<>();
    private final MsgClient msgClient;

    public TaskService(MsgClient m) {
        msgClient = m;
    }

    @PostConstruct
    void init() {
        allowedTasks.put(1, new Task(1, Arrays.asList(3, 3, 3)));
        allowedTasks.put(2, new Task(2, Arrays.asList(7, 7, 7)));
    }

    public String executeTask(int id) {
        if (!allowedTasks.containsKey(id)) {
            return "task id " + id + " is not allowed";
        }

        Task t = allowedTasks.get(id);

        if (t.getId() == 1) {
            msgClient.sendTask1(t);
        } else if (t.getId() == 2) {
            msgClient.sendTask2(t);
        }

        return "send task: " + t;
    }

}
