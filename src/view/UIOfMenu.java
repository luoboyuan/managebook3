package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class UIOfMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Client client=new Client();
		client.ClientConnectionServer();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOfMenu frame = new UIOfMenu();
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
	public UIOfMenu() {
		setTitle("图书管理界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addBook = new JButton("添加图书");
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfAddBook add_book=new UIOfAddBook();	
				add_book.setVisible(true);
				 UIOfMenu.this.dispose();
			}
		});
		addBook.setBounds(0, 0, 119, 53);
		contentPane.add(addBook);
		
		JButton deleteBook = new JButton("删除图书");
		deleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfDeleteBook delete_book=new UIOfDeleteBook();
				delete_book.setVisible(true);
				UIOfMenu.this.dispose();
			}
		});
		deleteBook.setBounds(0, 99, 119, 53);
		contentPane.add(deleteBook);
		
		JButton updateBook = new JButton("修改图书");
		updateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfUpdateBook update_book=new UIOfUpdateBook();
				update_book.setVisible(true);
				UIOfMenu.this.dispose();
			}
		});
		updateBook.setBounds(315, 0, 119, 53);
		contentPane.add(updateBook);
		
		JButton seekBook = new JButton("查找图书");
		seekBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfSearchBook seek_book=new UIOfSearchBook();
				seek_book.setVisible(true);
				UIOfMenu.this.dispose();
			}
		});
		seekBook.setBounds(315, 99, 119, 53);
		contentPane.add(seekBook);
		
		JButton exitSystem = new JButton("退出");
		exitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client =new Client();
				client.closeConnectin("bye");
				System.exit(0);
			}
		});
		exitSystem.setBounds(165, 208, 114, 53);
		contentPane.add(exitSystem);
		
		JPanel addPanel = new JPanel();
		addPanel.setBounds(39, 27, 10, 10);
		contentPane.add(addPanel);
		
		JPanel updatePanel = new JPanel();
		updatePanel.setBounds(379, 27, 10, 10);
		contentPane.add(updatePanel);
		
		JPanel deletePanel = new JPanel();
		deletePanel.setBounds(57, 117, 10, 10);
		contentPane.add(deletePanel);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(379, 127, 10, 10);
		contentPane.add(searchPanel);
		
		
	}
}
