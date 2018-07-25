package repositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import model.Availability;
import repositoryInterface.AvailabilityRepository;

@Repository
public class AvailabilityRepositoryImpl implements AvailabilityRepository {

	List<Availability> availabilityListUser1;
	List<Availability> availabilityListUser2;
	List<Availability> availabilityListUser3;
	List<Availability> availabilityListUser4;
	Map<Long, List<Availability>> fullAvailabilityList;

	public void initialize() {
		availabilityListUser1.add(new Availability(1, "12:00", "13:30"));
		availabilityListUser1.add(new Availability(1, "14:00", "15:30"));
		availabilityListUser1.add(new Availability(1, "16:00", "17:30"));
		availabilityListUser2.add(new Availability(2, "13:30", "15:00"));
		availabilityListUser3.add(new Availability(3, "17:00", "20:30"));
		availabilityListUser3.add(new Availability(3, "10:00", "11:30"));
		availabilityListUser3.add(new Availability(3, "20:00", "20:30"));
		availabilityListUser4.add(new Availability(4, "08:00", "13:00"));
	}

	@Override
	public void addAvailibility(long userId, String beginHour, String endHour) {
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		Availability availability = null;
		availability.setBeginHour(beginHour);
		availability.setEndHour(endHour);
		availabilityList.add(availability);
		fullAvailabilityList.put(userId, availabilityList);
	}

	@Override
	public void addAvailibility(long userId, Availability availability) {
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		availabilityList.add(availability);
		fullAvailabilityList.put(userId, availabilityList);
	}

	@Override
	public void editAvailibility(long userId, Availability oldAvailability, Availability newAvailability) {
		if (userId < 0 || userId > fullAvailabilityList.size())
			throw new IndexOutOfBoundsException();
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		Availability foundAvailability = findAvailabilityByAvailability(availabilityList, oldAvailability);
		foundAvailability.setBeginHour(newAvailability.getBeginHour());
		foundAvailability.setEndHour(newAvailability.getEndHour());
	}

	private Availability findAvailabilityByAvailability(List<Availability> availabilityList,
			Availability oldAvailability) {
		for (int i = 0; i < availabilityList.size(); i++) {
			if (availabilityList.get(i).getBeginHour().equals(oldAvailability.getBeginHour())
					&& availabilityList.get(i).getEndHour().equals(oldAvailability.getEndHour())) {
				return availabilityList.get(i);
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public void deleteAvailibility(long userId, Availability availabilityToDelete, String reason) {
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		Availability foundAvailability = findAvailabilityByAvailability(availabilityList, availabilityToDelete);
		foundAvailability.setBeginHour("");
		foundAvailability.setEndHour("");
		foundAvailability.setComment(reason);

	}

	public Map<Long, List<Availability>> getAllAvailabilities() {
		return fullAvailabilityList;
	}

	public List<Availability> getUserAvailabilities(long userId) {
		return fullAvailabilityList.get(userId);
	}

}
