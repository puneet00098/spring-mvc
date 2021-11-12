package demo.spring.app.connect;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("deptDao")
public class DeptDao {

	@Autowired
	@Qualifier(value = "sql")
	private Connection con;
	
	public DeptDao() {
		System.out.println("--> DeptDao constructor invoked.  "+con);
	}
	
	@PostConstruct
	public void m1() {
		System.out.println("--> in m1 of DeptDao."+con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public void insert() {
		getCon().open();
		System.out.println("--> in insert of DeptDao.");
		getCon().close();
	}
}
