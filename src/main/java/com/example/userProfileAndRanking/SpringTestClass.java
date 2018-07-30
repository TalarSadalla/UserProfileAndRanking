package com.example.userProfileAndRanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.userProfileAndRanking.dto.UserTO;

import com.example.userProfileAndRanking.service.UserGameServiceImpl;
import com.example.userProfileAndRanking.service.UserPlayabilityServiceImpl;
import com.example.userProfileAndRanking.service.UserStatisticsServiceImpl;
/*
@SpringBootApplication
@ContextConfiguration(classes = { UserGameServiceImpl.class, UserPlayabilityServiceImpl.class,
		UserStatisticsServiceImpl.class, serviceImpl.UserEditServiceImpl.class })
public class SpringTestClass implements ApplicationRunner {

	@Autowired
	private serviceImpl.UserEditServiceImpl userServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringTestClass.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		UserTO userTO = new UserTO("Talar", "Sadalla", "1234", "wp@pl", "GOGOGO");
		userServiceImpl.editUser(1, userTO);
		userServiceImpl.showUser(1);
	}
}
*/
