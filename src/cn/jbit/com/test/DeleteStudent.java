package cn.jbit.com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteStudent {
	public static void main(String[] args)  {
		//2.�õ�connection����
		Connection conn = null;
		//4.�õ�statement����
		Statement state = null;
		try {
			//1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","zmb","123");
			//3.�õ�sql���
			String deleteStudentById = "delete student where id = 2";
			state = conn.createStatement();
			//5.��statement����ִ��sql��䣬�ѽ���ŵ�resultset��������
			int row = state.executeUpdate(deleteStudentById);
			if (row>0) {
				System.out.println("ɾ���ɹ���");
			} else {
				System.out.println("ɾ��ʧ�ܣ�");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ResultSet  rs = state.executeQuery(sqlAllStudent);
		//6.�����������resultset��
		 
		try {
			//7.�ر���Դ
			 //rs.close();
			 state.close();
			 conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
