
package Task;
import java.util.ArrayList;

public class TaskService {

	public ArrayList<Task> taskList = new ArrayList<Task>();
	
	public void addTask(String taskName, String taskDescription) {
		Task task = new Task(taskName, taskDescription);
		taskList.add(task);
	}
	public void deleteTask(String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().equals(taskID)) {
				taskList.remove(counter);
				break;
			}
			
		}
	}
	public void updateTask(String updatedName, String updatedDescription, String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().equals(taskID)) {
				taskList.get(counter).setTaskName(updatedName);
				taskList.get(counter).setTaskDescription(updatedDescription);
				break;
			}
		}
	}
	
	public Task getTask(String taskID) {
		Task task = new Task(null, null);
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().contentEquals(taskID));
			task = taskList.get(counter);
		}
		return task;
	}
	
}
