package useradminservice.dao;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import useradminservice.dto.User;
import useradminservice.util.IDGenerator;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IDGenerator.class)
public class UserDAOTest {

	@Test
	public void creteShouldReturnUserId() {
		UserDAO dao = new UserDAO();

		mockStatic(IDGenerator.class);
		when(IDGenerator.generateId()).thenReturn(1);

		User result = dao.create(new User());
		assertEquals(1, result.getId());

		verifyStatic();
	}

}
