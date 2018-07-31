package controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
		// given
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/showUser";

		// when
		ResponseEntity<UserTO> response = restTemplate.getForEntity(fooResourceUrl + "/2", UserTO.class);

		// then
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals("Joanna", response.getBody().getFirstName());
	}

	@Test(expected = NoSuchElementException.class)
	public void showUserTestWhenNotExist() {
		// given
		RestTemplate restTemplate = new RestTemplate();

		// when
		String fooResourceUrl = "http://localhost:8080/showUser";

		// when
		restTemplate.getForEntity(fooResourceUrl + "/5", UserTO.class);
	}

	@Test
	public void editUserTest() {
		// given
		RestTemplate restTemplate = new RestTemplate();
		String jsonString = "{\"userId\":1,\"firstName\":\"Joanna\",\"lastName\":\"Kowalski\",\"password\":\"hehe\",\"email\":\"joanna@gmail.com\",\"liveMotto\":\"Just nike\",\"userGamesList\":[]}";
		String fooResourceUrl = "http://localhost:8080/showUser";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// when
		HttpEntity<String> request = new HttpEntity<>(jsonString, headers);
		restTemplate.put("http://localhost:8080/editUser", request);
		ResponseEntity<UserTO> response = restTemplate.getForEntity(fooResourceUrl + "/1", UserTO.class);

		// then
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals("Joanna", response.getBody().getFirstName());
		assertEquals("Kowalski", response.getBody().getLastName());
	}

	@Test
	public void deleteUserTestWhenExist() {
		// given
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/deleteUser/{id}";
		String fooResourceUrlShowUser = "http://localhost:8080/showUser";
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "2");

		// when
		restTemplate.delete(fooResourceUrl, params);
		ResponseEntity<UserTO> response = restTemplate.getForEntity(fooResourceUrlShowUser + "/2", UserTO.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals("Deleted User", response.getHeaders());
	}

	@Test
	public void findUserTest() {
		// given
		RestTemplate restTemplate = new RestTemplate();
		String jsonString = "{\"lastName\":\"Sadalla\"}";
		String fooResourceUrl = "http://localhost:8080/findUser";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// when
		HttpEntity<String> request = new HttpEntity<>(jsonString, headers);
		ResponseEntity<UserTO> response = restTemplate.postForEntity(fooResourceUrl, request, UserTO.class);

		// then
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

}
