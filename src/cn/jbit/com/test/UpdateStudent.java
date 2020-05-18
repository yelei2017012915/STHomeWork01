package cn.jbit.com.test;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;


public class UpdateStudent {
	public static void main(String[] args) throws Exception {
		//1.加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.得到connection对象
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","zmb","123");
		//3.得到sql语句
		String updateStudentById = "update student set sex='女'，age=90 where id=5";
		//4.得到statement对象，
		Statement state = conn.createStatement();
		//5.用statement对象执行sql语句，把结果放到resultset对象里面
		int row = state.executeUpdate(updateStudentById);
		if (row>0) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败！");
		}
		// ResultSet  rs = state.executeQuery(sqlAllStudent);
		//6.遍历结果集（resultset）
		 
		//7.关闭资源
		 //rs.close();
		 state.close();
		 conn.close();
	}
}	 