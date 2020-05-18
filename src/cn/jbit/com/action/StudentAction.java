package cn.jbit.com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.entity.Student;
import cn.jbit.com.dao.impl.StudentDaoImpl;
import cn.jbit.com.util.Page;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	IstudentDao dao = new StudentDaoImpl();
	private Student student;
	private File pictrue;
	private String pictrueContentType;
	private String pictrueFileName;
	private String savePath;
	private int currentPage=1;
	private Page<Student> pageStu;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Page<Student> getPageStu() {
		return pageStu;
	}
	public File getPictrue() {
		return pictrue;
	}
	public String getPictrueContentType() {
		return pictrueContentType;
	}
	public String getPictrueFileName() {
		return pictrueFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public Student getStudent() {
		return student;
	}
	public void setPageStu(Page<Student> pageStu) {
		this.pageStu = pageStu;
	}
	public void setPictrue(File pictrue) {
		this.pictrue = pictrue;
	}
	public void setPictrueContentType(String pictrueContentType) {
		this.pictrueContentType = pictrueContentType;
	}
	public void setPictrueFileName(String pictrueFileName) {
		this.pictrueFileName = pictrueFileName;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	/*
	 * ɾ��ѧ����ϢAction
	 */
	public String delete() {
		//D:\apache-tomcat-7.0.56\webapps\studentmanager\
		String absPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
		int count = dao.deleteStuById(id, absPath);
		return SUCCESS;
	}
	/*
	 * ��ҳ��ѯѧ����ϢAction
	 */
	public String pageList() {
		pageStu = new Page<Student>();
		// pageStu ����һ��������װ��ҳ�õ����в���
		pageStu.setCurrentPage(currentPage);
		int totalCount = dao.getTotalCount();
		int pageSize = 5;// �ֹ���ֵ
		List<Student> students = dao.getPageStudents(pageSize,
				pageStu.getCurrentPage());
		// ������װ�������ҳ��������
		pageStu.setList(students);
		pageStu.setPageSize(pageSize);
		pageStu.setTotalCount(totalCount);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("pageStu", pageStu);
		return SUCCESS;
	}
	/*
	 * ע��ѧ����ϢAction
	 */
	public String register() throws Exception {
		Random r = new Random();
		int i = r.nextInt();
		int index = pictrueFileName.lastIndexOf(".") ;//�õ�.��λ��
		String extendName = pictrueFileName.substring(index, pictrueFileName.length());
		String filename=i+extendName;
		student.setPictrue("upload/" +filename) ;
		byte[] buffer = new byte[1024];
		FileInputStream fis = new FileInputStream(getPictrue());
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
				+ filename);
		int length = fis.read(buffer);
		while (length > 0) {
			fos.write(buffer, 0, length);
			length = fis.read(buffer);
		}
		fis.close();
		fos.flush();
		fos.close();
		int count = dao.addStudent(student);
		if (count > 0) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	/*
	 * ��ѯ����ѧ����ϢAction
	 */
	public String selectAll() {
		List<Student> list = dao.listAllStudent();
		if (list != null) {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put("list", list);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/*
	 * ����ѧ����Ų�ѯѧ����ϢAction
	 */
	public String selectById() {
		Student student = dao.fandStuById(id);
		Map<String, Object> session = (Map<String, Object>) ActionContext
				.getContext().getSession();
		session.put("student", student);
		return SUCCESS;
	}
	
	/*
	 * �޸�ѧ����ϢAction
	 */
	public String update() throws Exception {
		if(pictrue!=null){
			Random r = new Random();
			int i = r.nextInt();
			int index = pictrueFileName.lastIndexOf(".") ;//�õ�.��λ��
			String extendName = pictrueFileName.substring(index, pictrueFileName.length());//����ļ�������
			String filename=i+extendName;//ƴ���µ��ļ���
			student.setPictrue("upload/" +filename) ;
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream(getPictrue());
			FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"+ filename);
			int length = fis.read(buffer);
			while (length > 0) {
				fos.write(buffer, 0, length);
				length = fis.read(buffer);
			}
			fis.close();
			fos.flush();
			fos.close();
		}
		String absPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
		int count=dao.updateStudent(student, absPath);
		if(count>0){
			return SUCCESS;
		}else{
		   return INPUT;
		}
	}
}
