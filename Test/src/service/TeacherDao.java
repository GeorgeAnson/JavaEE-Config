package service;

import java.util.List;

import entity.Teacher;

public interface TeacherDao {
	public  List<Teacher> queryAllTeachers();
	
	public boolean addTeacher(Teacher t);
	
	public boolean deleteTeacher(Teacher tid);
	
	public boolean updateTeacher(Teacher t);
 
}
