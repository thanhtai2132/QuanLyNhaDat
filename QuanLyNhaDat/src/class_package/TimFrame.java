package class_package;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimFrame extends JDialog {
	private JTextArea txtHienThi;
	private JScrollPane scrollpane;
	private JPanel contentPane;
	private static TimFrame frame;

	/**
	 * Create the frame.
	 */
	public TimFrame(Frame parent, boolean modal) {
		super(parent, modal);
		setTitle("Kết quả tìm kiếm");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		txtHienThi = new JTextArea();
		txtHienThi.setFont(new Font("Serif", Font.ITALIC, 16));
		txtHienThi.setWrapStyleWord(true);
		txtHienThi.setLineWrap(true);
		txtHienThi.setEditable(false);
		txtHienThi.setColumns(35);
		txtHienThi.setRows(11);
		scrollpane = new JScrollPane(txtHienThi);
		scrollpane.setBorder(null);
		contentPane.add(scrollpane);
	}

	public void HienThiKetQua(String tieuchi) {
		if (tieuchi.isEmpty())
			JOptionPane.showMessageDialog(frame, "Bạn chưa nhập tiêu chí", "Lỗi", JOptionPane.ERROR_MESSAGE);
		else
			txtHienThi.setText(MainFrame.danhSachThuaDat.Tim(tieuchi));
	}

}
