package PO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cache;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

//和students构成单向一对多
@Entity
public class Teacher {
	@Id
	@GeneratedValue(generator="teacher")
	@GenericGenerator(name="teacher",strategy="assigned")
	private int teacherId;
	private String tracherName;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="teacherId")
	private Set<Students> students = new HashSet<Students>();

	public Teacher() {
		super();
	}

	public Teacher(int teacherId, String tracherName) {
		super();
		this.teacherId = teacherId;
		this.tracherName = tracherName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTracherName() {
		return tracherName;
	}

	public void setTracherName(String tracherName) {
		this.tracherName = tracherName;
	}

	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", tracherName=" + tracherName + "]";
	}

}
