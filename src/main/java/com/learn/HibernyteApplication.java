package com.learn;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.model.Gender;
import com.learn.model.User;
import com.learn.model.UserProfile;
import com.learn.model.UserProfileRepository;
import com.learn.model.UserRepository;

@SpringBootApplication
public class HibernyteApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserProfileRepository userProfileRepo;

	public static void main(String[] args) {
		SpringApplication.run(HibernyteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		userProfileRepo.deleteAllInBatch();
		userRepo.deleteAllInBatch();
		
		//=====================================
		
		// Create a user instance
		User user = new User("Onaulogho", "Lawrence", "onalaw@gmail.com", "MYPASSWORD");
		
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1993, 8, 11);
		
		// Create a user profile instance
		UserProfile userProfile = new UserProfile("08168581809", Gender.MALE, dateOfBirth.getTime(), "Lawrence str", "Census", "Lagos", "Lagos", "Nigeria", "234");
		
		// Set child reference(userProfile) in parent entity(user)
		user.setUserProfile(userProfile);
		
		// Set parent reference(user) in child entity(userProfile)
		userProfile.setUser(user);
		
		// Save parent reference (which will save the child as well)
		userRepo.save(user);
		
		//==================================
		
	}

}

