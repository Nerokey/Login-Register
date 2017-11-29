package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UsersDao;
import entity.Users;

/**
 * 注册窗口
 * @author Nerokey
 *
 */
public class RegFrame extends JFrame {

	private String title = "注册";
	private static final int width = 360;
	private static final int height = 210;
	private static String uname="";
	private static String upass="";
	private static String repass="";
	private static JTextField user_text = new JTextField();
	private static JPasswordField pass_text = new JPasswordField();
	private static JPasswordField repass_text = new JPasswordField();
	
	RegFrame(){
		this.setTitle(title);
		
		int x =(int) this.getToolkit().getScreenSize().getWidth();
		int y =(int) this.getToolkit().getScreenSize().getHeight();
		
		this.setSize(width, height);
		this.setLocation(x/2-height/2, y/2-width/2);
		this.setResizable(false);
		
		JPanel main = new JPanel(new BorderLayout());
		JPanel title_pan = new JPanel();
		JLabel title = new JLabel("用户注册");
		title.setFont(new Font("隶书",Font.BOLD,20));
		title_pan.add(title);
		
		JPanel content = new JPanel(new GridLayout(3,1));
		JPanel user_pan = new JPanel();
		JLabel username = new JLabel("用 户 名：");
		username.setFont(new Font("宋体",Font.BOLD,15));
		user_text.setColumns(15);
		user_pan.add(username);
		user_pan.add(user_text);
		
		JPanel pass_pan = new JPanel();
		JLabel password = new JLabel("密    码：");
		password.setFont(new Font("宋体",Font.BOLD,15));
		pass_text.setColumns(15);
		pass_pan.add(password);
		pass_pan.add(pass_text);
		
		JPanel repass_pan = new JPanel();
		JLabel repassword = new JLabel("确认密码：");
		repassword.setFont(new Font("宋体",Font.BOLD,15));
		repass_text.setColumns(15);
		repass_pan.add(repassword);
		repass_pan.add(repass_text);
		
		content.add(user_pan);
		content.add(pass_pan);
		content.add(repass_pan);
		
		JPanel btn_pan = new JPanel();
		JButton reg_btn = new JButton("注册");
		JButton cancel_btn = new JButton("取消");
		btn_pan.add(reg_btn);
		btn_pan.add(cancel_btn);
		
		reg_btn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//注册按钮
				uname = user_text.getText();
				upass = new String(pass_text.getPassword());
				repass = new String(repass_text.getPassword());
				if(uname.equals("")){
					//用户名为空的情况
					JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示信息", JOptionPane.CLOSED_OPTION);
					user_text.grabFocus();
					return;
				}
				else if(upass.equals("")){
					//密码为空的情况
					JOptionPane.showMessageDialog(null, "密码不能为空！", "提示信息", JOptionPane.CLOSED_OPTION);
					pass_text.grabFocus();
					return;
				}
				else if(!upass.equals(repass)){
					//判断两次密码一不一致
					JOptionPane.showMessageDialog(null, "两次输入密码不一致！", "提示信息", JOptionPane.CLOSED_OPTION);
					repass_text.grabFocus();
					return;
				}
				Users u = new Users(uname,upass);
				UsersDao dao = new UsersDao();
				if(dao.addData(u)){
					//如果返回true则注册成功
					JOptionPane.showMessageDialog(null, "注册成功！", "提示信息", JOptionPane.CLOSED_OPTION);
				}
				else{
					JOptionPane.showMessageDialog(null, "注册失败！", "提示信息", JOptionPane.CLOSED_OPTION);
				}
				RegFrame.this.dispose();   //注册成功后将注册窗口隐藏
			}
		});
		cancel_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//取消按钮，使窗口消失
				RegFrame.this.dispose();
			}
		});
		
		main.add(title_pan,BorderLayout.NORTH);
		main.add(content,BorderLayout.CENTER);
		main.add(btn_pan,BorderLayout.SOUTH);
		
		this.add(main);
		this.setVisible(true);
	}
	
}
