package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Book;
import model.BookList;
import model.ReturnResult;
import net.Client;
import operator.Operator;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class UIOfAddBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookID_1;
	private JTextField bookName_1;
	private JTextField bookAuthor_1;
	private JTextField bookPrice_1;
	private JPanel panel;
	private JButton button;
	private JPanel panel_1;
	private JLabel promptID;
	private JLabel promptName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOfAddBook frame = new UIOfAddBook();
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
	public UIOfAddBook() {
		setTitle("增加图书系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bookID_1 = new JTextField();
		bookID_1.setToolTipText("");
		bookID_1.setBounds(188, 24, 145, 34);
		contentPane.add(bookID_1);
		bookID_1.setColumns(10);
		
		bookName_1 = new JTextField();
		bookName_1.setToolTipText("");
		bookName_1.setBounds(188, 68, 145, 34);
		contentPane.add(bookName_1);
		bookName_1.setColumns(10);
		
		bookAuthor_1 = new JTextField();
		bookAuthor_1.setToolTipText("");
		bookAuthor_1.setBounds(188, 112, 145, 33);
		contentPane.add(bookAuthor_1);
		bookAuthor_1.setColumns(10);
		
		bookPrice_1 = new JTextField();
		bookPrice_1.setToolTipText("");
		bookPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		bookPrice_1.setBounds(188, 155, 145, 34);
		contentPane.add(bookPrice_1);
		bookPrice_1.setColumns(10);
		
		JButton YES = new JButton("确定");
		YES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    	if(bookID_1.getText().equals("")||bookName_1.getText().equals(""))
			    	{
			    		if(bookID_1.getText().equals("")){promptID.setText("不能为空");}
			    		if(bookName_1.getText().equals("")){promptName.setText("不能为空");}
			    	}
			    	else{
			    		String BookID=bookID_1.getText(),BookName=bookName_1.getText(),BookAuthor=bookAuthor_1.getText(),bookPriceTemp=bookPrice_1.getText();
			    		if(bookAuthor_1.getText().equals("")){BookAuthor=null;}
			    		if(bookPrice_1.getText().equals("")){bookPriceTemp="0 ";}
			    		float BookPrice=Float.valueOf(bookPriceTemp);
			    		Book book=new Book(BookID,BookName,BookAuthor,BookPrice);
			    		Operator operator =new Operator();
			    		ReturnResult returnResult=operator.addBook(book);
			    		if(returnResult.isSuccess){
			    			String information=(String)returnResult.returnData;
			    			UIOfResult showResult =new UIOfResult(information);
			    			showResult.setVisible(true);
			    			UIOfAddBook.this.dispose();
			    		}
			    else{
			    	UIOfResult showResult =new UIOfResult(returnResult.failreason);
			    	showResult.setVisible(true);
			    	UIOfAddBook.this.dispose();
			    }
			   }
			}
		});
		YES.setBounds(42, 214, 118, 37);
		contentPane.add(YES);
		
		panel = new JPanel();
		panel.setBounds(123, 227, 10, 10);
		contentPane.add(panel);
		
		JLabel bookID = new JLabel("书籍编号");
		bookID.setBounds(134, 23, 125, 34);
		contentPane.add(bookID);
		
		JLabel bookName = new JLabel("书籍名字");
		bookName.setBounds(134, 68, 54, 34);
		contentPane.add(bookName);
		
		JLabel bookAuthor = new JLabel("书籍作者");
		bookAuthor.setBounds(130, 114, 48, 28);
		contentPane.add(bookAuthor);
		
		JLabel label = new JLabel("书籍价格");
		label.setBounds(130, 154, 48, 34);
		contentPane.add(label);
		
		button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfMenu returnMenu =new UIOfMenu();
				returnMenu.setVisible(true);
				UIOfAddBook.this.dispose();
			}
		});
		button.setBounds(240, 214, 112, 37);
		contentPane.add(button);
		
		panel_1 = new JPanel();
		panel_1.setBounds(285, 227, 10, 10);
		contentPane.add(panel_1);
		
		promptID = new JLabel("");
		promptID.setFont(new Font("宋体", Font.PLAIN, 18));
		promptID.setForeground(Color.RED);
		promptID.setBounds(343, 24, 81, 34);
		contentPane.add(promptID);
		
		promptName = new JLabel("");
		promptName.setFont(new Font("宋体", Font.PLAIN, 18));
		promptName.setForeground(Color.RED);
		promptName.setBounds(343, 68, 81, 34);
		contentPane.add(promptName);
	}
}
