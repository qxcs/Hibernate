
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Grade;
import entity.Student;
import util.HibernateUtil;

public class TestMany2One {

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
	//增
	public void testAdd(){
		//获得班级和学生对象
		Grade grade=new Grade("1班", "通信工程");
		Student s1=new Student("程胜", "male");
		Student s2=new Student("周扬", "female");
		//将学生对象添加到班级中去
		grade.getStudents().add(s1);
		grade.getStudents().add(s2);
		//保存到数据库
		session.save(s1);
		session.save(s2);
		session.save(grade);
	}
	@Test
	//查
	public void testFindByGid(){
		//根据班级编号得到班级
		Grade grade=(Grade)session.get(Grade.class, 1);
		System.out.println("班级信息为"+grade.getGdesc());
		//查找班级里的学生
		Set<Student> students=grade.getStudents();
		for(Student s:students){
			System.out.println(s.getSid()+","+s.getSex()+","+s.getSname());
		}
		
	}
	@Test
	//改
	public void testUpdate(){
		//新增一个二班
		Grade grade=new Grade("电子", "电子信息工程");
		//找到学生
		Student student=(Student) session.get(Student.class, 1);
		//修改学生信息
		grade.getStudents().add(student);//看上去是在新班中加入学生1，根据sql语句可以发现，实质是根据学生的sid修改学生的gid
		//保存到数据库
		session.save(grade);
		session.save(student);
	}
}
