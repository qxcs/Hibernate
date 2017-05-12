package PO;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.HibernateUtil;

public class StudentsTest {

	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	Query query;
	
	@Before
	public void init(){
		session=HibernateUtil.getSession();
		transaction=session.beginTransaction();
	}
	
	@After
	public void desdroy(){
		transaction.commit();
		HibernateUtil.closeSession(session);
	}
	@Test
	public void testQueryFrom(){
		Students s1=new Students(1, "cs", "male", "重庆", new Date());
		Students s2=new Students(3, "zy", "female", "武汉", new Date());
		
		session.save(s2);
		session.save(s1);
		
		//from练习
		query=session.createQuery(" from Students s");
		List<Students> students=query.list();
		for(Students s:students){
			System.out.println(s.toString());
		}
	}
	@Test
	public void testQuerySelect(){
		Students s1=new Students(1, "cs", "male", "重庆", new Date());
		Students s2=new Students(2, "zy", "female", "武汉", new Date());
		
		session.save(s2);
		session.save(s1);
		
		//select练习，多个字段时返回object[]的集合，一个字段时返回object的集合
		query=session.createQuery("select s.id,s.name,s.address from Students s");
		List<Object[]> objects=query.list();
		for(Object[] object:objects){
			System.out.println("id:"+object[0]+" name:"+object[1]+" address:"+object[2]);
		}
	}
	@Test
	public void testQueryWhere(){
		Students s1=new Students(1, "cs", "male", "重庆", new Date());
		Students s2=new Students(2, "zy", "female", "武汉", new Date());
		
		session.save(s2);
		session.save(s1);
		
		//select练习，多个字段时返回object[]的集合，一个字段时返回object的集合
		query=session.createQuery("from Students s where s.id>1");//s.id is not null; s.id is null;
		List<Students> students=query.list();
		for(Students student:students){
			System.out.println(student.toString());
		}
	}
	@Test
	public void testMany2One(){
		ClassRoom c1=new ClassRoom(1, "通信工程");
		ClassRoom c2=new ClassRoom(2, "电子信息");
		
		Students s1=new Students(1, "cs", "male", "重庆", new Date());
		Students s2=new Students(2, "zy", "female", "武汉", new Date());
		Students s3=new Students(3, "yzh", "male", "北京", new Date());
		Students s4=new Students(4, "sbh", "female", "北京", new Date());
		
		s1.setClassRoom(c1);
		s2.setClassRoom(c1);
		s3.setClassRoom(c2);
		s4.setClassRoom(c2);
		
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
	}
	@Test
	public void testOne2Many(){
		Teacher t1=new Teacher(1, "曾令秋");
		Teacher t2=new Teacher(2, "韩庆文");
		
		Students s1=new Students(1, "cs", "male", "重庆", new Date());
		Students s2=new Students(2, "zy", "female", "武汉", new Date());
		Students s3=new Students(3, "yzh", "male", "北京", new Date());
		Students s4=new Students(4, "sbh", "female", "北京", new Date());
		
		Set<Students> students1=new HashSet<Students>();
		students1.add(s1);
		students1.add(s2);
		Set<Students> students2=new HashSet<Students>();
		students2.add(s3);
		students2.add(s4);
		
		t1.setStudents(students1);
		t2.setStudents(students2);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(t1);
		session.save(t2);
	}
	@Test
	public void testMany2Many(){
		
		Students s1=new Students(1, "cs", "male", "重庆", new Date());
		Students s2=new Students(2, "zy", "female", "武汉", new Date());
		Students s3=new Students(3, "yzh", "male", "北京", new Date());
		Students s4=new Students(4, "sbh", "female", "北京", new Date());
		
		Hobby h1=new Hobby(1, "basketball");
		Hobby h2=new Hobby(2, "tennis");
		Hobby h3=new Hobby(3, "computer programming");
		Hobby h4=new Hobby(4, "swimming");
		
		Set<Hobby> hobbies1=new HashSet<Hobby>();
		hobbies1.add(h1);
		hobbies1.add(h2);
		Set<Hobby> hobbies2=new HashSet<Hobby>();
		hobbies2.add(h3);
		hobbies2.add(h4);
		
		s1.setHobbies(hobbies1);
		s2.setHobbies(hobbies1);
		s3.setHobbies(hobbies2);
		s4.setHobbies(hobbies2);
		
		session.save(h1);
		session.save(h2);
		session.save(h3);
		session.save(h4);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
	}
}
