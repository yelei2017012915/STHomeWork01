package cn.jbit.com.test;


import java.util.List;

import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.entity.Student;
import cn.jbit.com.dao.impl.StudentDaoImpl;

public class TestStudentDaoImpl {
	public static void main(String[] args) {
//		//���Բ�ѯȫ��ѧ����Ϣ
//		IstudentDao sDao = new StudentDaoImpl();
//		 List<Student>  students = sDao.listAllStudent();
//		 System.out.println("���\t����\t�Ա�\t����\t��ַ");
//		 for (Student student : students) {
//			 System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getSex()+"\t"+student.getAge()+"\t"+student.getAddress());
//		}
		
		//�������ѧ����Ϣ��ǰ�˾���һ��ע�Ṧ��
		IstudentDao sDao = new StudentDaoImpl();
		Student student = new Student();
		student.setId(89);
		student.setName("�Ϻ���");
		student.setSex("��");
		student.setAge(23);
		student.setAddress("����");
		student.setPictrue("ds2322342334dsds");
		int i = sDao.addStudent(student);
		if (i==-1) {
			System.out.println("���ʧ��");
		} else {
			System.out.println("��ӳɹ�");
		}
		
//		//�����޸�ѧ����Ϣ��ǰ�˾���һ��ע�Ṧ��
//				IstudentDao sDao = new StudentDaoImpl();
//				Student student = new Student();
//				student.setId(89);
//				student.setName("����22");
//				student.setSex("��");
//				student.setAge(22);
//				student.setAddress("����222");
//				int i = sDao.updateStudent(student);
//				if (i==-1) {
//					System.out.println("�޸�ʧ��");
//				} else {
//					System.out.println("�޸ĳɹ�");
//				}
//		 
		 

		
	}
}
