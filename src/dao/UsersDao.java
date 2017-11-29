package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Users;
import util.DBHelper;

/*
 * �û�dao��
 * ��������ݿ�Ĳ�������
 */
public class UsersDao {

	Connection con = DBHelper.getConnect();
	
	//����û�����
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
	
	//����û������������ȷ��
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
