package demo.spring.app;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("demo.spring.app")
public class Application {

	public EmpDAO proxyConfig() {
		System.out.println("in proxyConfig...");
		ProxyFactory factory = new ProxyFactory(new EmpDAO());
		factory.addAdvice(new Logger());
		factory.addAdvice(new Logger());
		factory.addAdvice(new MyErrorHandler());
		return (EmpDAO) factory.getProxy();		
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		System.out.println("---------------------------context loaded---------------------");
		
		EmpDAO empDao = ctx.getBean("empDao",EmpDAO.class);
		empDao.insert("aaaa");empDao.insert("dfdfd");empDao.insert("sasasas");empDao.insert("dwdwdwdw");
		empDao.list().stream().sorted().forEach(System.out::println);

	}

}
