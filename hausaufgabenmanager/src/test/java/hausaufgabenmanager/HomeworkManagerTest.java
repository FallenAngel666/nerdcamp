package hausaufgabenmanager;

import org.junit.Assert;
import org.junit.Test;

import com.flowfact.hausaufgabenmanager.AuthenticationService;
import com.flowfact.hausaufgabenmanager.HomeworkManager;
import com.flowfact.hausaufgabenmanager.UserRepository;

public class HomeworkManagerTest {
	
	@Test
	public void shouldCreateThreeDummyEntries() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager(service);
		manager.createDummyTasks();
		Assert.assertEquals(3,manager.readAll().size());
	}
	
	@Test
	public void shouldGetAllDone() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager(service);
		manager.createDummyTasks();
		Assert.assertEquals(1,manager.read(true).size());
	}
	
	@Test
	public void shouldGetAllUndone() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager(service);
		manager.createDummyTasks();
		Assert.assertEquals(2,manager.read(false).size());
	}
	
	@Test
	public void shouldGetAllUser1() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager(service);
		manager.createDummyTasks();
		Assert.assertEquals(2,manager.read("test1").size());
	}
	
	@Test
	public void shouldGetAllUser1Done() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager(service);
		manager.createDummyTasks();
		Assert.assertEquals(1,manager.read("test1",true).size());
	}
}
