package firstrest.task.controller;

import firstrest.shared.dto.TaskDTO;
import firstrest.task.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class TaskControllerImpl implements TaskController {

    @Inject
    TaskService taskServiceImpl;

    public List<TaskDTO> list() {
        return taskServiceImpl.list();
    }

    public TaskDTO getById(long id) {
        return taskServiceImpl.findById(id);
    }

    public TaskDTO save(TaskDTO taskDTO) {
        taskServiceImpl.save(taskDTO);
        return taskServiceImpl.findByDescription(taskDTO.getDescription());
    }

    public TaskDTO update(TaskDTO taskDTO) {
        taskServiceImpl.update(taskDTO);
        return taskServiceImpl.findById(taskDTO.getId());
    }

    public TaskDTO remove(long id) {
        TaskDTO response = taskServiceImpl.findById(id);
        taskServiceImpl.remove(id);
        return response;
    }
}
