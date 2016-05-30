package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ReturnResult;
import net.Client;
import operator.Operator;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class UIOfDeleteBook extends JFrame {

	private JPanel contentPane;
	private JTextField deleteBookID_1;
	private JTextField textField;
	private JLabel prompt;
	private JLabel promptID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIOfDeleteBook frame = new UIOfDeleteBook();
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
	public UIOfDeleteBook() {
		getContentPane().setLayout(null);
		
		JLabel deleteBookId = new JLabel("");
		deleteBookId.setBounds(26, 90, 189, 15);
		getContentPane().add(deleteBookId);
		
		textField = new JTextField();
		textField.setBounds(225, 87, 66, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		setTitle("删除界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		deleteBookID_1 = new JTextField();
		deleteBookID_1.setBounds(114, 100, 159, 49);
		contentPane.add(deleteBookID_1);
		deleteBookID_1.setColumns(10);
		
		prompt = new JLabel("请输入要删除的书籍的书籍编号");
		prompt.setFont(new Font("宋体", Font.PLAIN, 17));
		prompt.setBounds(0, 0, 255, 39);
		contentPane.add(prompt);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(deleteBookID_1.getText().equals(""))
		    	{
					promptID.setText("不能为空");
		    	}
		    else{
		    String BookID=deleteBookID_1.getText();
		    Operator operator =new Operator();
		    ReturnResult returnResult=operator.deleteBook(BookID);
		    if(returnResult.isSuccess){
		    	String information=(String)returnResult.returnData;
		    	UIOfResult showResult =new UIOfResult(information);
		    	showResult.setVisible(true);
		    	UIOfDeleteBook.this.dispose();
		    }
		    else{
		    	UIOfResult showResult =new UIOfResult(returnResult.failreason);
		    	showResult.setVisible(true);
		    	UIOfDeleteBook.this.dispose();
		    }
			}
		}
		});
		button.setBounds(142, 170, 93, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(178, 180, 10, 10);
		contentPane.add(panel);
		
		JButton returnMenu = new JButton("返回");
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIOfMenu returnMain=new UIOfMenu();
				returnMain.setVisible(true);
				UIOfDeleteBook.this.dispose();
			}
		});
		returnMenu.setBounds(142, 214, 93, 23);
		contentPane.add(returnMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(178, 226, 10, 10);
		contentPane.add(panel_1);
		
		promptID = new JLabel("");
		promptID.setFont(new Font("宋体", Font.PLAIN, 16));
		promptID.setForeground(Color.RED);
		promptID.setBounds(283, 126, 85, 23);
		contentPane.add(promptID);
	}
}
