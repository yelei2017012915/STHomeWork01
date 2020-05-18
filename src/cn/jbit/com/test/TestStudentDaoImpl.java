package cn.jbit.com.test;


import java.util.List;

import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.entity.Student;
import cn.jbit.com.dao.impl.StudentDaoImpl;

public class TestStudentDaoImpl {
	public static void main(String[] args) {
//		//测试查询全部学生信息
//		IstudentDao sDao = new StudentDaoImpl();
//		 List<Student>  students = sDao.listAllStudent();
//		 System.out.println("编号\t姓名\t性别\t年龄\t地址");
//		 for (Student student : students) {
//			 System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getSex()+"\t"+student.getAge()+"\t"+student.getAddress());
//		}
		
		//测试添加学生信息，前端就是一个注册功能
		IstudentDao sDao = new StudentDaoImpl();
		Student student = new Student();
		student.setId(89);
		student.setName("老韩国");
		student.setSex("男");
		student.setAge(23);
		student.setAddress("广西");
		student.setPictrue("ds2322342334dsds");
		int i = sDao.addStudent(student);
		if (i==-1) {
			System.out.println("添加失败");
		} else {
			System.out.println("添加成功");
		}
		
//		//测试修改学生信息，前端就是一个注册功能
//				IstudentDao sDao = new StudentDaoImpl();
//				Student student = new Student();
//				student.setId(89);
//				student.setName("老乡22");
//				student.setSex("男");
//				student.setAge(22);
//				student.setAddress("广西222");
//				int i = sDao.updateStudent(student);
//				if (i==-1) {
//					System.out.println("修改失败");
//				} else {
//					System.out.println("修改成功");
//				}
//		 
		 

		
	}
}
