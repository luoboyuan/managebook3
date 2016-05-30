package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.Client;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class UIOfResult extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOfResult frame = new UIOfResult("操作充公");
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
	public UIOfResult(String information) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIOfMenu returnMenu = new UIOfMenu();
				returnMenu.setVisible(true);
				UIOfResult.this.dispose();
			}
		});
		button.setBounds(150, 210, 93, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(220, 210, 10, 10);
		contentPane.add(panel);
		
		JLabel prompt = new JLabel("",javax.swing.JLabel.CENTER);
		prompt.setFont(new Font("楷体", Font.PLAIN, 18));
		prompt.setBounds(82, 102, 238, 39);
		contentPane.add(prompt);
	    prompt.setText(information);
	}
}
