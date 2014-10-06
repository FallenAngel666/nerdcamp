package hausaufgabenmanager;

import java.util.Date;

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
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		Assert.assertEquals(3,manager.readAll().size());
	}
	
	@Test
	public void shouldGetAllDone() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		Assert.assertEquals(1,manager.read(true).size());
	}
	
	@Test
	public void shouldGetAllUndone() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		Assert.assertEquals(2,manager.read(false).size());
	}
	
	@Test
	public void shouldGetAllUser1() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		Assert.assertEquals(2,manager.read("test1").size());
	}
	
	@Test
	public void shouldGetAllUser1Done() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		Assert.assertEquals(1,manager.read("test1",true).size());
	}
	
	@Test
	public void shouldRemoveHomework() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		manager.remove(1);
		Assert.assertEquals(0,manager.read("test1",true).size());
	}
	
	@Test
	public void shouldRemoveHomeworkAll() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		manager.remove(1);
		Assert.assertEquals(2,manager.readAll().size());
	}
	
	@Test
	public void shouldRemove2HomeworkAll() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		manager.remove(1);
		manager.remove(1);
		Assert.assertEquals(1,manager.readAll().size());
	}
	@Test
	public void shouldaddHomework() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		manager.add("E", "Vokabeln", "S.370", new Date(), service.getUserRepository().getUser("test3"));
		
		Assert.assertEquals(4,manager.readAll().size());
	}
	
	@Test
	public void shouldsetHomework() {
		AuthenticationService service = new AuthenticationService();
		service.setUserRepository(new UserRepository());
		HomeworkManager manager = new HomeworkManager();
		manager.createDummyTasks(service);
		manager.set(0,"E", "Vokabeln", "S.370", new Date(), service.getUserRepository().getUser("test3"));
		manager.add("E", "Vokabeln", "S.370", new Date(), service.getUserRepository().getUser("test3"));
		
		Assert.assertEquals(4,manager.readAll().size());
		Assert.assertEquals(2,manager.read("test3").size());
	}
	
}
