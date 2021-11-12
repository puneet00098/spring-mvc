package demo.spring.app;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import demo.spring.app.dao.DeptDao;
import demo.spring.app.model.Dept;
/**
 * This class is H2 Application and Mock test needs to accommodated.
 * @author puneet
 *
 */
@Configuration
@ComponentScan(basePackages = "demo.spring.app")
public class JDBCApplication {

	@Bean
	public DataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
		ds.setUrl("jdbc:hsqldb:hsql://localhost/");
		ds.setUsername("SA");
		ds.setPassword(null);
		return ds;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JDBCApplication.class);
		
		DeptDao deptDao = ctx.getBean("deptDao",DeptDao.class);
		for (int i = 10;i<100;i+=10) {
			Dept d= new Dept(i,"DNameof"+i,"Pnq");
			if ((i%20)==0)
				d.setLoc("Hyt");
			deptDao.insert(d);
		}
		System.out.println("--------------List -----------------");
		deptDao.read().forEach(System.out::println);
		
		deptDao.delete(20);
		deptDao.update(10,"HR", "Del");
		System.out.println("--------------Modified List -----------------");
		deptDao.read().forEach(System.out::println);

	}

}
