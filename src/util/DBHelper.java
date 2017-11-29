package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ�������
 * �����˵���ģʽ ����������ֻ����һ�ݶ��󡣽�Լ��Դ
 * @author Nerokey
 *
 */
public class DBHelper {

	private static Connection con = null;
	//���ݿ��url��ַ��?useUnicode=true&characterEncoding=utf-8������ݿ�������������
	private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	//��������������
	private static String driver = "com.mysql.jdbc.Driver";
	//���ݿ���û���
	private static String user = "root";
	//���ݿ���û�������
	private static String password = "";
	
	static{
		try {
			Class.forName(driver);  //ʹ��Class.forName()��������
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//���췽��˽�л�����ȫ
	private DBHelper(){
		
	}
	
	//ֻ�����ṩ��һ��������ȷ��������ͬʱ��װ�Ը���
	public static Connection getConnect(){
		return con;
	}
}