package demo.spring.app;

import org.springframework.aop.ThrowsAdvice;

public class MyErrorHandler implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("-->in afterThrowing with"+ex);
	}
}
