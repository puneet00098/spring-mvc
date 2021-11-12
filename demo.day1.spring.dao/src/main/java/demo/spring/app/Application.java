package demo.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import demo.spring.app.connect.DeptDao;
import demo.spring.app.simple.SimpleAnnotatedBean;
import demo.spring.app.simple.SimpleBean;

@Configuration
@ComponentScan("demo.spring.app")
public class Application {

	@Bean
	@Scope(value = "prototype")
	public SimpleBean simple() {
		System.out.println("--> in getSimpleBean of Application class.");
		return new SimpleBean();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		System.out.println("----------------context loaded------------------");
		
		String [] arr = ctx.getBeanDefinitionNames();
		for(String string : arr) {
			System.out.println(string);
		}
		
		System.out.println("--------------------------------------------------");
		DeptDao deptDao = ctx.getBean("deptDao",DeptDao.class);
		
		deptDao.insert();
		
		/*
		 * SimpleBean s1 = ctx.getBean("SimpleBean", SimpleBean.class); s1.m1();
		 * SimpleBean s2 = ctx.getBean("SimpleBean", SimpleBean.class); s2.m1();
		 */
		SimpleAnnotatedBean s11 = ctx.getBean("simpleAB", SimpleAnnotatedBean.class);
		s11.m1();

	}

}
