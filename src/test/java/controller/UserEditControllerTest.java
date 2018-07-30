package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.userProfileAndRanking.UserProfileAndRankingApplication;
import com.example.userProfileAndRanking.dto.UserTO;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = { UserProfileAndRankingApplication.class })
public class UserEditControllerTest {

	@Test
	public void showUserTestWhenExist() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/showUser";
		ResponseEntity<UserTO> response = restTemplate.getForEntity(fooResourceUrl + "/2", UserTO.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals("Joanna", response.getBody().getFirstName());
	}

	@Test(expected = NoSuchElementException.class)
	public void showUserTestWhenNotExist() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/showUser";
		restTemplate.getForEntity(fooResourceUrl + "/5", UserTO.class);
	}

	@Test
	public void editUserTest() {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<UserTO> request = new HttpEntity<>(
				new UserTO("Jan", "Kowalski", "1234", "jan@wp.pl", "I'm lovin it"));
		UserTO userTo = restTemplate.postForObject("http://localhost:8080/editUser", request, UserTO.class);
		assertTrue(userTo != null);
		assertEquals("Kowalski", userTo.getLastName());
	}

	@Test
	public void deleteUserTestWhenExist() {
		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrl = "http://localhost:8080/deleteUser";
		restTemplate.delete(fooResourceUrl, "/2");
		ResponseEntity<UserTO> response = restTemplate.getForEntity(fooResourceUrl + "/2", UserTO.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals("Deleted User", response.getHeaders());
	}

}
