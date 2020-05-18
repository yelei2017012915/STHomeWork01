package cn.jbit.com.dao;

import java.util.List;

import cn.jbit.com.dao.entity.Student;

public interface IstudentDao {
	/**
	 * ��������˵������ѯȫ����ѧ����Ϣ
	 * @return ����ѧ������
	 */
	public List<Student> listAllStudent() ;
	/**
	 * ��������˵�������һ��ѧ��
	 * @param student һ��ѧ���Ķ���
	 * @return ����ʧ�ܷ���-1������ɹ�����1
	 */
	public int addStudent(Student student);
	
	/**
	 * ��������˵�����޸�һ��ѧ��
	 * @param student һ��ѧ���Ķ���
	 * @return �޸�ʧ�ܷ���-1���޸ĳɹ�����1
	 */
	public int updateStudent(Student student,String absPath);
	/**
	 * ��������˵�����õ��ܼ�¼��
	 * 
	 * @return �����ܼ�¼��
	 */
	public int getTotalCount();
	
	/**
	 * ��������˵������ҳ��ѯ����
	 * 
	 * @return �����ܼ�¼��
	 */
	public List<Student> getPageStudents(int pageSize,int currentPage);
	
	/**
	 * ��������˵�����õ��ܼ�¼��
	 * 
	 * @return �����ܼ�¼��
	 */
	public int getProcedureTotalCount();
	
	/**
	 * ��������˵��������һ��ID����ѧ������
	 * @param id
	 * @return Student
	 */
	public Student fandStuById(int id);
	/**
	 * ��������˵��������һ��IDɾ��ѧ������
	 * @param id
	 * @return Student
	 */
	public int deleteStuById(int id,String absPath) ;
}
