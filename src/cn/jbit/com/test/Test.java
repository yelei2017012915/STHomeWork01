package cn.jbit.com.test;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File file = new File("D:/apache-tomcat-7.0.56/webapps/studentmanager/upload/1356484525.jpg");
		file.delete();
	}
}
