package repositoryInterface;

import java.util.List;
import java.util.Map;

import model.Availability;

public interface AvailabilityRepository {

	void addAvailibility(long userId, String beginHour, String endHour);

	void editAvailibility(long userId, Availability oldAvailability, Availability newAvailability);

	void deleteAvailibility(long userId, Availability availabilityToDelete, String reason);

	Map<Long, List<Availability>> getAllAvailabilities();

	public List<Availability> getUserAvailabilities(long userId);
}
