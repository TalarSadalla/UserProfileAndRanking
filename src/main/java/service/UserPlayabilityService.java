package service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Availability;
import model.User;
import repositoryInterface.AvailabilityRepository;
import repositoryInterface.ChallengeRepository;
import repositoryInterface.UserRepository;

@Service
public class UserPlayabilityService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AvailabilityRepository availabilityRepository;

	@Autowired
	ChallengeRepository challengeRepository;

	public void addUserAvailabilityHours(Long userId, String beginHour, String endHour) {
		availabilityRepository.addAvailibility(userId, beginHour, endHour);

	}

	public void editUserAvailabilityHours(Long userId, Availability oldAvailability, Availability newAvailability) {
		availabilityRepository.editAvailibility(userId, oldAvailability, newAvailability);
	}

	public void deleteUserAvailabilityHours(long userId, Availability availabilityToDelete, String reason) {
		availabilityRepository.deleteAvailibility(userId, availabilityToDelete, reason);
	}

	public List<User> listOfAvailableUsersInSimilarAvailableHours(long userId,
			List<Availability> userAvailabilityList) {
		List<User> userList = userRepository.findAllUsers();
		Map<Long, List<Availability>> availabilityMap = availabilityRepository.getAllAvailabilities();

		for (Map.Entry<Long, List<Availability>> entry : availabilityMap.entrySet()) {
			if (entry.getKey() != userId) {
				for (int i = 0; i < entry.getValue().size(); i++) {
					LocalTime t = LocalTime.parse("17:40");

				}
			}
		}
		return null;

	}

}
