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
			//�ж��Ƿ���multipart������
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart){
			//FileItem�Ĺ���
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				try{
					@SuppressWarnings("unchecked")//ע��
					List<FileItem> items = upload.parseRequest(request);
					//���������xx 
					Random r = new Random();
					int i = r.nextInt();
					
					for(FileItem item:items ){
						boolean isFormField = item.isFormField();
						if(isFormField){//��ͨ���ֶ�
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
							/*�����ϴ��ļ��ֶ��е��ļ������ļ���ͨ���ǲ���·����Ϣ�ģ�
							ȡ���������ʵ�� D:/left.jpg ��Щ������õ����ǣ�left.jpg 
							*/
							String fileName = item.getName();
							//�õ���չ����.jsp��
							int index = fileName.lastIndexOf(".") ;//�õ�.��λ��
							String extendName = fileName.substring(index, fileName.length());
							//�ϴ��ļ������������������ΪΨһ������(234723.jsp)
							String uploadName = i+extendName;
							pictrue="upload/"+uploadName;
							if(fileName!=null&&!fileName.equals("")){
								//�õ�����������ļ��ĸ�Ŀ¼�����磺(C:\apache-tomcat-6.0.13\webapps\fileupload\\upload)
								String uploadFilePath = request.getSession().getServletContext().getRealPath("/upload/" );
								//���ݿⱣ��ͼƬ��·����uploadFilePath+uploadName
								File saveFile = new File(uploadFilePath,uploadName);
								item.write(saveFile);
								PrintWriter out=response.getWriter();
								out.print("�ϴ��ļ��ɹ�����ļ�ԭ�����ǣ�"+fileName+"���浽�������������ǣ�"+uploadName);
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
		    	//�������ѧ����Ϣ��ǰ�˾���һ��ע�Ṧ��
				IstudentDao sDao = new StudentDaoImpl();
				Student student = new Student();
				student.setName(name);
				student.setSex(sex);
				//���ַ���ת��Ϊint ����
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
