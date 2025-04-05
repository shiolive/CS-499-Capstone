
package Task;
import java.util.ArrayList;

public class TaskService {

	public ArrayList<Task> taskList = new ArrayList<Task>();
	//add new task
	public void addTask(String taskName, String taskDescription, String taskID) {
		Task task = new Task(taskName, taskDescription, taskID);
		taskList.add(task);
	}
	
	//date task by task id
	public void deleteTask(String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID() == taskID) {
				taskList.remove(counter);
				break;
			}
			
		}
	}
	//update task
	public void updateTask(String updatedName, String updatedDescription, String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID() == taskID) {
				taskList.get(counter).setTaskName(updatedName);
				taskList.get(counter).setTaskDescription(updatedDescription);
				break;
			}
		}
	}
	//return task info
	public Task getTask(String taskID) {
		Task task = new Task(null, null, taskID);
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().contentEquals(taskID));
			task = taskList.get(counter);
		}
		return task;
	}
	
}
