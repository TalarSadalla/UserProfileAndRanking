package repositoryImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import model.Availability;
import repositoryImpl.AvailabilityRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvailabilityRepositoryImplTest {

	@Test
	public void initializeDataTest() {
		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList1;
		List<Availability> userAvailabilityList2;
		List<Availability> userAvailabilityList3;
		List<Availability> userAvailabilityList4;

		// when
		availabilityRepositoryImpl.initialize();
		userAvailabilityList1 = availabilityRepositoryImpl.getUserAvailabilities(1);
		userAvailabilityList2 = availabilityRepositoryImpl.getUserAvailabilities(2);
		userAvailabilityList3 = availabilityRepositoryImpl.getUserAvailabilities(3);
		userAvailabilityList4 = availabilityRepositoryImpl.getUserAvailabilities(4);

		// then
		assertEquals(3, userAvailabilityList1.size());
		assertEquals(1, userAvailabilityList2.size());
		assertEquals(3, userAvailabilityList3.size());
		assertEquals(1, userAvailabilityList4.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void initializeDataIndexOutOfBoundTest() {
		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList;

		// when
		availabilityRepositoryImpl.initialize();
		availabilityRepositoryImpl.getUserAvailabilities(-1);
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(10);

		// then
	}

	@Test
	public void addAvailabilityTest() {
		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList;

		// when
		availabilityRepositoryImpl.initialize();
		availabilityRepositoryImpl.addAvailibility(1, "14:30", "15:00");
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(1);

		// then
		assertEquals(4, userAvailabilityList.size());
		assertEquals("Availability [userId=" + 1 + ", beginHour=" + "14:30" + ", endHour=" + "15:00" + ", comment="
				+ null + "]", userAvailabilityList.get(3).toString());
	}

	@Test
	public void addAvailabilityByAvailabilityTest() {
		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList;

		// when
		availabilityRepositoryImpl.initialize();
		availabilityRepositoryImpl.addAvailibility(new Availability(3, "05:30", "09:00"));
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(3);

		// then
		assertEquals(4, userAvailabilityList.size());
		assertEquals("Availability [userId=" + 3 + ", beginHour=" + "05:30" + ", endHour=" + "09:00" + ", comment="
				+ null + "]", userAvailabilityList.get(3).toString());
	}

	@Test
	public void getUserAvailabilityTest() {
		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList;

		// when
		availabilityRepositoryImpl.initialize();
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(2);

		// then
		assertEquals(1, userAvailabilityList.size());
	}

	@Test
	public void editAvailabilityTest() {

		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList;
		Availability oldAvailability = new Availability(1, "16:00", "17:30");
		Availability newAvailability = new Availability(1, "16:15", "17:00");

		// when
		availabilityRepositoryImpl.initialize();
		availabilityRepositoryImpl.editAvailibility(1, oldAvailability, newAvailability);
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(1);

		// then
		assertEquals(3, userAvailabilityList.size());
		assertEquals("Availability [userId=" + 1 + ", beginHour=" + "16:15" + ", endHour=" + "17:00" + ", comment="
				+ null + "]", userAvailabilityList.get(2).toString());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void editAvailabilityIndexOutOfBoundTest() {

		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList;
		Availability oldAvailability = new Availability(1, "16:00", "17:30");
		Availability newAvailability = new Availability(1, "16:15", "17:00");

		// when
		availabilityRepositoryImpl.initialize();
		availabilityRepositoryImpl.editAvailibility(5, oldAvailability, newAvailability);
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(1);

	}

	@Test
	public void deleteAvailabilityTest() {

		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList = new ArrayList<>();
		Availability availability = new Availability(1, "16:00", "17:30");
		String reason = "I won't be available in this hours...Sorry";

		// when
		availabilityRepositoryImpl.initialize();
		Availability deletedAvailability = availabilityRepositoryImpl.deleteAvailibility(1, availability, reason);
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(1);

		// then
		assertEquals(2, userAvailabilityList.size());
		assertEquals("Availability [userId=" + 1 + ", beginHour=" + null + ", endHour=" + null + ", comment="
				+ "I won't be available in this hours...Sorry" + "]", deletedAvailability.toString());
	}

	@Test(expected = NoSuchElementException.class)
	public void deleteAvailabilityNoSuchElementTest() {

		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();
		List<Availability> userAvailabilityList = new ArrayList<>();
		Availability availability = new Availability(1, "10:00", "12:30");
		String reason = "I won't be available in this hours...Sorry";

		// when
		availabilityRepositoryImpl.initialize();
		Availability deletedAvailability = availabilityRepositoryImpl.deleteAvailibility(1, availability, reason);
		userAvailabilityList = availabilityRepositoryImpl.getUserAvailabilities(1);
	}

	@Test
	public void getAllUsersAvailabilitiesTest() {

		// given
		AvailabilityRepositoryImpl availabilityRepositoryImpl = new AvailabilityRepositoryImpl();

		// when
		availabilityRepositoryImpl.initialize();
		Map<Long, List<Availability>> getAllAvailabilities = availabilityRepositoryImpl.getAllAvailabilities();

		// then
		assertEquals(4, getAllAvailabilities.size());
	}

}
