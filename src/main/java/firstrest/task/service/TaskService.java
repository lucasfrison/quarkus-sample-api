package firstrest.task.service;

import firstrest.shared.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> list();

    TaskDTO findById(long id);

    void save(TaskDTO taskDTO);

    TaskDTO findByDescription(String description);

    void update(TaskDTO taskDTO);

    void remove(long id);
}
