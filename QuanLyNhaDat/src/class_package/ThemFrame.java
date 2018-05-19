package class_package;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import enum_package.LoaiNha;
import enum_package.MucDich;

public class ThemFrame extends JDialog {
	private static ThemFrame frame;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblDiaChi;
	private JLabel lblSoNha;
	private JTextField txtSoNha;
	private JTextField txtPhuong;
	private JLabel lblPhuong;
	private JLabel lblDienTich;
	private JTextField txtDienTich;
	private JTextField txtDuong;
	private JLabel lblDuong;
	private JLabel lblChu;
	private JTextField txtChu;
	private JTextField txtQuan;
	private JLabel lblQuan;
	private JLabel lblGiaTien;
	private JTextField txtGiaTien;
	private JButton btnOK;
	private JButton btnCancel;

	private String sonha, duong, phuong, quan;
	private double dientich, giatien;
	private LoaiNha loainha;
	private MucDich mucdich;
	private String chu;

	private JComboBox comboMucDich, comboLoaiNha;
	private JPanel panel_1;

	/**
	 * Create the frame.
	 */
	public ThemFrame(Frame parent, boolean modal) {
		super(parent, modal);
		setTitle("Thêm thửa đất");
		setBounds(100, 100, 603, 407);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		panel = new JPanel();
		panel.setBounds(10, 39, 567, 73);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblSoNha = new JLabel("Số nhà");
		panel.add(lblSoNha);

		txtSoNha = new JTextField();
		txtSoNha.setColumns(18);
		panel.add(txtSoNha);

		lblPhuong = new JLabel("Phường");
		panel.add(lblPhuong);

		txtPhuong = new JTextField();
		txtPhuong.setColumns(18);
		panel.add(txtPhuong);

		lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(10, 11, 70, 30);
		contentPane.add(lblDiaChi);

		lblDienTich = new JLabel("Diện tích (m²)");
		lblDienTich.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDienTich.setBounds(10, 202, 90, 14);
		contentPane.add(lblDienTich);

		txtDienTich = new JTextField();
		txtDienTich.setBounds(110, 200, 150, 20);
		contentPane.add(txtDienTich);
		txtDienTich.setColumns(10);

		lblChu = new JLabel("Chủ");
		lblChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChu.setBounds(337, 202, 80, 14);
		contentPane.add(lblChu);

		txtChu = new JTextField();
		txtChu.setBounds(427, 200, 150, 20);
		contentPane.add(txtChu);
		txtChu.setColumns(10);

		JLabel lblMucDich = new JLabel("Mục đích");
		lblMucDich.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMucDich.setBounds(10, 281, 90, 14);
		contentPane.add(lblMucDich);

		JLabel lblLoaiNha = new JLabel("Loại nhà");
		lblLoaiNha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoaiNha.setBounds(337, 234, 80, 14);
		contentPane.add(lblLoaiNha);

		String list_loainha[] = LoaiNha.getValues();
		comboLoaiNha = new JComboBox(list_loainha);
		comboLoaiNha.setBounds(427, 231, 150, 22);
		contentPane.add(comboLoaiNha);

		String list_mucdich[] = MucDich.getValues();
		comboMucDich = new JComboBox(list_mucdich);
		comboMucDich.setBounds(110, 278, 150, 22);
		contentPane.add(comboMucDich);

		btnOK = new JButton("OK");
		btnOK.setBounds(141, 332, 89, 23);
		btnOK.addActionListener(new HandleClass());
		contentPane.add(btnOK);

		btnCancel = new JButton("Hủy");
		btnCancel.setBounds(303, 332, 89, 23);
		btnCancel.addActionListener(new HandleClass());
		contentPane.add(btnCancel);

		lblGiaTien = new JLabel("Giá tiền");
		lblGiaTien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGiaTien.setBounds(10, 239, 90, 14);
		contentPane.add(lblGiaTien);

		txtGiaTien = new JTextField();
		txtGiaTien.setBounds(110, 237, 150, 20);
		contentPane.add(txtGiaTien);
		txtGiaTien.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 123, 567, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblDuong = new JLabel("Tên đường");
		panel_1.add(lblDuong);

		txtDuong = new JTextField();
		panel_1.add(txtDuong);
		txtDuong.setColumns(18);

		lblQuan = new JLabel("Quận");
		panel_1.add(lblQuan);

		txtQuan = new JTextField();
		panel_1.add(txtQuan);
		txtQuan.setColumns(18);
	}

	public void LayDuLieu() {
		// dia chi
		sonha = txtSoNha.getText();
		duong = txtDuong.getText();
		phuong = txtPhuong.getText();
		quan = txtQuan.getText();

		chu = txtChu.getText();
		dientich = Double.parseDouble(txtDienTich.getText());
		giatien = Double.parseDouble(txtGiaTien.getText());
		loainha = getLoaiNha(comboLoaiNha.getSelectedIndex());
		mucdich = getMucDich(comboMucDich.getSelectedIndex());
	}

	private LoaiNha getLoaiNha(int index) {
		for (LoaiNha element : LoaiNha.values()) {
			if (element.ordinal() == index)
				return element;
		}
		return null;
	}

	private MucDich getMucDich(int index) {
		for (MucDich element : MucDich.values()) {
			if (element.ordinal() == index)
				return element;
		}
		return null;
	}

	private class HandleClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("OK")) {
				if (!txtChu.getText().isEmpty() && !txtDienTich.getText().isEmpty() && !txtQuan.getText().isEmpty()
						&& !txtGiaTien.getText().isEmpty() && !txtDuong.getText().isEmpty()
						&& !txtSoNha.getText().isEmpty()) {
					LayDuLieu();
					DiaChi diachi = new DiaChi(sonha, duong, phuong, quan);
					ThuaDat td = new ThuaDat();
					td.setDiachi(diachi);
					td.setChusohuu(chu);
					td.setDientich(dientich);
					td.setGiatien(giatien);
					td.setLoainha(loainha);
					td.setMucdich(mucdich);
					MainFrame.danhSachThuaDat.Them(td);
					JOptionPane.showMessageDialog(frame, "Đã thêm thành công", "Thành công!",
							JOptionPane.INFORMATION_MESSAGE, MainFrame.success_icon);
					ResetForm();
				} else {
					JOptionPane.showMessageDialog(frame, "Xin hãy nhập đầy đủ các trường", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				MainFrame.CapNhat();
				dispose();
			}
		}

	}

	public void ResetForm() {
		txtChu.setText("");
		txtDienTich.setText("");
		txtQuan.setText("");
		txtGiaTien.setText("");
		txtDuong.setText("");
		txtPhuong.setText("");
		txtSoNha.setText("");
	}
}
