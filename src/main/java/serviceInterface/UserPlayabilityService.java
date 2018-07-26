package serviceInterface;

import java.util.List;

import dto.AvailabilityTO;
import dto.UserTO;

public interface UserPlayabilityService {

	public void addUserAvailabilityHours(Long userId, String beginHour, String endHour);

	public void addUserAvailabilityHours(AvailabilityTO availabilityTO);

	public void editUserAvailabilityHours(Long userId, AvailabilityTO oldAvailabilityTO,
			AvailabilityTO newAvailabilityTO);

	public void deleteUserAvailabilityHours(long userId, AvailabilityTO availabilityToDeleteTO, String reason);

	public List<UserTO> listOfAvailableUsersInSimilarAvailableHours(long userId);

}
