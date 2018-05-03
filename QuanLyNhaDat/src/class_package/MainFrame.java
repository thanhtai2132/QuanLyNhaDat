package class_package;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DSLK.LinkedList;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static LinkedList danhSachThuaDat;
	private JTextArea txtHienThi;
	private JButton btnView;
	private JButton btnXoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 11, 319, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		danhSachThuaDat = new LinkedList();

		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnTim.setBounds(339, 10, 85, 23);
		contentPane.add(btnTim);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemFrame themFrame = new ThemFrame();
				themFrame.setVisible(true);
			}
		});
		btnThem.setBounds(10, 42, 100, 23);
		contentPane.add(btnThem);

		txtHienThi = new JTextArea();
		txtHienThi.setBounds(10, 76, 414, 174);
		contentPane.add(txtHienThi);

		btnView = new JButton("Danh sách thửa đất");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < danhSachThuaDat.Size(); i++) {
					danhSachThuaDat.getThuaDatTaiViTri(i).toString();
					// txtHienThi.append("\n");
				}

			}
		});
		btnView.setBounds(120, 42, 194, 23);
		contentPane.add(btnView);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(324, 42, 100, 23);
		contentPane.add(btnXoa);
	}

	// public void showData() {
	//
	// }
}
