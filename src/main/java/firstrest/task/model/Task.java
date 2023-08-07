package firstrest.task.model;

import firstrest.shared.dto.TaskDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Task extends PanacheEntity {

    public String description;
    public Boolean done;

    public Task() {
        done = false;
    }

    public Task(String description, Boolean done) {
        this.description = description;
        this.done = done;
    }

    public Task(long id, String description, Boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public static Task fromTaskDTO(TaskDTO taskDTO) {
        return new Task(
            taskDTO.getDescription(),
            taskDTO.isDone()
        );
    }
}
