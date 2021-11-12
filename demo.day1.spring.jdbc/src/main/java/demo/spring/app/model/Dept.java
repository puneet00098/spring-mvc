package demo.spring.app.model;

public class Dept {

	 private Integer deptNo;
	 private String dName;
	 private String loc;
	 
	public Dept(Integer deptNo, String dName, String loc) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
	}

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", dName=" + dName + ", loc=" + loc + "]";
	}
	 
	 

}
