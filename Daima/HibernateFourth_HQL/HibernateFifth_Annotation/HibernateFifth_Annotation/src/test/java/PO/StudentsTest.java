package PO;

import java.util.Date;
import java.util.List;

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
}
