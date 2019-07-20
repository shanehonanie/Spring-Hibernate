package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	// define a private field for dependency
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// add an init method
	public void doStartupStuff() {
		System.out.println("TrackCoach: inside my doStartupStuff");
	}
	
	// add a destroy method
	public void doCleanupStuff() {
		System.out.println("TrackCoach: inside my doCleanupStuff");
	}
}
