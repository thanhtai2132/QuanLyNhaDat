package DSLK;

import class_package.ThuaDat;
import enum_package.TieuChi;

public class LinkedList {
	private Node head;

	public void Them(ThuaDat td) {
		Node n = new Node(td);
		if (head != null)
			n.setPnext(head);
		head = n;
	}

	public ThuaDat getThuaDatTaiViTri(int index) {
		Node n = head;
		for (int i = 0; i < index; i++)
			n = n.getPnext();
		return n.getData();
	}

	public void Xoa(String tieuchi) {
		if (head != null) {
			Node nodeCanTim = head;
			while (nodeCanTim != null) {
				if (nodeCanTim.getData().getChusohuu().toUpperCase().contains(tieuchi.toUpperCase())
						|| nodeCanTim.getData().getDiachi().getPhuong().toUpperCase().contains(tieuchi.toUpperCase())
						|| nodeCanTim.getData().getDiachi().getQuan().toUpperCase().contains(tieuchi.toUpperCase())
						|| nodeCanTim.getData().getDiachi().getSonha().toUpperCase().contains(tieuchi.toUpperCase())
						|| nodeCanTim.getData().getDiachi().getTenduong().toUpperCase().contains(tieuchi.toUpperCase())
						|| Double.toString(nodeCanTim.getData().getDientich()).equals(tieuchi)
						|| Double.toString(nodeCanTim.getData().getGiatien()).equals(tieuchi)
						|| nodeCanTim.getData().getLoainha().getName().toUpperCase().equals(tieuchi.toUpperCase())
						|| nodeCanTim.getData().getMucdich().getName().toUpperCase().equals(tieuchi.toUpperCase())) {
					if (nodeCanTim == head) {
						Node temp = head;
						head = head.getPnext();
						temp.setPnext(null);
						nodeCanTim = head;
					} else {
						Node nodeOTruoc = head;
						while (nodeOTruoc.getPnext() != nodeCanTim)
							nodeOTruoc = nodeOTruoc.getPnext();
						Node nodeOSau = nodeCanTim.getPnext();
						nodeOTruoc.setPnext(nodeOSau);
						nodeCanTim.setPnext(null);
						nodeCanTim = head;
					}
				} else
					nodeCanTim = nodeCanTim.getPnext();
			}
		}
	}

	public String Tim(String tieuchi) {
		Node n = head;
		while (n != null) {
			if (n.getData().getChusohuu().toUpperCase().contains(tieuchi.toUpperCase())
					|| n.getData().getDiachi().getPhuong().toUpperCase().contains(tieuchi.toUpperCase())
					|| n.getData().getDiachi().getQuan().toUpperCase().contains(tieuchi.toUpperCase())
					|| n.getData().getDiachi().getSonha().toUpperCase().contains(tieuchi.toUpperCase())
					|| n.getData().getDiachi().getTenduong().toUpperCase().contains(tieuchi.toUpperCase())
					|| Double.toString(n.getData().getDientich()).equals(tieuchi)
					|| Double.toString(n.getData().getGiatien()).equals(tieuchi)
					|| n.getData().getLoainha().getName().toUpperCase().equals(tieuchi.toUpperCase())
					|| n.getData().getMucdich().getName().toUpperCase().equals(tieuchi.toUpperCase())) {
				return n.getData().toString();
			} else
				n = n.getPnext();
		}
		return "Không tìm thấy";
	}

	public void SapXep(TieuChi tc) {
		Node i = head;
		while (i.getPnext() != null) {
			Node j = i.getPnext();
			while (j != null) {
				switch (tc.ordinal()) {
				case 0: // Dia chi
					if (i.getData().getDiachi().getPhuong().compareToIgnoreCase(j.getData().getDiachi().getPhuong()) > 0
							|| i.getData().getDiachi().getQuan()
									.compareToIgnoreCase(j.getData().getDiachi().getQuan()) > 0
							|| i.getData().getDiachi().getSonha()
									.compareToIgnoreCase(j.getData().getDiachi().getSonha()) > 0
							|| i.getData().getDiachi().getTenduong()
									.compareToIgnoreCase(j.getData().getDiachi().getTenduong()) > 0) /* lon hon */
						i.Swap(j);
				case 1: // Dien tich
					if (i.getData().getDientich() > j.getData().getDientich())
						i.Swap(j);
				case 2: // Chu so huu
					if (i.getData().getChusohuu().compareToIgnoreCase(j.getData().getChusohuu()) > 0) /* lon hon */
						i.Swap(j);
				case 3: // Loai nha
					if (i.getData().getLoainha().ordinal() > j.getData().getLoainha().ordinal())
						i.Swap(j);
				case 4: // Muc dich su dung
					if (i.getData().getMucdich().ordinal() > j.getData().getMucdich().ordinal())
						i.Swap(j);
				case 5: // Gia tien
					if (i.getData().getGiatien() > j.getData().getGiatien())
						i.Swap(j);
				}
			}
		}
	}

	public int Size() {
		int count = 0;
		Node n = head;
		while (n != null) {
			n = n.getPnext();
			count++;
		}
		return count;
	}

	public ThuaDat[] toArray() {
		Node n = head;
		ThuaDat[] td = new ThuaDat[this.Size()];
		for (int i = 0; i < this.Size() && n != null; i++) {
			td[i] = n.getData();
			n = n.getPnext();
		}
		return td;
	}

	public void Merge(LinkedList list, TieuChi tieuchi) {
		ThuaDat[] td = list.toArray();
		for (ThuaDat element : td)
			list.Them(element);
		this.SapXep(tieuchi);
	}
}
