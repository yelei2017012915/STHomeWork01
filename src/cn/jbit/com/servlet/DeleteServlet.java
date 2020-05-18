package cn.jbit.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.impl.StudentDaoImpl;

public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId=request.getParameter("id");
		int id=Integer.parseInt(strId);
		IstudentDao iDao=new StudentDaoImpl();
		//在这里找到 D:/apache-tomcat-7.0.56/webapps/studentmanager/
		String absPath =   request.getSession().getServletContext().getRealPath("/" );
		int r=iDao.deleteStuById(id, absPath);
		if (r>0) {
			//清空session
			HttpSession   session=(HttpSession)request.getSession();
			session.invalidate();
			response.sendRedirect("PageServlet");
		}
	}
}
