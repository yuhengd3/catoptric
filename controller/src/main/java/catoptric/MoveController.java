package catoptric;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/api/v1/move")
public class MoveController {
    private final MsgClient msgClient;

    public MoveController(MsgClient msgClient) {
        this.msgClient = msgClient;
    }

    @Post(produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> move(@Body MoveRequest moveRequest) {
        System.out.println("Received: " + moveRequest);
        msgClient.sendMoveRequest1(moveRequest);
        return HttpResponse.accepted();
    }
}
