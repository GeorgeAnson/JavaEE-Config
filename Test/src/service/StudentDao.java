package service;

import java.util.List;

import entity.Student;

public interface StudentDao {
	public List<Student> queryAllStudents();
	
	public Student queryStudentBySid(String sid);
	
	public boolean addStudent(Student s);
	
	public boolean updateStudent (Student s);
	
	public boolean deleteStudent(String sid);
 

 	
	
}
