package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * �û�������
 * @author Nerokey
 *
 */
public class MainFrame extends MyFrame {

	private static String title = "�û��������";
	private static final int width = 600;
	private static final int height = 500;
	
	MainFrame() {
		super(title);
		
		int x =(int) this.getToolkit().getScreenSize().getWidth();
		int y =(int) this.getToolkit().getScreenSize().getHeight();
		
		this.setSize(width, height);
		this.setLocation(x/2-height/2, y/2-width/2);
		
		JMenuBar bar = new JMenuBar();
		JMenu new_item = new JMenu("�½�");
		JMenuItem open = new JMenuItem("��");
		JMenuItem reg = new JMenuItem("ע��");
		JMenuItem exit = new JMenuItem("�˳�");
		new_item.add(open);
		new_item.add(reg);
		new_item.addSeparator();
		new_item.add(exit);
		reg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ע�ᴰ��
				RegFrame reg = new RegFrame();
			}
		});
		exit.addActionListener(new ActionListener() {
			//�˳�
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bar.add(new_item);
		this.add(bar,BorderLayout.NORTH);
		this.setVisible(true);
	}

}
