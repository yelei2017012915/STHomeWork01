package cn.jbit.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	/**
	 * 得到数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//1.加载驱动
			//底层就是用反射机制来实现的
			//cn.jbit.com.servlet.FandStuByIdServlet
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","qq","123");
		} catch (ClassNotFoundException e) {
			System.out.println("发生没有发现驱动类的异常，所以查询失败");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("不知名异常，所以查询失败");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeJdbc(ResultSet rs, Statement state,Connection conn) {
		try {
			//7.关闭资源
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
			System.out.println("关闭资源时发出异常！");
			e.printStackTrace();
		}
	}
	
}
