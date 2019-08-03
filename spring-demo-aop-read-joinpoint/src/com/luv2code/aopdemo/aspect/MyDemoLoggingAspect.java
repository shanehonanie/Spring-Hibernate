package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterOrSetter()")
	public void addAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> MyDemoLoggingAspect()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// display the method args
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru
		for(Object o : args) {
			System.out.println(o);
			
			if(o instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) o;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
	}
}
	
	
