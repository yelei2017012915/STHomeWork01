package cn.jbit.com.test;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.jbit.com.dao.BaseDao;


public class QueryAllStudent {
	public static void main(String[] args)  {
		//2.得到connection对象
		Connection conn = null;
		//4.得到statement对象，
		Statement state = null;
		//5.用statement对象执行sql语句，把结果放到resultset对象里面
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			//3.得到sql语句
			String sqlAllStudent = "select id, name,sex,age,address,pictrue  from STUDENT ";
			state = conn.createStatement();
			rs = state.executeQuery(sqlAllStudent);
			//6.遍历结果集（resultset）
			 System.out.println("编号\t姓名\t性别\t年龄\t地址");
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
			System.out.println("发生执行sql语句异常，所以查询失败");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("不知名异常，所以查询失败");
			e.printStackTrace();
		}finally{
			BaseDao.closeJdbc(rs, state, conn);
		}
		
		 
	}
}
