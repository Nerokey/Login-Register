package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接类
 * 体现了单例模式 ，即程序中只存在一份对象。节约资源
 * @author Nerokey
 *
 */
public class DBHelper {

	private static Connection con = null;
	//数据库的url地址；?useUnicode=true&characterEncoding=utf-8解决数据库中文乱码问题
	private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	//驱动的完整包名
	private static String driver = "com.mysql.jdbc.Driver";
	//数据库的用户名
	private static String user = "root";
	//数据库的用户名密码
	private static String password = "";
	
	static{
		try {
			Class.forName(driver);  //使用Class.forName()加载驱动
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//构造方法私有化，安全
	private DBHelper(){
		
	}
	
	//只对外提供这一个方法，确保单例，同时封装性更好
	public static Connection getConnect(){
		return con;
	}
}