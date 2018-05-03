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
		for (int i = 0; i <= index; i++)
			n = n.getPnext();
		return n.getData();
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

	public void Tim(String tieuchi) {
		Node n = head;
		if (n.getData().getChusohuu().toUpperCase().contains(tieuchi.toUpperCase())
				|| n.getData().getDiachi().getPhuong().toUpperCase().contains(tieuchi.toUpperCase())
				|| n.getData().getDiachi().getQuan().toUpperCase().contains(tieuchi.toUpperCase())
				|| n.getData().getDiachi().getSonha().toUpperCase().contains(tieuchi.toUpperCase())
				|| n.getData().getDiachi().getTenduong().toUpperCase().contains(tieuchi.toUpperCase())
				|| Double.toString(n.getData().getDientich()).equals(tieuchi)
				|| Double.toString(n.getData().getGiatien()).equals(tieuchi)
				|| n.getData().getLoainha().toString().toUpperCase().equals(tieuchi.toUpperCase())
				|| n.getData().getMucdich().toString().toUpperCase().equals(tieuchi.toUpperCase())) {
			System.out.println(n.getData().getChusohuu() + "\n" + n.getData().getDiachi().getPhuong() + "\n"
					+ n.getData().getDiachi().getQuan() + "\n" + n.getData().getDiachi().getSonha() + "\n"
					+ n.getData().getDiachi().getTenduong() + "\n" + Double.toString(n.getData().getDientich()) + "\n"
					+ Double.toString(n.getData().getGiatien()) + "\n"
					+ n.getData().getLoainha().toString().toUpperCase() + "\n" + n.getData().getMucdich().toString()
					+ "\n");
		} else
			n = n.getPnext();
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
		while (n != null)
			count++;
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
