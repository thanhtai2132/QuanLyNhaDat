package enum_package;

import java.util.ArrayList;
import java.util.List;

public enum MucDich {
	NHA_O("Nhà ở"), KINH_DOANH("Kinh doanh");

	private String name;

	MucDich(String name) {
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
		for (MucDich element : MucDich.values())
			list.add(element.getName());
		String[] array = list.toArray(new String[list.size()]);
		return array;
	}
}
