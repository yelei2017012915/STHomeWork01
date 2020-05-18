package cn.jbit.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.entity.Student;
import cn.jbit.com.dao.impl.StudentDaoImpl;
import cn.jbit.com.util.Page;

public class PageServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currentPageStr =  request.getParameter("currentPage");
  		if(currentPageStr==null){
  			currentPageStr = "1";
  		}
  		IstudentDao sDao = new StudentDaoImpl();
  		//pageStu ����һ��������װ��ҳ�õ����в���
		Page<Student> pageStu = new Page<Student>();
		int totalCount = sDao.getTotalCount();
		int pageSize = 5;//�ֹ���ֵ
		int currentPage = Integer.valueOf(currentPageStr);
		List<Student> students = sDao.getPageStudents(pageSize, currentPage);
		//������װ�������ҳ�Ŀ�����
		pageStu.setCurrentPage(currentPage);
		pageStu.setList(students);
		pageStu.setPageSize(pageSize);
		pageStu.setTotalCount(totalCount);
		HttpSession  session=(HttpSession)request.getSession();
		session.setAttribute("pageStu", pageStu);
		//ת����showpage.jspҳ����
		response.sendRedirect("jstlpage.jsp");
	}

}
