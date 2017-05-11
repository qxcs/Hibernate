package entity;

import java.util.HashSet;
import java.util.Set;

public class Project {

	private int pid;
	private String proname;
	
	private Set<Employee> employees=new HashSet<Employee>();
	
	public Project(int pid, String proname) {
		this.pid = pid;
		this.proname = proname;
	}
	public Project() {
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
