package class_package;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import DSLK.LinkedList;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	public static LinkedList danhSachThuaDat;
	public static JTextArea txtHienThi;
	private JScrollPane sp;
	private JButton btnView;
	private JButton btnXoa;
	private Frame mainFrame;
	private JButton btnTim;

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
		super("Quản lý nhà đất");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtSearch = new JTextField();
		txtSearch.setBounds(10, 11, 303, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		danhSachThuaDat = new LinkedList();

		btnTim = new JButton();
		btnTim.setIcon(new ImageIcon(MainFrame.class.getResource("/images/tim.png")));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tieuchi = txtSearch.getText();
				if (tieuchi.isEmpty())
					JOptionPane.showMessageDialog(mainFrame, "Bạn chưa điền tiêu chí", "Lỗi!",
							JOptionPane.ERROR_MESSAGE);
				else {
					TimFrame timFrame = new TimFrame(mainFrame, true);
					timFrame.HienThiKetQua(tieuchi);
					timFrame.setVisible(true);
				}
			}
		});
		btnTim.setBounds(323, 10, 101, 23);
		contentPane.add(btnTim);

		JButton btnThem = new JButton();
		btnThem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/plus.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemFrame themFrame = new ThemFrame(mainFrame, true);
				themFrame.setVisible(true);
			}
		});
		btnThem.setBounds(10, 42, 100, 23);
		contentPane.add(btnThem);

		txtHienThi = new JTextArea();
		txtHienThi.setEditable(false);
		txtHienThi.setBounds(10, 42, 100, 23);
		txtHienThi.setFont(new Font("Serif", Font.ITALIC, 16));
		txtHienThi.setWrapStyleWord(true);
		txtHienThi.setLineWrap(true);

		sp = new JScrollPane(txtHienThi);
		sp.setBounds(10, 76, 414, 174);
		contentPane.add(sp);

		btnView = new JButton("Danh sách thửa đất");
		btnView.setEnabled(false);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < danhSachThuaDat.Size(); i++)
					showMessage("\n" + danhSachThuaDat.getThuaDatTaiViTri(i).toString());
			}
		});
		btnView.setBounds(120, 42, 194, 23);
		contentPane.add(btnView);

		btnXoa = new JButton();
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tieuchi = txtSearch.getText();
				if (tieuchi.isEmpty())
					JOptionPane.showMessageDialog(mainFrame, "Bạn chưa điền tiêu chí", "Lỗi!",
							JOptionPane.ERROR_MESSAGE);
				else {
					danhSachThuaDat.Xoa(tieuchi);
					CapNhat();
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(MainFrame.class.getResource("/images/remove-symbol.png")));
		btnXoa.setBounds(324, 42, 100, 23);
		contentPane.add(btnXoa);
	}

	public static void showMessage(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				txtHienThi.append(text);
			}
		});
	}

	public static void CapNhat() {
		txtHienThi.setText(null);
		for (int i = 0; i < MainFrame.danhSachThuaDat.Size(); i++) {
			{
				showMessage(MainFrame.danhSachThuaDat.getThuaDatTaiViTri(i).toString());
				if (i < MainFrame.danhSachThuaDat.Size() - 1)
					showMessage("\n\n");
			}
		}
	}
}
