package cn.jbit.com.test;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;


public class UpdateStudent {
	public static void main(String[] args) throws Exception {
		//1.��������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.�õ�connection����
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","zmb","123");
		//3.�õ�sql���
		String updateStudentById = "update student set sex='Ů'��age=90 where id=5";
		//4.�õ�statement����
		Statement state = conn.createStatement();
		//5.��statement����ִ��sql��䣬�ѽ���ŵ�resultset��������
		int row = state.executeUpdate(updateStudentById);
		if (row>0) {
			System.out.println("�޸ĳɹ���");
		} else {
			System.out.println("�޸�ʧ�ܣ�");
		}
		// ResultSet  rs = state.executeQuery(sqlAllStudent);
		//6.�����������resultset��
		 
		//7.�ر���Դ
		 //rs.close();
		 state.close();
		 conn.close();
	}
}	 