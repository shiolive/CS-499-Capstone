package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Task.Task;
class TaskTest {
	//test if task ID allowed through to be over 10 chars
	@Test
	void testTaskID10Chars() {
		Task task = new Task("Name", "Description", "1");
		task.setTaskID("1234567890123");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}
	//test to ensure task id shortened to 10 chars through data validation steps
	@Test
	void testTaskID() {
		Task task = new Task("Name", "Description", "1");
		task.setTaskID("1234567890123");
		if (task.getTaskID().length() <= 10) {
			System.out.println("Task ID shortened");
			return;
		}
	}
	//test if task name allowed through to be over 20 chars
	@Test
	void testTaskName20Chars() {
		Task task = new Task("123", "Description", "2");
		task.setTaskName("NameIsTooLongAndStuff123");
		if (task.getTaskName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}
	//test to ensure task name shortened to 20 chars through data validation steps
	@Test
	void testTaskName() {
		Task task = new Task("123", "Description", "2");
		task.setTaskName("NameIsTooLongAndStuff123");
		if (task.getTaskName().length() <= 20) {
			System.out.println("Task Name shortened");
			return;
		}
	}
	//test if task description allowed through to be over 50 chars
	@Test
	void testTaskDescription50Chars() {
		Task task = new Task("Name", "123", "3");
		task.setTaskDescription("Description is too long Description is too long Description is too long");
		if (task.getTaskDescription().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}
	//test to ensure task description shortened to 50 chars through data validation steps
	@Test
	void testTaskDescription() {
		Task task = new Task("Name", "123", "3");
		task.setTaskDescription("Description is too long Description is too long Description is too long");
		if (task.getTaskDescription().length() <= 50) {
			System.out.println("Task Description shortened");
			return;
		}
	}
	//test task name being null is not allowed through data validation
	@Test
	void testTaskNameNotNull() {
		Task task = new Task(null, "Description", "4");
		task.setTaskName(null);
		assertNotNull(task.getTaskName(), "Task Name null");
	}
	
	//test task description being null is not allowed through data validation
	@Test
	void testTaskDescriptionNotNull() {
		Task task = new Task("Name", null, "5");
		task.setTaskDescription(null);
		assertNotNull(task.getTaskDescription(), "Task Description null");
	}
	//test task ID being null is not allowed through data validation
	@Test
	void testTaskIDNotNull() {
		Task task = new Task("Name", "Description", "");
		task.setTaskID(null);
		assertNotNull(task.getTaskID(), "Task ID Null");
	}
	//test set task ID for success
	@Test
	void testTaskIDSet() {
		Task task = new Task("Name", "Description", "");
		task.setTaskID("455");
		assertEquals("455", task.getTaskID(), "Task ID Null");
	}

}
