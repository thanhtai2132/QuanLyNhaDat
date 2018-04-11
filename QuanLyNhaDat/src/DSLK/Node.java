package DSLK;

import class_package.ThuaDat;

public class Node {
	private Node pnext;
	private ThuaDat data;

	public ThuaDat getData() {
		return data;
	}

	public void setData(ThuaDat data) {
		this.data = data;
	}

	public Node(ThuaDat td) {
		super();
		this.pnext = null;
		this.data = td;
	}

	public Node getPnext() {
		return pnext;
	}

	public void setPnext(Node pnext) {
		this.pnext = pnext;
	}
}
