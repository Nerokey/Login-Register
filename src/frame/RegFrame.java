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
 * ע�ᴰ��
 * @author Nerokey
 *
 */
public class RegFrame extends JFrame {

	private String title = "ע��";
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
		JLabel title = new JLabel("�û�ע��");
		title.setFont(new Font("����",Font.BOLD,20));
		title_pan.add(title);
		
		JPanel content = new JPanel(new GridLayout(3,1));
		JPanel user_pan = new JPanel();
		JLabel username = new JLabel("�� �� ����");
		username.setFont(new Font("����",Font.BOLD,15));
		user_text.setColumns(15);
		user_pan.add(username);
		user_pan.add(user_text);
		
		JPanel pass_pan = new JPanel();
		JLabel password = new JLabel("��    �룺");
		password.setFont(new Font("����",Font.BOLD,15));
		pass_text.setColumns(15);
		pass_pan.add(password);
		pass_pan.add(pass_text);
		
		JPanel repass_pan = new JPanel();
		JLabel repassword = new JLabel("ȷ�����룺");
		repassword.setFont(new Font("����",Font.BOLD,15));
		repass_text.setColumns(15);
		repass_pan.add(repassword);
		repass_pan.add(repass_text);
		
		content.add(user_pan);
		content.add(pass_pan);
		content.add(repass_pan);
		
		JPanel btn_pan = new JPanel();
		JButton reg_btn = new JButton("ע��");
		JButton cancel_btn = new JButton("ȡ��");
		btn_pan.add(reg_btn);
		btn_pan.add(cancel_btn);
		
		reg_btn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//ע�ᰴť
				uname = user_text.getText();
				upass = new String(pass_text.getPassword());
				repass = new String(repass_text.getPassword());
				if(uname.equals("")){
					//�û���Ϊ�յ����
					JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�", "��ʾ��Ϣ", JOptionPane.CLOSED_OPTION);
					user_text.grabFocus();
					return;
				}
				else if(upass.equals("")){
					//����Ϊ�յ����
					JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "��ʾ��Ϣ", JOptionPane.CLOSED_OPTION);
					pass_text.grabFocus();
					return;
				}
				else if(!upass.equals(repass)){
					//�ж���������һ��һ��
					JOptionPane.showMessageDialog(null, "�����������벻һ�£�", "��ʾ��Ϣ", JOptionPane.CLOSED_OPTION);
					repass_text.grabFocus();
					return;
				}
				Users u = new Users(uname,upass);
				UsersDao dao = new UsersDao();
				if(dao.addData(u)){
					//�������true��ע��ɹ�
					JOptionPane.showMessageDialog(null, "ע��ɹ���", "��ʾ��Ϣ", JOptionPane.CLOSED_OPTION);
				}
				else{
					JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�", "��ʾ��Ϣ", JOptionPane.CLOSED_OPTION);
				}
				RegFrame.this.dispose();   //ע��ɹ���ע�ᴰ������
			}
		});
		cancel_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ȡ����ť��ʹ������ʧ
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
