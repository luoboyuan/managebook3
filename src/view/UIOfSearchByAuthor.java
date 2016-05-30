package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.BookList;
import model.ReturnResult;
import net.Client;
import operator.Operator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UIOfSearchByAuthor extends JFrame {

	private JPanel contentPane;
	private JTextField inputAuthor;
	private JTable bookTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOfSearchByAuthor frame = new UIOfSearchByAuthor();
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
	public UIOfSearchByAuthor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel seek = new JLabel("请输入要查找的作者名字");
		seek.setBounds(10, 10, 151, 15);
		contentPane.add(seek);
		
		inputAuthor = new JTextField();
		inputAuthor.setBounds(153, 7, 106, 21);
		contentPane.add(inputAuthor);
		inputAuthor.setColumns(10);
		
		JButton makeSure = new JButton("确定");
		makeSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    String BookAuthor=inputAuthor.getText();
		    Operator operator =new Operator();
		    ReturnResult returnResult=operator.searchByAthor(BookAuthor);
		    if(returnResult.isSuccess){
		    	BookList bookList=(BookList)returnResult.returnData;
		    	DefaultTableModel tableModel = (DefaultTableModel) bookTable.getModel();
		    	int count=bookList.size();
	        	tableModel.setRowCount(0);
	        	
	        	for(int i=0;i<count;i++){
	        	Book book2=bookList.get(i);
	        	DefaultTableModel tablemodel=(DefaultTableModel)bookTable.getModel();
	        	String price=String.valueOf(book2.price);
	        	tablemodel.addRow(new Object[]{ book2.bookId,book2.bookName,book2.author,price});
	        	}
		    }
		    else{
		    	UIOfResult showResult =new UIOfResult(returnResult.failreason);
		    	showResult.setVisible(true);
		    	UIOfSearchByAuthor.this.dispose();
		    }
			}
		});
		makeSure.setBounds(281, 6, 93, 23);
		contentPane.add(makeSure);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 414, 170);
		contentPane.add(scrollPane);
		
		bookTable = new JTable();
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"书籍编号", "书籍名字", "书籍作者", "书籍价格"
			}
		));
		scrollPane.setViewportView(bookTable);
		
		JButton returnMenu = new JButton("返回");
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfMenu returnMain=new UIOfMenu();
				returnMain.setVisible(true);
				UIOfSearchByAuthor.this.dispose();
			}
		});
		returnMenu.setBounds(154, 228, 93, 23);
		contentPane.add(returnMenu);
		
		JPanel panel = new JPanel();
		panel.setBounds(355, 15, 10, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(193, 241, 10, 10);
		contentPane.add(panel_1);
	}
}

