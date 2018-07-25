package serviceImpl;

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
import serviceInterface.UserPlayabilityService;

@Service
public class UserPlayabilityServiceImpl implements UserPlayabilityService {

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

	public List<User> listOfAvailableUsersInSimilarAvailableHours(long userId) {
		List<User> userList = userRepository.findAllUsers();
		Map<Long, List<Availability>> availabilityMap = availabilityRepository.getAllAvailabilities();
		List<Availability> userAvailability = availabilityRepository.getUserAvailabilities(userId);
		for (Availability availability : userAvailability) {
			LocalTime userBeginHour = LocalTime.parse(availability.getBeginHour());
			LocalTime userEndHour = LocalTime.parse(availability.getEndHour());
			for (Map.Entry<Long, List<Availability>> entry : availabilityMap.entrySet()) {
				if (entry.getKey() != userId) {
					for (int i = 0; i < entry.getValue().size(); i++) {
						if (LocalTime.parse(entry.getValue().get(i).getBeginHour())
								.isAfter(userBeginHour.minusMinutes(30))
								&& LocalTime.parse(entry.getValue().get(i).getBeginHour()).isBefore(userEndHour))
							userList.add(userRepository.findUserById(entry.getKey()));
					}
				}
			}
		}
		return userList;
	}

}
