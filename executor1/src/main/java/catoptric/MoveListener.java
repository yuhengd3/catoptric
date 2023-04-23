package catoptric;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;

@Requires(notEnv = Environment.TEST)
@KafkaListener
public class MoveListener {
    public MoveListener() {
        System.out.println("moveListener initialized");
    }

    @Topic("move1")
    public void move(MoveRequest moveRequest) {
        System.out.println("received move: " + moveRequest);
    }
}
