package demo.spring.app.simple;

import org.springframework.stereotype.Component;

@Component(value="simpleAB")
public class SimpleAnnotatedBean {

	public SimpleAnnotatedBean() {
		System.out.println("--> SimpleAnnotatedBean invoked.");
	}
	
	public void m1() {
		System.out.println("--> SimpleAnnotatedBean M1 method invoked.");
	}

}
