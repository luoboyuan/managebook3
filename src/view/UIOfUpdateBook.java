package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Book;
import model.ReturnResult;
import net.Client;
import operator.Operator;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class UIOfUpdateBook extends JFrame {
	
	private JPanel contentPane;
	
	private JTextField bookAuthor;
	private JTextField bookName;
	private JTextField updateBookID_1;
	private JTextField updateBookName_1;
	private JTextField updateBookAuthor_1;
	private JTextField updateBookPrice_1;
	private JLabel promptName;
	private JLabel promptAuthor;
	private JLabel promptID_1;
	private JLabel promptAuthor1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIOfUpdateBook frame = new UIOfUpdateBook();
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
	public UIOfUpdateBook() {
		setTitle("图书修改界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bookName = new JTextField();
		bookName.setBounds(205, 18, 98, 21);
		contentPane.add(bookName);
		bookName.setColumns(10);
		
		updateBookID_1 = new JTextField();
		updateBookID_1.setBounds(205, 80, 98, 22);
		contentPane.add(updateBookID_1);
		updateBookID_1.setColumns(10);
		
		updateBookName_1 = new JTextField();
		updateBookName_1.setBounds(205, 112, 98, 23);
		contentPane.add(updateBookName_1);
		updateBookName_1.setColumns(10);
		
		updateBookAuthor_1 = new JTextField();
		updateBookAuthor_1.setBounds(205, 145, 98, 21);
		contentPane.add(updateBookAuthor_1);
		updateBookAuthor_1.setColumns(10);
		
		updateBookPrice_1 = new JTextField();
		updateBookPrice_1.setBounds(205, 179, 98, 21);
		contentPane.add(updateBookPrice_1);
		updateBookPrice_1.setColumns(10);
		
		JLabel havaBookID = new JLabel("请输入要修改的书籍名字");
		havaBookID.setBounds(45, 18, 157, 21);
		contentPane.add(havaBookID);
		
		JLabel updateBookID = new JLabel("修改后的书籍编号");
		updateBookID.setBounds(81, 80, 110, 21);
		contentPane.add(updateBookID);
		
		JLabel havaBookName = new JLabel("修改后的书籍名字");
		havaBookName.setBounds(81, 116, 110, 15);
		contentPane.add(havaBookName);
		
		JLabel updateBookAuthor = new JLabel("修改后的书籍作者");
		updateBookAuthor.setBounds(81, 148, 110, 15);
		contentPane.add(updateBookAuthor);
		
		JLabel updateBookPrice = new JLabel("修改后的书籍价格");
		updateBookPrice.setBounds(81, 182, 110, 15);
		contentPane.add(updateBookPrice);
		
		JButton makeSure = new JButton("确定");
		makeSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(bookName.getText().equals("")||bookName.getText().equals(""))
		    {
		    	if(bookName.getText().equals("")){promptName.setText("不能为空");}
		    	if(bookAuthor.getText().equals("")){promptAuthor.setText("不能为空");}
		    	
		    }
		    else{
		    	if(updateBookName_1.getText().equals("")&&updateBookID_1.getText().equals("")&&updateBookAuthor_1.getText().equals("")&&updateBookPrice_1.getText().equals("")){
		    		promptID_1.setText("修改信息不能都为空");	
		    	}
		    	else{
		    		String BookID_1 = null,BookName_1 = null,BookAuthor_1 = null,bookPriceTemp ="0";
		    		if(!updateBookID_1.getText().equals("")){BookID_1=updateBookID_1.getText();}
		    		if(!updateBookName_1.getText().equals("")){BookName_1=updateBookName_1.getText();}
		    		if(!updateBookAuthor_1.getText().equals("")){BookAuthor_1=updateBookAuthor_1.getText();}
		    		if(!updateBookPrice_1.getText().equals("")){bookPriceTemp=updateBookPrice_1.getText();}
		    	String BookName=bookName.getText(), BookAuthor=bookAuthor.getText();
	    	    float BookPrice_1=Float.valueOf(bookPriceTemp);
		    	Book book=new Book(" ",BookName,BookAuthor,0);
		    	Book book_1=new Book(BookID_1,BookName_1,BookAuthor_1,BookPrice_1);
		    	Operator operator =new Operator();
		    	ReturnResult returnResult=operator.updateBook(book, book_1);
		    	if(returnResult.isSuccess){
		    	String information=(String)returnResult.returnData;
		    	UIOfResult showResult =new UIOfResult(information);
		    	showResult.setVisible(true);
		    	UIOfUpdateBook.this.dispose();
		    }
		    else{
		    	UIOfResult showResult =new UIOfResult(returnResult.failreason);
		    	showResult.setVisible(true);
		    	UIOfUpdateBook.this.dispose();
		    }
		    	}
		   }
			}
		});
		makeSure.setBounds(155, 210, 93, 23);
		contentPane.add(makeSure);
		
		JPanel panel = new JPanel();
		panel.setBounds(196, 220, 10, 10);
		contentPane.add(panel);
		
		JButton returnMenu = new JButton("返回");
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UIOfMenu returnMain=new UIOfMenu();
			returnMain.setVisible(true);
			UIOfUpdateBook.this.dispose();
			}
		});
		returnMenu.setBounds(155, 238, 93, 23);
		contentPane.add(returnMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(181, 251, 10, 10);
		contentPane.add(panel_1);
		
		promptName = new JLabel("");
		promptName.setForeground(Color.RED);
		promptName.setBounds(313, 18, 84, 15);
		contentPane.add(promptName);
		
		promptID_1 = new JLabel("");
		promptID_1.setForeground(Color.RED);
		promptID_1.setBounds(313, 83, 111, 117);
		contentPane.add(promptID_1);
		
		bookAuthor = new JTextField();
		bookAuthor.setBounds(205, 49, 98, 21);
		contentPane.add(bookAuthor);
		bookAuthor.setColumns(10);
		
		JLabel HavaBookAuthor = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u4E66\u7C4D\u4F5C\u8005");
		HavaBookAuthor.setBounds(45, 49, 146, 21);
		contentPane.add(HavaBookAuthor);
		
		promptAuthor = new JLabel("");
		promptAuthor.setForeground(Color.RED);
		promptAuthor.setBounds(313, 52, 84, 15);
		contentPane.add(promptAuthor);
	}
}
