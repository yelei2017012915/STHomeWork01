package cn.jbit.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	/**
	 * �õ����ݿ�����
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//1.��������
			//�ײ�����÷��������ʵ�ֵ�
			//cn.jbit.com.servlet.FandStuByIdServlet
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","qq","123");
		} catch (ClassNotFoundException e) {
			System.out.println("����û�з�����������쳣�����Բ�ѯʧ��");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��֪���쳣�����Բ�ѯʧ��");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeJdbc(ResultSet rs, Statement state,Connection conn) {
		try {
			//7.�ر���Դ
			if (rs!=null) {
				rs.close();
			}
			if (state!=null) {
				 state.close();
			}
			if (conn!=null) {
				 conn.close();
			}
		} catch (Exception e) {
			System.out.println("�ر���Դʱ�����쳣��");
			e.printStackTrace();
		}
	}
	
}
