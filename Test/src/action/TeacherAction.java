package action;

import java.util.List;

import entity.Teacher;
import service.TeacherDao;
import service.impl.TeacherDaoImpl;

public class TeacherAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String query(){
		
		TeacherDao teacherDao =new TeacherDaoImpl();
		List<Teacher> list=teacherDao.queryAllTeachers();
		if (list!=null) {
			session.setAttribute("teacher_list",list);
		}
		System.out.println("----------queryAllTeachers_success-------------------------");
		return "Teacher_query_success";
		
	}
}
