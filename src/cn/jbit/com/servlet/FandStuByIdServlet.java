package cn.jbit.com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.com.dao.BaseDao;
import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.entity.Student;
import cn.jbit.com.dao.impl.StudentDaoImpl;

public class FandStuByIdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException, IOException {
		String strId=request.getParameter("id");
		int id=Integer.parseInt(strId);
		IstudentDao iDao=new StudentDaoImpl();
		Student student=iDao.fandStuById(id);
		if (student!=null) {
			//把student放在session里面
			request.getSession().setAttribute("student", student);
			response.sendRedirect("update.jsp");
		}
	}	
}
