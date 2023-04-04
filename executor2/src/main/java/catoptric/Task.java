package catoptric;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Creator;
import io.micronaut.serde.annotation.Serdeable;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private int id;
    private List<Integer> subtasks;

    public Task(int i, List<Integer> list) {
        id = i;
        subtasks = new ArrayList<>(list);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Integer> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", subtasks=" + subtasks +
                '}';
    }
}
