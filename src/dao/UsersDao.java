package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Users;
import util.DBHelper;

/*
 * 用户dao层
 * 定义对数据库的操作方法
 */
public class UsersDao {

	Connection con = DBHelper.getConnect();
	
	//添加用户方法
	public boolean addData(Users u){
		
		try {
			String sql = "insert into users (username,password) values (?,?);";
			PreparedStatement temt = con.prepareStatement(sql);
			temt.setString(1, u.getUsername());
			temt.setString(2, u.getPassword());
			int result = temt.executeUpdate();
			if(result > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//检查用户名和密码的正确性
	public boolean checkData(Users u){
		try{
			String sql = "select * from users where username=? and password=?;";
			PreparedStatement temt = con.prepareStatement(sql);
			temt.setString(1, u.getUsername().trim());
			temt.setString(2, u.getPassword().trim());
			ResultSet rs = temt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
