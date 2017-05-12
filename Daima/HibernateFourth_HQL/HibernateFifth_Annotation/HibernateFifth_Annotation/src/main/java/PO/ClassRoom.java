package PO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
//用来和Students类构成多对一关系
@Entity
public class ClassRoom {

	@Id
	@GeneratedValue(generator="cid")
	@GenericGenerator(name="cid",strategy="assigned")
	private int cid;
	private String cname;
	public ClassRoom() {
		super();
	}
	public ClassRoom(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "ClassRoom [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
		
}
