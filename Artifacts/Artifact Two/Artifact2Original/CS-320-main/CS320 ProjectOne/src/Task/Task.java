package Task;
import java.util.concurrent.atomic.AtomicLong;

public class Task {

	private String taskID;
	private String taskName;
	private String taskDesc;
	private String taskDescription;
	private static AtomicLong idGenerator = new AtomicLong();
	
	public Task(String taskName, String taskDescription) {
		this.taskID = String.valueOf(idGenerator.getAndIncrement());
		
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		}
		else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0,20);
		}
		else {
			this.taskName = taskName;
		}
	
		if (taskDescription == null || taskDescription.isEmpty()) {
			this.taskDescription = "NULL";
		}
		else if (taskDescription.length() > 50) {
			this.taskDescription = taskDescription.substring(0,50);
		}
		else {
			this.taskDescription = taskDescription;
		}
	}
	//getters
	public String getTaskID() {
		return taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	//setters
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		}
		else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0,20);
		}
		else {
			this.taskName = taskName;
		}
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.isEmpty()) {
			this.taskDescription = "NULL";
		}
		else if (taskDescription.length() > 50) {
			this.taskDescription = taskDescription.substring(0,50);
		}
		else {
			this.taskDescription = taskDescription;
		}
	}
}

