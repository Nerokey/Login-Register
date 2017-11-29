package frame;

import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 程序界面的父类
 * @author Nerokey
 *
 */
public class MyFrame extends JFrame {
	
	MyFrame(String title){
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
