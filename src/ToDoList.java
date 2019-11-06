import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();
	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	
	public void completeTask(String description) {
		if(tasks.containsKey(description)==true) {
			tasks.get(description).setComplete(true);
		}
	}
	
	public boolean getStatus(String description) {
		if(tasks.containsKey(description)) {
			return tasks.get(description).isComplete();
		}else {
			return false;
		}
	}
	
	public Task getTask(String description) {
		if(tasks.containsKey(description)==false)
			return null;
		else
			return tasks.get(description);	
	}
	
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	
	public Collection<Task> getCompletedTasks() {
		ArrayList<Task> a = new ArrayList<Task>();
		Collection<Task> b = new ArrayList<Task>();
		b = getAllTasks();
		for(Task task: b) {
			if(task.isComplete()) {
				a.add(task);
			}
		}
		return a;
	}
	public void editTaskStatus(String description) {
		if(tasks.containsKey(description)==true) {
			if(tasks.get(description).isComplete() == true) {
				tasks.get(description).setComplete(false);
			}
		}
	}
	
	public void editTask(String oldDesc , String newDesc) {
		if(getTask(oldDesc)!=null&&!getStatus(oldDesc)) {
			Task newTask = removeTask(oldDesc);
			newTask.setDescription(newDesc);
			addTask(newTask);
		}
	}
}
