package demo.spring.app.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import demo.spring.app.model.Dept;

@Component(value="deptDao")
public class DeptDao {
	@Autowired
	private DataSource ds;
	
	private JdbcTemplate template;
	
	@PostConstruct 
	public void initMethod() {
		template = new JdbcTemplate(ds);
	}
	
	public void insert(Dept d) {
		String sql = "select count(*) from dept";
		Integer result = template.queryForObject(sql, Integer.class);
		if(result == 1)
			sql = "insert into dept values (" +d.getDeptNo()+",'"+d.getdName()+"','"+d.getLoc()+"')";
		else
		sql = "create table dept  (deptno  integer  primary key, dname varchar(20), loc varchar(20))";
		template.execute(sql);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dept> read(){
		String sql = "select * from dept";
		System.out.println("In  read of DeptDao");
		List<Dept> departmentList = template.query(sql, new BeanPropertyRowMapper());
		return departmentList;
	}

	public void update(Integer deptNo, String newDeptName, String newLoc) {
		String sql = "UPDATE dept SET dName = '"+newDeptName+"', loc='"+newLoc+"'WHERE deptNo ="+deptNo;
		
		System.out.println("in update of DeptDao with "+sql);
		template.execute(sql); 
	}
	
	public void delete(Integer deptNo) {
		
		String sql = "DELETE FROM dept WHERE deptno=" + deptNo;
		System.out.println("in delete of DeptDAO with " + sql);
		template.execute(sql);
		
	}
}
