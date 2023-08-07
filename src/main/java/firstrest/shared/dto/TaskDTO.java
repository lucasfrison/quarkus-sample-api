package firstrest.shared.dto;

import firstrest.task.model.Task;

public class TaskDTO {

    private long id;
    private String description;
    private Boolean done;

    public TaskDTO(String description, Boolean done) {
        this.description = description;
        this.done = done;
    }

    public TaskDTO(long id, String description, Boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }
    public TaskDTO() {
        done = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public static TaskDTO fromTask(Task task) {
        return new TaskDTO(
            task.id,
            task.description,
            task.done
        );
    }

}
