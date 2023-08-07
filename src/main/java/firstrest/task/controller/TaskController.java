package firstrest.task.controller;

import firstrest.shared.dto.TaskDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TaskController {

    @GET
    public List<TaskDTO> list();
    @GET
    @Path("{id}")
    public TaskDTO getById(@PathParam("id") long id);
    @POST
    public TaskDTO save(TaskDTO taskDTO);
    @PUT
    public TaskDTO update(TaskDTO taskDTO);
    @DELETE
    @Path("{id}")
    public TaskDTO remove(@PathParam("id") long id);

}
