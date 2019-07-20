package com.luv2code.springdemo;

public class FootballCoach implements Coach{
	
	@Override
	public String getDailyWorkout() {
		return "Throw 100 footballs";
	}

}
