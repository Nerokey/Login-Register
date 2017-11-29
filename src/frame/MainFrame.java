package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 用户主界面
 * @author Nerokey
 *
 */
public class MainFrame extends MyFrame {

	private static String title = "用户管理程序";
	private static final int width = 600;
	private static final int height = 500;
	
	MainFrame() {
		super(title);
		
		int x =(int) this.getToolkit().getScreenSize().getWidth();
		int y =(int) this.getToolkit().getScreenSize().getHeight();
		
		this.setSize(width, height);
		this.setLocation(x/2-height/2, y/2-width/2);
		
		JMenuBar bar = new JMenuBar();
		JMenu new_item = new JMenu("新建");
		JMenuItem open = new JMenuItem("打开");
		JMenuItem reg = new JMenuItem("注册");
		JMenuItem exit = new JMenuItem("退出");
		new_item.add(open);
		new_item.add(reg);
		new_item.addSeparator();
		new_item.add(exit);
		reg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//弹出注册窗口
				RegFrame reg = new RegFrame();
			}
		});
		exit.addActionListener(new ActionListener() {
			//退出
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
