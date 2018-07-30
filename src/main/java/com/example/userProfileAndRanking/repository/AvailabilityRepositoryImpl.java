package com.example.userProfileAndRanking.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.userProfileAndRanking.model.Availability;

@Repository
public class AvailabilityRepositoryImpl implements AvailabilityRepository {

	private List<Availability> availabilityListUser1 = new ArrayList<>();
	private List<Availability> availabilityListUser2 = new ArrayList<>();
	private List<Availability> availabilityListUser3 = new ArrayList<>();
	private List<Availability> availabilityListUser4 = new ArrayList<>();
	private Map<Long, List<Availability>> fullAvailabilityList = new HashMap<>();

	@PostConstruct
	public void initialize() {
		availabilityListUser1.add(new Availability(1, "12:00", "13:30"));
		availabilityListUser1.add(new Availability(1, "14:00", "15:30"));
		availabilityListUser1.add(new Availability(1, "16:00", "17:30"));
		availabilityListUser2.add(new Availability(2, "13:30", "15:00"));
		availabilityListUser3.add(new Availability(3, "17:00", "20:30"));
		availabilityListUser3.add(new Availability(3, "10:00", "11:30"));
		availabilityListUser3.add(new Availability(3, "20:00", "20:30"));
		availabilityListUser4.add(new Availability(4, "08:00", "13:00"));
		fullAvailabilityList.put((long) 1, availabilityListUser1);
		fullAvailabilityList.put((long) 2, availabilityListUser2);
		fullAvailabilityList.put((long) 3, availabilityListUser3);
		fullAvailabilityList.put((long) 4, availabilityListUser4);
	}

	@Override
	public void addAvailibility(long userId, String beginHour, String endHour) {
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		Availability availability = new Availability();
		availability.setUserId(userId);
		availability.setBeginHour(beginHour);
		availability.setEndHour(endHour);
		availabilityList.add(availability);
		fullAvailabilityList.put(userId, availabilityList);
	}

	@Override
	public void addAvailibility(Availability availability) {
		List<Availability> availabilityList = fullAvailabilityList.get(availability.getId());
		availabilityList.add(availability);
		fullAvailabilityList.put(availability.getId(), availabilityList);
	}

	@Override
	public List<Availability> getUserAvailabilities(long userId) {
		if (userId <= 0 || userId > fullAvailabilityList.size())
			throw new IndexOutOfBoundsException();
		return fullAvailabilityList.get(userId);
	}

	@Override
	public void editAvailibility(long userId, Availability oldAvailability, Availability newAvailability) {
		if (userId <= 0 || userId > fullAvailabilityList.size())
			throw new IndexOutOfBoundsException();
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		Availability foundAvailability = findAvailabilityByAvailability(userId, oldAvailability);
		foundAvailability.setBeginHour(newAvailability.getBeginHour());
		foundAvailability.setEndHour(newAvailability.getEndHour());
	}

	private Availability findAvailabilityByAvailability(long userId, Availability oldAvailability) {
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		for (int i = 0; i < availabilityList.size(); i++) {
			if (availabilityList.get(i).getBeginHour().equals(oldAvailability.getBeginHour())
					&& availabilityList.get(i).getEndHour().equals(oldAvailability.getEndHour())) {
				return availabilityList.get(i);
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public Availability deleteAvailibility(long userId, Availability availabilityToDelete, String reason) {
		List<Availability> availabilityList = fullAvailabilityList.get(userId);
		Availability foundAvailability = findAvailabilityByAvailability(userId, availabilityToDelete);
		foundAvailability.setBeginHour(null);
		foundAvailability.setEndHour(null);
		foundAvailability.setComment(reason);
		availabilityList.remove(foundAvailability);
		fullAvailabilityList.put(userId, availabilityList);
		return foundAvailability;
	}

	public Map<Long, List<Availability>> getAllAvailabilities() {
		return fullAvailabilityList;
	}

}
