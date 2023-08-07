package firstrest.task.service;

import firstrest.shared.transaction.TransactionLogger;
import firstrest.task.model.Task;
import firstrest.shared.dto.TaskDTO;
import firstrest.shared.transaction.TransactionIdentifier;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
public final class TaskServiceImpl implements TaskService {

    @Inject
    TransactionIdentifier transactionId;
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskDTO> list() {
        TransactionLogger.log(transactionId);
        //System.out.println(transactionId.getIdentifier());
        List<Task> allTasks = Task.listAll();
        return allTasks.stream()
                .map(TaskDTO::fromTask)
                .toList();
    }

    @Transactional
    public void save(TaskDTO taskDTO) {
        Task task = Task.fromTaskDTO(taskDTO);
        task.persist();
    }

    @Transactional
    public void remove(long id) {
        TaskDTO dto = findById(id);
        Task task = new Task(
            dto.getId(),
            dto.getDescription(),
            dto.isDone()
        );
        task.delete();
    }

    @Transactional
    public void update(TaskDTO taskDTO) {
        Task task = Task.findById(taskDTO.getId());
        task.description = taskDTO.getDescription();
        task.done = taskDTO.isDone();
        task.persist();
    }

    public TaskDTO findById(long id) {
        Task task = Task.findById(id);
        return TaskDTO.fromTask(task);
    }

    public TaskDTO findByDescription(String description) {
        Task task = Task.find("description", description).firstResult();
        return TaskDTO.fromTask(task);
    }


}
