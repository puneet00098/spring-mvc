package demo.spring.app;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import demo.spring.app.dao.DeptDAO;
import demo.spring.app.model.Dept;

@Configuration
@ComponentScan("demo.spring.app")
@EnableTransactionManagement
public class HibernateApplication {

	@Bean
	public LocalSessionFactoryBean sessionfactory() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(ds());
		bean.setPackagesToScan("demo.spring.app");
		bean.setHibernateProperties(hibernateProperties());
		return bean;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		return hibernateProperties;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionfactory().getObject());
		return transactionManager;
	}

	public DataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateApplication.class);
		DeptDAO dao = ctx.getBean("deptDao", DeptDAO.class);
		for (int i = 10; i < 40; i += 10) {
			Dept d = new Dept(i, "DNameof" + i, "Pnq");
			if ((i % 20) == 0)
				d.setLoc("Hyt");
			dao.insert(d);
		}

		System.out.println("--------------List -----------------");
		dao.read().forEach(System.out::println);

		dao.delete(20); 
		Dept d = new Dept(10,"HR", "Del");
		dao.update(d);
		System.out.println("--------------Modified List -----------------");
		dao.read().forEach(System.out::println);

	}



}
