 package Task;


public class Task {

	private String taskID;
	private String taskName;
	private String taskDescription;
	
	
	public Task(String taskName, String taskDescription, String taskID) {
		
		//data validation
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
		if (taskID == null || taskID.isEmpty()) {
			this.taskID = "NULL";
		}
		else if (taskID.length() > 10) {
			this.taskID = taskID.substring(0,10);
		}
		else {
			this.taskID = taskID;}
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
	public void setTaskID(String taskID) {
		if (taskID == null || taskID.isEmpty()) {
			this.taskID = "NULL";
		}
		else if (taskID.length() > 10) {
			this.taskID = taskID.substring(0,10);
		}
		else {
			this.taskID = taskID;}
	}
}

