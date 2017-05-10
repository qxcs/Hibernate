package test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.*;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PO.Students;

public class StudentsTest {

		private SessionFactory sessionFactory;
		private Session session;
		private Transaction transaction;
		
		@Before
		public void init(){
			//创建配置对象
			Configuration config=new Configuration().configure();
			//创建服务注册对象
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//创建会话工厂对象
			sessionFactory=config.buildSessionFactory(serviceRegistry);
			//会话对象
			session=sessionFactory.openSession();
			//开启事务
			transaction=session.beginTransaction();
		}
		
		@After
		public void destroy(){
			
			transaction.commit();//提交事务
			session.close();//关闭会话
			sessionFactory.close();//关闭会话工厂
			
		}
		
		@Test
		public void testSaveStudents(){
			
			//生成学生对象
			Students s=new Students(1, "qx", "male", "武当山", new Date());
			//保存对象
			session.save(s);
		}
		
		@Test
		public void testSaveBlob() throws Exception{
			//生成学生对象
			Students s=new Students(2, "cs", "male", "背景", new Date());
			//读取照片并存储
			File f=new File("E://beauty.jpg");
			InputStream in=new FileInputStream(f);
			Blob image=Hibernate.getLobCreator(session).createBlob(in, in.available());
			//存储照片
			s.setPicture(image);
			in.close();
			//提交数据库
			session.save(s);
		}
		@Test
		public void testReadBlob() throws Exception{
			//获得学生对象
			Students s=(Students)session.get(Students.class, 2);
			//获得照片
			Blob blob=s.getPicture();
			//获得输入输出流
			InputStream in=blob.getBinaryStream();
			OutputStream out=new FileOutputStream(new File("E://beauty2.jpg"));
			//另存为
			byte[] buff=new byte[in.available()];
			in.read(buff);
			out.write(buff);
			//关闭流
			in.close();
			out.close();
		}
	
}
