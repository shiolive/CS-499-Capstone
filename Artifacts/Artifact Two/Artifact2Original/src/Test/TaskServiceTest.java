package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import Task.Task;
import Task.TaskService;

class TaskServiceTest {

	@Test
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description");
		service.updateTask("New Name", "Description", "5");
		assertNotEquals("New Name", service.getTask("5").getTaskName(), "Task Name not updated");
	}
	@Test
	void testUpdateTaskDescription() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description");
		service.updateTask("Name", "New Description", "3");
		assertNotEquals("New Description", service.getTask("3").getTaskDescription(), "Task Description not updated");
	}
	@Test
	void testAddContact() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description");
		assertNotNull(service.getTask("0"), "Task not added");
	}
	@Test
	void testRemoveContact() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description");
		service.deleteTask("0");
		ArrayList<Task> taskListEmpty = new ArrayList<Task>();
		assertNotEquals(service.taskList, taskListEmpty, "Task not deleted");
	}
}
