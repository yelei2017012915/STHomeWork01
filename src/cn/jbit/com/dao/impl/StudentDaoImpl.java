package cn.jbit.com.dao.impl;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import cn.jbit.com.dao.BaseDao;
import cn.jbit.com.dao.HibernateUtil;
import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.entity.Student;

public class StudentDaoImpl implements IstudentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listAllStudent() {
		List<Student> list=null;
		try {
			Session session=HibernateUtil.currentsession();
			list=session.createQuery("from Student").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			HibernateUtil.closeSession();
		}
		return list;
	}
	/**
	 * 
	 * ���ѧ����Ϣ
	 *
	 */
	@Override
	public int addStudent(Student student) {
		int count=0;
		try {
			Session session=HibernateUtil.currentsession();
			Transaction tx=session.beginTransaction();
			session.save(student);
			tx.commit();
			count=1;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			HibernateUtil.closeSession();
		}
		return count;
	}

	@Override
	public int updateStudent(Student student, String absPath) {
		//Student stu= this.fandStuById(student.getId());
		//String shujKPath = stu.getPictrue();
		int count = -1;
		try {
			Session session=HibernateUtil.currentsession();
			Transaction tx=session.beginTransaction();
			Student studentold =(Student)session.get(Student.class,student.getId());//���ص�ǰҪ�޸ĵĶ���
			String shujKPath = studentold.getPictrue();
			//�����ݿ��õ�upload/1356484525.jpg�ⲿ�ֵ�·��
			//D:/apache-tomcat-7.0.56/webapps/studentmanager/
			studentold.setName(student.getName());
			studentold.setAge(student.getAge());
			studentold.setSex(student.getSex());
			studentold.setAddress(student.getAddress());
			if(student.getPictrue()!=null){
				studentold.setPictrue(student.getPictrue());
				String picPaht = absPath+shujKPath;
				File file = new File(picPaht);
				file.delete();
			}
			tx.commit();
			count=1;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			HibernateUtil.closeSession();
		}
		return count;
	}
	/**
	 * ����ܼ�¼��
	 */
	@Override
	public int getTotalCount() {
		Long totalCount=null;
		try {
			Session session=HibernateUtil.currentsession();
			totalCount=(Long)session.createQuery("select count(*) from Student").uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			HibernateUtil.closeSession();
		} 
		return totalCount.intValue();
	}
	/**
	 * ��÷�ҳ�����б�
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getPageStudents(int pageSize, int currentPage) {
		List<Student> students =null;
		try {
			Session session=HibernateUtil .currentsession();
			String hql="from Student order by id desc ";
			students=session.createQuery(hql).setMaxResults(pageSize).setFirstResult((currentPage-1)*pageSize).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			HibernateUtil.closeSession();
		}
		return students;
	}

	@Override
	public int getProcedureTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * ͨ��ѧ����Ų�ѯѧ����Ϣ
	 */
	@Override
	public Student fandStuById(int id) {
		Student student=null;
		try {
			Session session=HibernateUtil.currentsession();
			student=(Student)session.get(Student.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			HibernateUtil.closeSession();
		}
		return student;
	}
	/**
	 * ͨ��ѧ�����ɾ��ѧ����Ϣ
	 */
	@Override
	public int deleteStuById(int id, String absPath) {
		
		int count=0;
		try {
			Session session=HibernateUtil.currentsession();
			Transaction tx=session.beginTransaction();
			Student student=(Student)session.get(Student.class, id);
			String shujKPath = student.getPictrue();
			session.delete(student);
			tx.commit();
			String picPaht = absPath+shujKPath;
			File file = new File(picPaht);
			file.delete();
			count=1;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			HibernateUtil.closeSession();
		}
		return count;
	}


}


