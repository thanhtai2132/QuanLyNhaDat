package class_package;

import enum_package.LoaiNha;
import enum_package.MucDich;

public class ThuaDat {
	private DiaChi diachi;
	private double dientich;
	private String chusohuu;
	private LoaiNha loainha;
	private MucDich mucdich;
	private double giatien;

	public DiaChi getDiachi() {
		return diachi;
	}

	public void setDiachi(DiaChi diachi) {
		this.diachi = diachi;
	}

	public double getDientich() {
		return dientich;
	}

	public void setDientich(double dientich) {
		this.dientich = dientich;
	}

	public String getChusohuu() {
		return chusohuu;
	}

	public void setChusohuu(String chusohuu) {
		this.chusohuu = chusohuu;
	}

	public LoaiNha getLoainha() {
		return loainha;
	}

	public void setLoainha(LoaiNha loainha) {
		this.loainha = loainha;
	}

	public MucDich getMucdich() {
		return mucdich;
	}

	public void setMucdich(MucDich mucdich) {
		this.mucdich = mucdich;
	}

	public double getGiatien() {
		return giatien;
	}

	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}

	@Override
	public String toString() {
		if (!diachi.getPhuong().isEmpty())
			return "Địa chỉ: " + diachi.getSonha() + ", đường " + diachi.getTenduong() + ", phường "
					+ diachi.getPhuong() + ", quận " + diachi.getQuan() + "\n Diện tích: " + dientich + " m²"
					+ "\n Chủ sở hữu :" + chusohuu + "\n Loại nhà: " + loainha.getName() + "\n Mục đích: "
					+ mucdich.getName() + "\n Giá tiền: " + giatien;
		else
			return "Địa chỉ: " + diachi.getSonha() + ", đường " + diachi.getTenduong() + ", quận " + diachi.getQuan()
					+ "\n Diện tích: " + dientich + "\n Chủ sở hữu :" + chusohuu + "\n Loại nhà: " + loainha.getName()
					+ "\n Mục đích: " + mucdich.getName() + "\n Giá tiền: " + giatien;
	}

}
