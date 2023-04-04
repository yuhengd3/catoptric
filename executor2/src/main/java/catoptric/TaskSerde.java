package catoptric;

import io.micronaut.core.type.Argument;
import io.micronaut.serde.Decoder;
import io.micronaut.serde.Encoder;
import io.micronaut.serde.Serde;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TaskSerde implements Serde<Task> {

    @Override
    public Task deserialize(Decoder decoder, DecoderContext context, Argument<? super Task> type) throws IOException {
        int id = decoder.decodeInt();
        List<Integer> subtasks = new ArrayList<>();
        Decoder arrDecoder =  decoder.decodeArray();
        while (arrDecoder.hasNextArrayValue()) {
            subtasks.add(arrDecoder.decodeInt());
        }
        return new Task(id, subtasks);
    }

    @Override
    public void serialize(Encoder encoder, EncoderContext context, Argument<? extends Task> type, Task value) throws IOException {
        encoder.encodeInt(value.getId());
        Encoder arrEncoder = encoder.encodeArray(type);
        for (int i : value.getSubtasks()) {
            arrEncoder.encodeInt(i);
        }
    }
}
