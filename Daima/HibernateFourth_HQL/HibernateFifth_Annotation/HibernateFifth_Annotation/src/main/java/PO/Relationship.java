package PO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Relationship {

	@Id
	@GeneratedValue(generator="idcard")
	@GenericGenerator(name="idcard",strategy="assigned")
	private int IDcard;
	private String otherName;
	@OneToOne(mappedBy="lover")
	private Students students;
	
	public Relationship() {
	}
	public Relationship(int iDcard, String otherName) {
		super();
		IDcard = iDcard;
		this.otherName = otherName;
	}
	public int getIDcard() {
		return IDcard;
	}
	public void setIDcard(int iDcard) {
		IDcard = iDcard;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	@Override
	public String toString() {
		return "Relationship [IDcard=" + IDcard + ", otherName=" + otherName + "]";
	}
	
	
	
}
