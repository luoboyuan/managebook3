package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.BookList;
import model.ReturnResult;
import net.Client;
import operator.Operator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIOfSearchById extends JFrame {

	private JPanel contentPane;
	private JTextField searchByID;
	private JTable table;
	private JButton makeSure;
	private JButton returnMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOfSearchById frame = new UIOfSearchById();
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
	public UIOfSearchById() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel promptID = new JLabel("请输入书籍编号");
		promptID.setBounds(0, 0, 130, 15);
		contentPane.add(promptID);
		
		searchByID = new JTextField();
		searchByID.setBounds(122, -3, 81, 21);
		contentPane.add(searchByID);
		searchByID.setColumns(10);
		
		JScrollPane BookTableJScrollPane = new JScrollPane();
		BookTableJScrollPane.setBounds(10, 53, 414, 156);
		contentPane.add(BookTableJScrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"书籍编号", "书籍名字", "书籍作者", "书籍价格"
			}
		));
		BookTableJScrollPane.setViewportView(table);
		
		makeSure = new JButton("确定");
		makeSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    String BookID=searchByID.getText();
		    Operator operator =new Operator();
		    ReturnResult returnResult=operator.searchByBookID(BookID);
		    if(returnResult.isSuccess){
		    	BookList bookList=(BookList)returnResult.returnData;
		    	DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		    	int count=bookList.size();
	        	tableModel.setRowCount(0);
	        	
	        	for(int i=0;i<count;i++){
	        	Book book2=bookList.get(i);
	        	DefaultTableModel tablemodel=(DefaultTableModel)table.getModel();
	        	tablemodel.addRow(new Object[]{ book2.bookId,book2.bookName,book2.author,book2.price});
	        	}
		    }
		    else{
		    	UIOfResult showResult =new UIOfResult(returnResult.failreason);
		    	showResult.setVisible(true);
		    	UIOfSearchById.this.dispose();
		    }	
			}
		});
		makeSure.setBounds(227, -4, 93, 23);
		contentPane.add(makeSure);
		
		returnMenu = new JButton("返回");
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIOfMenu returnMain=new UIOfMenu();
				returnMain.setVisible(true);
				UIOfSearchById.this.dispose();
			}
		});
		returnMenu.setBounds(139, 228, 93, 23);
		contentPane.add(returnMenu);
	}
}
