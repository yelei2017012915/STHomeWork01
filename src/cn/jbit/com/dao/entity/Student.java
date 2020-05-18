package cn.jbit.com.dao.entity;
/*	就是一个JavaBean
 *  JavaBean的作用：用于封装数据库里面的数据
 *  JavaBean规范：
 *  规范1: 数据库里面的字段，对应着实体类中的属性
 *  规范2: 该类必须有一个无参数的构造方法和有参数的构造方法
 * 	规范3: 给每个属性生成get set 方法
 */
public class Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String address;
	private String pictrue;

	public Student(String pictrue) {
		super();
		this.pictrue = pictrue;
	}
	public String getPictrue() {
		return pictrue;
	}
	public void setPictrue(String pictrue) {
		this.pictrue = pictrue;
	}
	public Student() {
		super();
	}

	public Student(int id, String name, String sex, int age, String address,
			String pictrue) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.pictrue = pictrue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
