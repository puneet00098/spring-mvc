package demo.spring.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component(value="empDao")
public class EmpDAO {

	private List<String> names = new ArrayList<>();
	
	public EmpDAO() {
		System.out.println("EmpDAO constructor invoked.");
	}
	
	public void insert(String name) {
		System.out.println("EmpDAO - insert invoked with " + name);
		names.add(name);
	}

	public List<String> list() {
		System.out.println("EmpDAO - list invoked ");
		if (names.size() == 0 )
				throw new RuntimeException("Error - list size is zero");
		return names;
	}

}
