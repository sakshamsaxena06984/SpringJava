package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//    	ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//    	JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
//    	String query="insert into student(id,name,city) values(?,?,?)";
//    	
//    	template.update(query,121,"Uttam","Kanpur");
//    	System.out.println("Number of record stored!");
//    	
//    	String query="insert into student(id,name,city) values(?,?,?)";
//    	template.update(query,131,"suttam","delhi");
//    	System.out.println("Number of record stored!");
    	
//    	StudentDao stu=context.getBean("studentDao",StudentDao.class);
//    	Student newstudent=new Student(78,"qqqq","pppp");
//    	int ans_r=stu.insert(newstudent);
//    	System.out.println("how many data is stored: "+ans_r);
    	
    	
    	// now, update query
//    	StudentDao stu=context.getBean("studentDao",StudentDao.class);
//    	Student obj=new Student(78,"newSanju","newMumbai");
//    	int ansR=stu.update(obj);
//    	System.out.println("how many object update : "+ansR);
    		
    	//now, delete the query
//    	StudentDao stude=context.getBean("studentDao",StudentDao.class);
//    	int ansR=stude.delete(78);
//    	System.out.println("how many object update : "+ansR);
    	
    	//now, selecting the data
//    	Student stuobj=stude.getStudent(111);
//    	System.out.println(stuobj);
//    	System.out.println("Id of student: "+stuobj.getId());
//    	System.out.println("Name of student: "+stuobj.getName());
    	
    	//now, selecting the all data
//    	List<Student> allStudent = stude.getAllStudent();
//    	for(Student obj:allStudent) {
//    		System.out.println(obj);
//    	}
    	
    	ApplicationContext context=new AnnotationConfigApplicationContext(javaConfig.class);
    	StudentDao obj=context.getBean("studentDao",StudentDao.class);
 /*   	
    	//insert one record in the tables
    	Student stu=new Student(93,"ndskja","sandkj");
    	int insertc = obj.insert(stu);
    	System.out.println("number of inserted records are : "+insertc);
    	
    	*/
    	
    	//fetching the whole data
    	
    	List<Student> lStudent=obj.getAllStudent();
    	for(Student objs:lStudent) {
    		System.out.println(objs);
    	}
    }
}
