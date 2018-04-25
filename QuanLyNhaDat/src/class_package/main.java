package class_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 346, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnThm = new JButton("Th\u00EAm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnThm.setBounds(10, 42, 89, 23);
		getContentPane().add(btnThm);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.setBounds(109, 42, 89, 23);
		getContentPane().add(btnXa);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(366, 10, 58, 23);
		getContentPane().add(btnNewButton);
	}
}
