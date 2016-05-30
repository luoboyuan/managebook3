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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.BookList;
import model.ReturnResult;
import net.Client;
import operator.Operator;

public class UIOfSearchByName extends JFrame {

	private JPanel contentPane;
	private JTextField inputName;
	private JTable bookTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOfSearchByName frame = new UIOfSearchByName();
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
	public UIOfSearchByName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel promptName = new JLabel("请输入你想查询的书籍名字");
		promptName.setBounds(10, 10, 147, 15);
		contentPane.add(promptName);
		
		inputName = new JTextField();
		inputName.setBounds(152, 7, 155, 21);
		contentPane.add(inputName);
		inputName.setColumns(10);
		
		JButton makeSure = new JButton("确定");
		makeSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String BookName=inputName.getText();
			    Operator operator =new Operator();
			    ReturnResult returnResult=operator.searchByBookName(BookName);
			    if(returnResult.isSuccess){
			    	BookList bookList=(BookList)returnResult.returnData;
			    	DefaultTableModel tableModel = (DefaultTableModel) bookTable.getModel();
			    	int count=bookList.size();
		        	tableModel.setRowCount(0);
		        	
		        	for(int i=0;i<count;i++){
		        	Book book2=bookList.get(i);
		        	DefaultTableModel tablemodel=(DefaultTableModel)bookTable.getModel();
		        	tablemodel.addRow(new Object[]{ book2.bookId,book2.bookName,book2.author,book2.price});
		        	}
			    }
			    else{
			    	UIOfResult showResult =new UIOfResult(returnResult.failreason);
			    	showResult.setVisible(true);
			    	UIOfSearchByName.this.dispose();
			    }
			}
		});
		makeSure.setBounds(320, 6, 93, 23);
		contentPane.add(makeSure);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 414, 171);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(353, 15, 10, 10);
		contentPane.add(panel);
		
		JButton returnMenu = new JButton("返回");
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIOfMenu returnMain=new UIOfMenu();
				returnMain.setVisible(true);
				UIOfSearchByName.this.dispose();
			}
		});
		returnMenu.setBounds(145, 228, 93, 23);
		contentPane.add(returnMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 241, 10, 10);
		contentPane.add(panel_1);
	}
}
