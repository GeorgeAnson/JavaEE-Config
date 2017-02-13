package action;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Student;
import service.StudentDao;
import service.impl.StudentDaoImpl;

public class StudentAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String query(){
		System.out.println("---开始查找学生----");
		StudentDao studentDao=new StudentDaoImpl();
		List<Student> list=studentDao.queryAllStudents();
		if (list!=null) {
			session.setAttribute("student_list", list);
			System.out.println("--------1111111111111111111111111111111-----------------------------");
		}
		System.out.println();
 
		return "Student_query_success";
		
	}
	
	public String delete(){
		
		StudentDao studentDao=new StudentDaoImpl();
		String sid=request.getParameter("sid");
		studentDao.deleteStudent(sid);
		return "delete_success";
		
		 
	}
	//add
	public String add() throws Exception{
		Student student=new Student();
		//student.setSid(request.getParameter("sid"));
		student.setAddress(request.getParameter("address"));
		student.setGender(request.getParameter("gender"));
		student.setSname(request.getParameter("sname"));
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		student.setBirthday(sdf.parse(request.getParameter("birthday")));
		System.out.println("====================添加=================================");
		
		return "add_success";
	}
	
	//modify
	
	public String modify(){
		
		String sid =request.getParameter("sid");
		StudentDao studentDao=new StudentDaoImpl();
		Student student=studentDao.queryStudentBySid(sid);
		session.setAttribute("modify_student", student);
		return "modify_success";
	} 
	
	// save modify action
	public String save() throws Exception{
		Student student=new Student();
		student.setSid(request.getParameter("sid"));
		student.setSname(request.getParameter("sname"));
		student.setAddress(request.getParameter("address"));
		student.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		student.setBirthday(sdf.parse(request.getParameter("birthday")));
	
		StudentDao studentDao=new StudentDaoImpl();
		studentDao.updateStudent(student);	
		return "save_success";
		
	}
	
	public String queryStudentBySid(){
		
		
		
		
		return "queryStudentBySid_success";
	}

}
