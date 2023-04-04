package catoptric;

import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Singleton
public class TaskExecutor {
    private final DateTimeFormatter dtf;
    private final FeedbackClient fc;

    public TaskExecutor(FeedbackClient f) {
        fc = f;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
    public void executeTask(Task t) {
        int n = t.getSubtasks().size();
        for (int i = 0; i < n; i++) {
            int finalDelay = t.getSubtasks().get(i);
            int finalI = i;
            Runnable r = () -> {
                try {
                    LocalDateTime now = LocalDateTime.now();
                    Thread.sleep(finalDelay * 1000L);
                    System.out.print("Finished subtask " + finalI + " @ " + now.format(dtf));
                    if (finalI == n - 1) {
                        System.out.println(" finished all");
                    } else {
                        System.out.println(" continuing ...");
                    }
                    fc.sendFeedBack("From Executor 1: " + "Finished subtask " + finalI + " @ " + now.format(dtf) + ";"
                            + (finalI == n-1 ? " All done!" : ""));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            new Thread(r).run();
        }

    }
}
