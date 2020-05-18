package cn.jbit.com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.jbit.com.dao.IstudentDao;
import cn.jbit.com.dao.entity.Student;
import cn.jbit.com.dao.impl.StudentDaoImpl;



@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		    String name = "";
		    String sex ="";
		    String ageStr = "";
		    String address = "";
		    String pictrue = "";
			//判断是否是multipart的类型
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart){
			//FileItem的工厂
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				try{
					@SuppressWarnings("unchecked")//注解
					List<FileItem> items = upload.parseRequest(request);
					//生成随机数xx 
					Random r = new Random();
					int i = r.nextInt();
					
					for(FileItem item:items ){
						boolean isFormField = item.isFormField();
						if(isFormField){//普通表单字段
							String fieldName = item.getFieldName();
							
							if(fieldName.equals("name")){
								name = item.getString("utf-8");
							}
							if(fieldName.equals("sex")){
								sex = item.getString("utf-8");
							}
							if(fieldName.equals("age")){
								 ageStr= item.getString("utf-8");
							}
							if(fieldName.equals("address")){
								address = item.getString("utf-8");
							}
						}else{
							/*返回上传文件字段中的文件名，文件名通常是不含路径信息的，
							取决于浏览器实现 D:/left.jpg 有些浏览器得到的是：left.jpg 
							*/
							String fileName = item.getName();
							//得到扩展名（.jsp）
							int index = fileName.lastIndexOf(".") ;//得到.的位置
							String extendName = fileName.substring(index, fileName.length());
							//上传文件到服务器后的重命名为唯一的名字(234723.jsp)
							String uploadName = i+extendName;
							pictrue="upload/"+uploadName;
							if(fileName!=null&&!fileName.equals("")){
								//得到服务器存放文件的根目录，比如：(C:\apache-tomcat-6.0.13\webapps\fileupload\\upload)
								String uploadFilePath = request.getSession().getServletContext().getRealPath("/upload/" );
								//数据库保存图片的路径：uploadFilePath+uploadName
								File saveFile = new File(uploadFilePath,uploadName);
								item.write(saveFile);
								PrintWriter out=response.getWriter();
								out.print("上传文件成功后的文件原来名是："+fileName+"保存到服务器的名字是："+uploadName);
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		    	//String name = request.getParameter("name");
		    	//String sex = request.getParameter("sex");
		    	//String ageStr = request.getParameter("age");
		    	//String address = request.getParameter("address");
		    	//测试添加学生信息，前端就是一个注册功能
				IstudentDao sDao = new StudentDaoImpl();
				Student student = new Student();
				student.setName(name);
				student.setSex(sex);
				//把字符串转换为int 类型
				int age = Integer.valueOf(ageStr);
				student.setAge(age);
				student.setAddress(address);
				student.setPictrue(pictrue);
				int i = sDao.addStudent(student);
				if (i==0) {
					response.sendRedirect("register.jsp");
				
				} else {
					HttpSession session=(HttpSession)request.getSession();
					session.invalidate();
					response.sendRedirect("PageServlet");
				}
	}
}
