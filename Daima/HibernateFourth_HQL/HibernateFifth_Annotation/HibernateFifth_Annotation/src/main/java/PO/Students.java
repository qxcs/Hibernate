package PO;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	private Blob picture; //照片，测试用hibernate写入
	
	public Students(){
		
	}

	
	
	public Blob getPicture() {
		return picture;
	}



	public void setPicture(Blob picture) {
		this.picture = picture;
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

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", sex=" + sex + ", address=" + address + ", birthday="
				+ birthday + "]";
	}


	
	
}
