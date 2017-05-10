package entity;

import java.util.HashSet;
import java.util.Set;

public class Grade {
	private int gid;
	private String gname;
	private String gdesc;
	
	private Set<Student> students=new HashSet<Student>();
	
	public Grade() {

	}

	public Grade( String gname, String gdesc) {
		this.gname = gname;
		this.gdesc = gdesc;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

}
