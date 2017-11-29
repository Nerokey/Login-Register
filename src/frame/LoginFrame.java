package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UsersDao;
import entity.Users;

/**
 * ��¼����
 * @author Nerokey
 *
 */
public class LoginFrame extends MyFrame {

	private static String title = "��¼";
	private static final int width = 360;
	private static final int height = 180;
	private static String uname="";
	private static String upass="";
	private static JTextField user_text = new JTextField();
	private static JPasswordField pass_text = new JPasswordField();
	
	public LoginFrame() {
		super(title);
		
		int x =(int) this.getToolkit().getScreenSize().getWidth();
		int y =(int) this.getToolkit().getScreenSize().getHeight();
		
		this.setSize(width, height);
		this.setLocation(x/2-height/2, y/2-width/2);
		
		JPanel main = new JPanel(new BorderLayout());
		JPanel title_pan = new JPanel();
		JLabel title = new JLabel("�û���¼");
		title.setFont(new Font("����",Font.BOLD,20));
		title_pan.add(title);
		
		JPanel content = new JPanel(new GridLayout(2,1));
		JPanel user_pan = new JPanel();
		JLabel username = new JLabel("�û�����");
		username.setFont(new Font("����",Font.BOLD,15));
		user_text.setColumns(15);
		user_pan.add(username);
		user_pan.add(user_text);
		
		JPanel pass_pan = new JPanel();
		JLabel password = new JLabel("��  �룺");
		password.setFont(new Font("����",Font.BOLD,15));
		pass_text.setColumns(15);
		pass_pan.add(password);
		pass_pan.add(pass_text);
		
		content.add(user_pan);
		content.add(pass_pan);
		
		JPanel btn_pan = new JPanel();
		JButton login_btn = new JButton("��¼");
		JButton cancel_btn = new JButton("ȡ��");
		btn_pan.add(login_btn);
		btn_pan.add(cancel_btn);
		
		login_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//��������û���������֤
				uname = user_text.getText();
				upass = new String(pass_text.getPassword());
				Users u = new Users(uname,upass);
				UsersDao dao = new UsersDao();
				if(dao.checkData(u)){
					MainFrame frame = new MainFrame();
					LoginFrame.this.setVisible(false);  //��¼�ɹ��Ͱѵ�¼��������
				}
				else{
					JOptionPane.showMessageDialog(null, "�û������������", "��ʾ��Ϣ", JOptionPane.CLOSED_OPTION);
				}
			}
		});
		cancel_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ȡ����ť��ֱ���˳�����
				System.exit(0);
			}
		});
		
		main.add(title_pan,BorderLayout.NORTH);
		main.add(content,BorderLayout.CENTER);
		main.add(btn_pan,BorderLayout.SOUTH);
		
		this.add(main);
		this.setVisible(true);
	}
}
