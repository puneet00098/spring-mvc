package demo.spring.app.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.spring.app.model.Dept;

@Component(value="deptDao")
@Transactional
public class DeptDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private HibernateTemplate template;

	@PostConstruct
	public void initMethod() {
		template = new HibernateTemplate(sessionFactory);
	}
	 
	/*
	 *create table dept  (deptno  integer  primary key, dname varchar(20), loc varchar(20)) 
	 */
	public void insert(Dept d) {
		System.out.println("in insert of DeptDAO");
		template.save(d);
	}
	
	public List<Dept> read(){
		String sql = "select d from Dept d";
		System.out.println("in read of DeptDAO with " + sql);
		List<Dept> departmentList = template.loadAll(Dept.class);
		return departmentList;
	}
	
	public void update(Dept d) {
		System.out.println("in update of DeptDAO with " + d);
		template.update(d);
	}

	public void delete(int deptno) {
		System.out.println("in delete of DeptDAO with " + deptno);
		Dept d = template.get(Dept.class, deptno);
		template.delete(d);
	}

}
