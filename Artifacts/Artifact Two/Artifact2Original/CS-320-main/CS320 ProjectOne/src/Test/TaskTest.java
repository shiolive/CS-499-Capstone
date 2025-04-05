package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Task.Task;
class TaskTest {

	@Test
	void testTaskID10Chars() {
		Task task = new Task("Name", "Description");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}
	
	@Test
	void testTaskName20Chars() {
		Task task = new Task("NameIsTooLongAndStuff123", "Description");
		if (task.getTaskName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}
	
	@Test
	void testTaskDescription50Chars() {
		Task task = new Task("Name", "Description is too long Description is too long Description is too long");
		if (task.getTaskDescription().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}
	
	@Test
	void testTaskNameNotNull() {
		Task task = new Task(null, "Description");
		assertNotNull(task.getTaskName(), "Task Name null");
	}
	
	@Test
	void testTaskDescriptionNotNull() {
		Task task = new Task("Name", null);
		assertNotNull(task.getTaskDescription(), "Task Description null");
	}
	
	

}
