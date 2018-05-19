package class_package;

public class DiaChi {
	private String sonha, tenduong, phuong, quan;

	public String getSonha() {
		return sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public String getTenduong() {
		return tenduong;
	}

	public void setTenduong(String tenduong) {
		this.tenduong = tenduong;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public DiaChi(String sonha, String tenduong, String phuong, String quan) {
		super();
		this.sonha = sonha;
		this.tenduong = tenduong;
		this.phuong = phuong;
		this.quan = quan;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s", sonha, tenduong, phuong, quan);
	}

}
