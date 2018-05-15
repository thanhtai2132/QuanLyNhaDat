package enum_package;

import java.util.ArrayList;
import java.util.List;

public enum LoaiNha {
	NHACAP_1("Nhà cấp 1"), NHACAP_2("Nhà cấp 2"), NHACAP_3("Nhà cấp 3"), NHACAP_4("Nhà cấp 4");

	private String name;

	LoaiNha(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String[] getValues() {
		List<String> list = new ArrayList<>();
		for (LoaiNha element : LoaiNha.values())
			list.add(element.getName());
		String[] array = list.toArray(new String[list.size()]);
		return array;
	}
}
