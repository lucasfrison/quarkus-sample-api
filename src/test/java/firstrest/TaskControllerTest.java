package firstrest;

import firstrest.shared.dto.TaskDTO;
import firstrest.task.controller.TaskControllerImpl;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(TaskControllerImpl.class)
public class TaskControllerTest {

    @Test
    public void testGetTaskByIdRequest() {
        String expectedResponse =
                "{\"id\":100,\"description\":\"tarefa de teste\",\"done\":false}";

        given().when()
                .pathParam("id", 100)
                .get("/{id}")
                .then()
                .statusCode(HttpResponseStatus.OK.code())
                .body(is(expectedResponse));
    }

    @Test
    public void testSaveTaskRequest() {

        TaskDTO requestBody = new TaskDTO("post", false);
        String expectedResponse =
                "{\"id\":1,\"description\":\"post\",\"done\":false}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(HttpResponseStatus.OK.code())
                .body(is(expectedResponse));
    }

    @Test
    public void testUpdateTaskRequest() {
        TaskDTO requestBody = new TaskDTO(200,"put", false);
        String expectedResponse =
                "{\"id\":200,\"description\":\"put\",\"done\":false}";

        given().contentType("application/json")
                .body(requestBody)
                .when()
                .put()
                .then()
                .statusCode(HttpResponseStatus.OK.code())
                .body(is(expectedResponse));
    }

    @Test
    public void testRemoveTaskRequest() {
        String expectedResponse =
                "{\"id\":300,\"description\":\"delete\",\"done\":false}";

        given().when()
                .pathParam("id", 300)
                .delete("/{id}")
                .then()
                .statusCode(HttpResponseStatus.OK.code())
                .body(is(expectedResponse));
    }


}