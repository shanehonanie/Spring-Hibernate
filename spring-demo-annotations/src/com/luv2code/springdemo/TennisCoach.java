package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach() constructor");
	}
	
	// define init method
	@PostConstruct
	public void doStartupStuff() {
		System.out.println("TennisCoach doStartupStuff");
	}
	
	// define destroy method
	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("TennisCoach doCleanupStuff");
	}
	
//	// define a setter method
//	@Autowired
//	public void doOtherMethod(FortuneService fortuneService) {
//		System.out.println("doOtherMethod(...) method");
//		this.fortuneService = fortuneService;
//	}
	
//	// define a setter method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("setFortuneService(...) method");
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
