import java.util.Collection;

import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	ToDoList list;
	Task a;
	Task b;
	Task c;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		this.list = new ToDoList();
		this.a = new Task("task 1",false);
		this.b = new Task("task 2",false);
		this.c = new Task("task 3",false);
	}
	@After
	 public void tearDown() throws Exception{
		this.list = null;
		this.a = null;
		this.b = null;
		this.c = null;
	}

	@Test
	public void testAddTask() {
		Assert.assertNotNull(this.list);
		this.list.addTask(this.a);
		Assert.assertEquals(1, this.list.getAllTasks().size());
		Assert.assertEquals(a, this.list.getTask(a.getDescription()));
	}
	
	@Test
	public void testgetStatus() {
		Assert.assertNotNull(this.list);
		this.list.addTask(this.a);
		Assert.assertEquals(false, list.getStatus(a.getDescription()));
		list.completeTask(a.getDescription());
		Assert.assertEquals(true, list.getStatus(a.getDescription()));
	}
	
	@Test
	public void testRemoveTask() {
		Assert.assertNotNull(this.list);
		this.list.addTask(this.a);
		this.list.addTask(this.b);
		this.list.removeTask(a.getDescription());
		Assert.assertNull(this.list.getTask(a.getDescription()));
	}
	
	@Test
	public void testGetCompletedTasks() {
		Assert.assertNotNull(this.list);
		a.setComplete(true);
		c.setComplete(true);
		list.addTask(a);
		list.addTask(b);
		list.addTask(c);
		
		Assert.assertEquals(2, list.getCompletedTasks().size());
	}
}