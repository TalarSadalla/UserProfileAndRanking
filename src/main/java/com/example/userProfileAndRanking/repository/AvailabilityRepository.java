package com.example.userProfileAndRanking.repository;

import java.util.List;
import java.util.Map;

import com.example.userProfileAndRanking.model.Availability;

public interface AvailabilityRepository {

	void addAvailibility(long userId, String beginHour, String endHour);

	void addAvailibility(Availability availability);

	List<Availability> getUserAvailabilities(long userId);

	void editAvailibility(long userId, Availability oldAvailability, Availability newAvailability);

	Availability deleteAvailibility(long userId, Availability availabilityToDelete, String reason);

	Map<Long, List<Availability>> getAllAvailabilities();
}
