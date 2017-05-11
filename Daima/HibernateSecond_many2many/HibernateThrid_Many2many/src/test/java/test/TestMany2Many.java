package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Employee;
import entity.Project;
import util.HibernateUtil;

public class TestMany2Many {

	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
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
	public void testInsert(){
		Employee e1=new Employee(20144057, "cs");
		Employee e2=new Employee(20144056, "zy");
		
		Project p1=new Project(1, "javaEE");
		Project p2=new Project(2, "android");
		
		p1.getEmployees().add(e1);
		p1.getEmployees().add(e2);
		p2.getEmployees().add(e1);
		
		session.save(p1);
		session.save(p2);
	}
	
}
