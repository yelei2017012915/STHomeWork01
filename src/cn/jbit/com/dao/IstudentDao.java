package cn.jbit.com.dao;

import java.util.List;

import cn.jbit.com.dao.entity.Student;

public interface IstudentDao {
	/**
	 * 方法功能说明：查询全部的学生信息
	 * @return 返回学生集合
	 */
	public List<Student> listAllStudent() ;
	/**
	 * 方法功能说明：添加一个学生
	 * @param student 一个学生的对象
	 * @return 插入失败返回-1，插入成功返回1
	 */
	public int addStudent(Student student);
	
	/**
	 * 方法功能说明：修改一个学生
	 * @param student 一个学生的对象
	 * @return 修改失败返回-1，修改成功返回1
	 */
	public int updateStudent(Student student,String absPath);
	/**
	 * 方法功能说明：得到总记录数
	 * 
	 * @return 返回总记录数
	 */
	public int getTotalCount();
	
	/**
	 * 方法功能说明：分页查询方法
	 * 
	 * @return 返回总记录数
	 */
	public List<Student> getPageStudents(int pageSize,int currentPage);
	
	/**
	 * 方法功能说明：得到总记录数
	 * 
	 * @return 返回总记录数
	 */
	public int getProcedureTotalCount();
	
	/**
	 * 方法功能说明：根据一个ID查找学生数据
	 * @param id
	 * @return Student
	 */
	public Student fandStuById(int id);
	/**
	 * 方法功能说明：根据一个ID删除学生数据
	 * @param id
	 * @return Student
	 */
	public int deleteStuById(int id,String absPath) ;
}
