package entity;

/**
 * �û�ʵ����
 * �����ݿ��еı��Ӧ
 * @author Nerokey
 *
 */
public class Users {

	private int uid;  //�û����
	private String username;  //�û���
	private String password;  //�û�����
	
	public Users(){
		
	}
	public Users(String username, String password){
		this.username = username;
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
