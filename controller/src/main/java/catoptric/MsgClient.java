package catoptric;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import reactor.core.publisher.Mono;

@KafkaClient
public interface MsgClient {
    @Topic("task1")
    void sendTask1(Task task);

    @Topic("task2")
    void sendTask2(Task task);

    @Topic("move1")
    void sendMoveRequest1(MoveRequest request);
}