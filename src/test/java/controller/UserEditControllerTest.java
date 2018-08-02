package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.userProfileAndRanking.UserProfileAndRankingApplication;
import com.example.userProfileAndRanking.dto.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserProfileAndRankingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserEditControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void showUserTestWhenExist() {
		HttpEntity<UserTO> entity = new HttpEntity<UserTO>(null, headers);
		ResponseEntity<UserTO> response = restTemplate.exchange(createURLWithPort("/showUser/2"), HttpMethod.GET,
				entity, UserTO.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Joanna", response.getBody().getFirstName());
	}

	@Test
	public void editUserTest() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		String requestJson = "{\"userId\":2,\"firstName\":\"Joanna\",\"lastName\":\"Sadalla\",\"password\":\"test\",\"email\":\"joanna@gmail.com\",\"liveMotto\":\"Just adidas\",\"userGamesList\":[]}";
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/editUser"), HttpMethod.PUT, entity,
				String.class);
		assertTrue(response != null);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void deleteUserTestWhenExist() {
		UserTO userTO = new UserTO("Jan", "Kowalski", "1234", "jan@wp.pl", "I'm lovin it");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserTO> entity = new HttpEntity<UserTO>(userTO, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/deleteUser/1"), HttpMethod.DELETE,
				entity, String.class);
		assertTrue(response != null);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}