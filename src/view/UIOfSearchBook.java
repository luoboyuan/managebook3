package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIOfSearchBook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOfSearchBook frame = new UIOfSearchBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIOfSearchBook() {
		setTitle("查找界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton seachByID = new JButton("根据书籍编号查找");
		seachByID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfSearchById seekId=new UIOfSearchById();
				seekId.setVisible(true);
				UIOfSearchBook.this.dispose();
			}
		});
		seachByID.setBounds(120, 62, 164, 23);
		contentPane.add(seachByID);
		
		JButton searchByName = new JButton("根据书籍名字查找");
		searchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfSearchByName seekName=new UIOfSearchByName();
				seekName.setVisible(true);
				UIOfSearchBook.this.dispose();
			}
		});
		searchByName.setBounds(120, 108, 164, 23);
		contentPane.add(searchByName);
		
		JButton seachByAuthor = new JButton("根据书籍作者查找");
		seachByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfSearchByAuthor seekAuthor=new UIOfSearchByAuthor();
				seekAuthor.setVisible(true);
				UIOfSearchBook.this.dispose();
			}
		});
		seachByAuthor.setBounds(120, 152, 164, 23);
		contentPane.add(seachByAuthor);
		
		JPanel panel = new JPanel();
		panel.setBounds(168, 75, 10, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(168, 108, 10, 10);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(153, 165, 10, 10);
		contentPane.add(panel_2);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIOfMenu returnMain=new UIOfMenu();
				returnMain.setVisible(true);
				UIOfSearchBook.this.dispose();
			}
		});
		button_1.setBounds(168, 228, 93, 23);
		contentPane.add(button_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(209, 241, 10, 10);
		contentPane.add(panel_4);
	}
}
