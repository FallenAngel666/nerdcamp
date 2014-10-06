package hausaufgabenmanager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flowfact.hausaufgabenmanager.AuthenticationService;

public class AuthenticationServiceTest {

	private AuthenticationService authenticationService;

	@Before
	public void setUp() {
		authenticationService = new AuthenticationService();
	}

	@Test
	public void shouldReturnFalseIfUnknownUserAuthenticates() {
		Assert.assertFalse(authenticationService.authenticate("test", "testpass"));
	}
	
	@Test
	public void shouldReturnTrueIfKnownUserAuthenticates() {
		Assert.assertTrue(authenticationService.authenticate("test1", "testpass"));
	}

}