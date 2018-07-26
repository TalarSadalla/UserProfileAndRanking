package serviceImpl;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.AvailabilityTO;
import dto.UserTO;
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

	@Autowired
	private ModelMapper modelMapper;

	public void addUserAvailabilityHours(Long userId, String beginHour, String endHour) {
		availabilityRepository.addAvailibility(userId, beginHour, endHour);
	}

	public void addUserAvailabilityHours(AvailabilityTO availabilityTO) {
		Availability newAvailability = modelMapper.map(availabilityTO, Availability.class);
		availabilityRepository.addAvailibility(newAvailability);
	}

	public void editUserAvailabilityHours(Long userId, AvailabilityTO oldAvailabilityTO,
			AvailabilityTO newAvailabilityTO) {
		Availability oldAvailability = modelMapper.map(oldAvailabilityTO, Availability.class);
		Availability newAvailability = modelMapper.map(newAvailabilityTO, Availability.class);
		availabilityRepository.editAvailibility(userId, oldAvailability, newAvailability);
	}

	public void deleteUserAvailabilityHours(long userId, AvailabilityTO availabilityToDeleteTO, String reason) {
		Availability availabilityToDelete = modelMapper.map(availabilityToDeleteTO, Availability.class);
		availabilityRepository.deleteAvailibility(userId, availabilityToDelete, reason);
	}

	public List<UserTO> listOfAvailableUsersInSimilarAvailableHours(long userId) {
		List<UserTO> userListTO = modelMapper.map(userRepository.findAllUsers(), UserTO.class);
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
							userListTO.add(modelMapper.map(userRepository.findUserById(entry.getKey()), UserTO.class));

					}
				}
			}
		}
		Random rand = new Random();
		int value = rand.nextInt(userRepository.getUserGameList(userId).size());
		List<User> userList = modelMapper.map(userListTO, User.class);
		challengeRepository.createChallenge(userList, userRepository.getUserGameList(userId).get(value));
		return userListTO;
	}

}
