package catoptric;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface FeedbackClient {
    @Topic("Feedback")
    void sendFeedBack(String feedback);
}
