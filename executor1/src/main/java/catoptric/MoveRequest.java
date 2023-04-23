package catoptric;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;


@Serdeable
public class MoveRequest {
    @JsonProperty("row")
    private int row;
    @JsonProperty("column")
    private int column;
    @JsonProperty("direction")
    private int direction;
    @JsonProperty("step")
    private int step;

    public MoveRequest() {
    }

    public MoveRequest(int row, int column, int direction, int step) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.step = step;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "MoveRequest{" +
                "row=" + row +
                ", column=" + column +
                ", direction=" + direction +
                ", step=" + step +
                '}';
    }
}
