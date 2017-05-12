package PO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Students {

	@Id
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator",strategy="assigned")
	private int id;
	private String name;
	private String sex;
	private String address;
	private Date birthday;
	
	//一对一
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="otherName")
	private Relationship lover;
	//多对一
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="cid",referencedColumnName="CID")
	private ClassRoom classRoom;
	//多对多
	@ManyToMany
	@JoinTable(
			name="students2hobby",
			joinColumns={@JoinColumn(name="id")},
			inverseJoinColumns={@JoinColumn(name="hobbyId")}
	)
	private Set<Hobby> hobbies=new HashSet<Hobby>();
	
	public Students(){
		
	}

	
	


	public Students(int id, String name, String sex, String address, Date birthday) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	
	public Relationship getLover() {
		return lover;
	}



	public void setLover(Relationship lover) {
		this.lover = lover;
	}



	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", sex=" + sex + ", address=" + address + ", birthday="
				+ birthday + "]";
	}





	public ClassRoom getClassRoom() {
		return classRoom;
	}





	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}





	public Set<Hobby> getHobbies() {
		return hobbies;
	}





	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}


	
	
}
