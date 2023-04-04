package catoptric;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;

@Requires(notEnv = Environment.TEST)
@KafkaListener
public class TaskListener {
    private TaskExecutor taskExecutor;

    public TaskListener(TaskExecutor e) {
        taskExecutor = e;
    }

    @Topic("task1")
    public void executeTask(Task t) {
        System.out.println("Received task: " + t);
        taskExecutor.executeTask(t);
    }
}

