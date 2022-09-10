package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;
@Component("studentDao")
public class StudentDaoImp implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// this is the insert function initialization
	public int insert(Student student) throws DataAccessException{
		String query="insert into student (id,name,city) values(?,?,?)";
	    int ans=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	  
		return ans;
	}
	
	// this is the update function
	public int update(Student student) {
		String query="update student set name=?,city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getCity(),student.getName(),student.getId());
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int delete(int studentId) {
	   String query="delete from student where id=?";
	   int updater = jdbcTemplate.update(query,studentId);
		return updater;
	}

	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
//		RowMapperImpl rowMapper=new RowMapperImpl();
//		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		
		// Another way
		Student student=this.jdbcTemplate.queryForObject(query, new org.springframework.jdbc.core.RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}

		
			
		}, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
	    String query="select * from student";
	    List<Student> listStudent = this.jdbcTemplate.query(query,new RowMapperImpl());
		return listStudent;
	}

	


}
