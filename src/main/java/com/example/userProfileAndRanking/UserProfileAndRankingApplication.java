package com.example.userProfileAndRanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.userProfileAndRanking.repository.UserRepositoryImpl;

@SpringBootApplication
public class UserProfileAndRankingApplication {

	@Autowired
	UserRepositoryImpl userRepositoryImpl;

	public static void main(String[] args) {

		SpringApplication.run(UserProfileAndRankingApplication.class, args);
	}

}
