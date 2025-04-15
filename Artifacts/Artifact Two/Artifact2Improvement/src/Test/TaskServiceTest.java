package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import Task.Task;
import Task.TaskService;

class TaskServiceTest {

	
	//test update task name for failure
	@Test
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description", "5");
		service.updateTask("New Name", "Description", "5");
		assertNotEquals("Name", service.getTask("5").getTaskName(), "Task Name not updated");
	}
	//test update task name for success
	@Test
	void testUpdateName() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description", "6");
		service.updateTask("New Name", "Description", "6");
		assertEquals("New Name", service.getTask("6").getTaskName(), "Task Name updated");
	}
	//test update task description for failure
	@Test
	void testUpdateTaskDescription() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description", "5");
		service.updateTask("Name", "New Description", "5");
		assertNotEquals("Description", service.getTask("5").getTaskDescription(), "Task Description not updated");
	}
	//test update task description for success
	@Test
	void testUpdateDescription() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description", "5");
		service.updateTask("Name", "New Description", "5");
		assertEquals("New Description", service.getTask("5").getTaskDescription(), "Task Description updated");
	}
	//test adding task by checking task ID not null
	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description", "8");
		assertNotNull(service.getTask("8"), "Task added");
	}
	//test deleting a task by adding a task and then deleting it and checking against empty array list
	@Test
	void testRemoveTask() {
		TaskService service = new TaskService();
		service.addTask("Name", "Description", "0");
		service.deleteTask("0");
		ArrayList<Task> taskListEmpty = new ArrayList<Task>();
		assertEquals(service.taskList, taskListEmpty, "Task not deleted");
	}
}
