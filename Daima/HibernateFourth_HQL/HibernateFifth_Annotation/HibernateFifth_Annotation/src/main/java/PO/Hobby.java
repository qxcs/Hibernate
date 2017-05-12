package PO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

//和Students构成多对多关系
@Entity
public class Hobby {
	@Id
	@GeneratedValue(generator = "hobby")
	@GenericGenerator(name = "hobby", strategy = "assigned")
	private int hobbyId;
	private String hobbyName;
	@ManyToMany(mappedBy="hobbies")
	private Set<Students> students=new HashSet<Students>();

	public Hobby() {
		super();
	}

	public Hobby(int hobbyId, String hobbyName) {
		super();
		this.hobbyId = hobbyId;
		this.hobbyName = hobbyName;
	}

	public int getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	@Override
	public String toString() {
		return "Hobby [hobbyId=" + hobbyId + ", hobbyName=" + hobbyName + "]";
	}

}
