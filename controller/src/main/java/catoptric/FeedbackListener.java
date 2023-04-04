package catoptric;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener
public class FeedbackListener {
    @Topic("Feedback")
    public void showFeedback(String fb) {
        System.out.println(fb);
    }
}
