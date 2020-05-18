package cn.jbit.com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.jbit.com.dao.BaseDao;


public class InsertStudent {
	public static void main(String[] args)  {
		//2.得到connection对象
		Connection conn = null;
		//4.得到statement对象，
		Statement state = null;
		try {
			
			conn = BaseDao.getConnection();
			//3.得到sql语句
			String sqlInsertStudent = "insert into student (id, name,sex,age,address) values(178,'苏家荣','女','18','广西')";
			state = conn.createStatement();
			//5.用statement对象执行sql语句，把结果放到resultset对象里面
			int row = state.executeUpdate(sqlInsertStudent);
			//6.遍历结果集（resultset）
			if (row>0) {
				System.out.println("插入成功！");
			} else {
				System.out.println("插入失败！");
			}
		} catch (SQLException e) {
			System.out.println("发生执行sql语句异常，所以插入失败");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("不知道的异常，所以插入失败");
			e.printStackTrace();
		}finally{
			BaseDao.closeJdbc(null, state, conn);
		}
		
		System.out.println("程序没有死掉！可以继续跑，");
		
		 
		
		 
	}
}
