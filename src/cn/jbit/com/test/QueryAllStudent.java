package cn.jbit.com.test;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.jbit.com.dao.BaseDao;


public class QueryAllStudent {
	public static void main(String[] args)  {
		//2.�õ�connection����
		Connection conn = null;
		//4.�õ�statement����
		Statement state = null;
		//5.��statement����ִ��sql��䣬�ѽ���ŵ�resultset��������
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			//3.�õ�sql���
			String sqlAllStudent = "select id, name,sex,age,address,pictrue  from STUDENT ";
			state = conn.createStatement();
			rs = state.executeQuery(sqlAllStudent);
			//6.�����������resultset��
			 System.out.println("���\t����\t�Ա�\t����\t��ַ");
			 while (rs.next()) {
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 String sex = rs.getString("sex");
				 int age = rs.getInt("age");
				 String address = rs.getString("address");
				 String pictrue = rs.getString("pictrue");
				 System.out.println(id+"\t"+name+"\t"+sex+"\t"+age+"\t"+address);
			}
		} catch (SQLException e) {
			System.out.println("����ִ��sql����쳣�����Բ�ѯʧ��");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��֪���쳣�����Բ�ѯʧ��");
			e.printStackTrace();
		}finally{
			BaseDao.closeJdbc(rs, state, conn);
		}
		
		 
	}
}
