package DSLK;

import class_package.ThuaDat;

public class LinkedList {
	private Node head;

	public void Them(ThuaDat td) {
		Node n = new Node(td);
		if (head != null)
			n.setPnext(head);
		head = n;
	}

	public void Xoa(String input) {
		Node nodeCanTim = head;
		while (nodeCanTim != null) {
			if (nodeCanTim.getData().getDiachi().getTenduong().toUpperCase().equals(input.toUpperCase())) {
				Node nodeGan = head;
				while (nodeGan != nodeCanTim)
					nodeGan = nodeGan.getPnext();
				Node nodeKeTiep = nodeCanTim.getPnext();
				nodeGan.setPnext(nodeKeTiep);
				nodeCanTim.setPnext(null);
				break;
			}
			nodeCanTim = nodeCanTim.getPnext();
		}
	}

	public void Tim(String input) {
	
	}
	
	public void SapXep() {
		// heapsort
	}

}
