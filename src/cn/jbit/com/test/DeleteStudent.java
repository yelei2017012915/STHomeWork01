package cn.jbit.com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteStudent {
	public static void main(String[] args)  {
		//2.得到connection对象
		Connection conn = null;
		//4.得到statement对象，
		Statement state = null;
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","zmb","123");
			//3.得到sql语句
			String deleteStudentById = "delete student where id = 2";
			state = conn.createStatement();
			//5.用statement对象执行sql语句，把结果放到resultset对象里面
			int row = state.executeUpdate(deleteStudentById);
			if (row>0) {
				System.out.println("删除成功！");
			} else {
				System.out.println("删除失败！");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ResultSet  rs = state.executeQuery(sqlAllStudent);
		//6.遍历结果集（resultset）
		 
		try {
			//7.关闭资源
			 //rs.close();
			 state.close();
			 conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
