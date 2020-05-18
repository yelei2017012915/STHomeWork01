package cn.jbit.com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.jbit.com.dao.BaseDao;


public class InsertStudent {
	public static void main(String[] args)  {
		//2.�õ�connection����
		Connection conn = null;
		//4.�õ�statement����
		Statement state = null;
		try {
			
			conn = BaseDao.getConnection();
			//3.�õ�sql���
			String sqlInsertStudent = "insert into student (id, name,sex,age,address) values(178,'�ռ���','Ů','18','����')";
			state = conn.createStatement();
			//5.��statement����ִ��sql��䣬�ѽ���ŵ�resultset��������
			int row = state.executeUpdate(sqlInsertStudent);
			//6.�����������resultset��
			if (row>0) {
				System.out.println("����ɹ���");
			} else {
				System.out.println("����ʧ�ܣ�");
			}
		} catch (SQLException e) {
			System.out.println("����ִ��sql����쳣�����Բ���ʧ��");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("��֪�����쳣�����Բ���ʧ��");
			e.printStackTrace();
		}finally{
			BaseDao.closeJdbc(null, state, conn);
		}
		
		System.out.println("����û�����������Լ����ܣ�");
		
		 
		
		 
	}
}
