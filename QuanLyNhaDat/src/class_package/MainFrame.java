package class_package;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

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
	private JButton btnWrite;
	private JButton btnRead;
	public static ImageIcon success_icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					MainFrame.CapNhat();
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
		txtSearch.setBounds(10, 11, 319, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		success_icon = new ImageIcon(MainFrame.class.getResource("/images/success.png"));
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
		btnTim.setBounds(339, 8, 85, 23);
		contentPane.add(btnTim);

		JButton btnThem = new JButton();
		btnThem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/plus.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemFrame themFrame = new ThemFrame(mainFrame, true);
				themFrame.setVisible(true);
			}
		});
		btnThem.setBounds(10, 44, 85, 23);
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

		btnXoa = new JButton();
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tieuchi = txtSearch.getText();
				if (tieuchi.isEmpty())
					JOptionPane.showMessageDialog(mainFrame, "Bạn chưa điền tiêu chí", "Lỗi!",
							JOptionPane.ERROR_MESSAGE);
				else {
					if (danhSachThuaDat.Xoa(tieuchi)) {
						int luachon = JOptionPane.showConfirmDialog(mainFrame, "Bạn có muốn xóa thửa đất?",
								"Confirmation", JOptionPane.YES_NO_OPTION);
						if (luachon == JOptionPane.YES_OPTION) {
							CapNhat();

							JOptionPane.showMessageDialog(mainFrame, "Xóa thành công!", "Thành công!",
									JOptionPane.INFORMATION_MESSAGE, success_icon);
						}
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Không tìm thấy thửa đất với tiêu chí trên",
								"Thất bại!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(MainFrame.class.getResource("/images/remove-symbol.png")));
		btnXoa.setBounds(339, 44, 85, 23);
		contentPane.add(btnXoa);

		btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				XuatRaExcel();
			}
		});
		btnRead.setIcon(new ImageIcon(MainFrame.class.getResource("/images/write.png")));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnRead.setBounds(121, 44, 85, 23);
		contentPane.add(btnRead);

		btnWrite = new JButton("New button");
		btnWrite.setBounds(229, 44, 85, 23);
		contentPane.add(btnWrite);
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
		if (danhSachThuaDat.isEmpty()) {
			showMessage("Không có dữ liệu");
		} else {
			for (int i = 0; i < MainFrame.danhSachThuaDat.Size(); i++) {
				{
					showMessage(MainFrame.danhSachThuaDat.getThuaDatTaiViTri(i).toString());
					if (i < MainFrame.danhSachThuaDat.Size() - 1)
						showMessage("\n\n");
				}
			}
		}
	}

	private void XuatRaExcel() {
		if (danhSachThuaDat.isEmpty())
			JOptionPane.showMessageDialog(mainFrame, "Không có dữ liệu để xuất ra file!", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		else {
			int luachon = JOptionPane.showConfirmDialog(mainFrame, "Bạn có muốn xuất toàn bộ thông tin ra file excel?",
					"Confirmation", JOptionPane.YES_NO_OPTION);
			if (luachon == JOptionPane.YES_OPTION) {
				Workbook wb = new HSSFWorkbook();
				FileOperation buffer = new FileOperation(wb);
				buffer.write(danhSachThuaDat);				

				try {
					FileOutputStream fileOut = new FileOutputStream("danh_sach.xls");
					wb.write(fileOut);
					JOptionPane.showMessageDialog(mainFrame, "Xuất ra file excel thành công!", "Thành công!",
							JOptionPane.INFORMATION_MESSAGE, success_icon);
					fileOut.close();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(mainFrame, "Xin hãy tắt file excel trước khi tiến hành ghi!",
							"Thất bại!", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
