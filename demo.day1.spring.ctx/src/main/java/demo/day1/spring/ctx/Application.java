package demo.day1.spring.ctx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ApplicationContext ctx = new ClassPathXmlApplicationContext("demo.xml");
				System.out.println("----------------Context Loaded---------------------");
				//Simple s1 =new Simple();
				Simple s1 = ctx.getBean("simple",Simple.class);
				s1.m1();
				Simple s2 = ctx.getBean("simple",Simple.class);
				s2.m1();
				Simple s3 = ctx.getBean("simple",Simple.class);
				s3.m1();
				Simple s4 = ctx.getBean("simple",Simple.class);
				s4.m1();

	}

}
