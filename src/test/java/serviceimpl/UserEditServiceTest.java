package serviceimpl;

import static org.junit.Assert.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.example.userProfileAndRanking.dto.UserTO;
import com.example.userProfileAndRanking.repository.UserRepositoryImpl;
import com.example.userProfileAndRanking.service.UserEditServiceImpl;

public class UserEditServiceTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public UserEditServiceImpl userEditServiceImpl() {
			return new UserEditServiceImpl();
		}
	}

	@Autowired
	private UserEditServiceImpl userEditServiceImpl;

	@MockBean
	private UserRepositoryImpl userRepositoryImpl;

	@Autowired
	private ModelMapper modelMapper;

	@Before(value = "")
	public void setUp() {
		UserTO userTO = new UserTO("Marcin", "Augustyn", "1234", "1234@wp.pl", "GOGOGO");

		// Mockito.when(userRepositoryImpl.findByName(alex.getName())).thenReturn(alex);

		Mockito.when(userRepositoryImpl.findUserByLastName(userTO.getLastName())).then((Answer<?>) userTO);
	}

	@Test
	public void editUserTest() {
		UserTO userTO = new UserTO("Marcin", "Augustyn", "1234", "1234@wp.pl", "GOGOGO");
		userRepositoryImpl.initialize();
		userEditServiceImpl.editUser(2, userTO);

		UserTO found = userEditServiceImpl.showUser(1);

		assertEquals("Augustyn", found.getLastName());
	}

	@Test
	public void showUserTest() {
		userRepositoryImpl.initialize();

		UserTO found = userEditServiceImpl.showUser(1);

		assertEquals("Sadalla", found.getLastName());
	}
}
