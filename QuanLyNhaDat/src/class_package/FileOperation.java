package class_package;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import DSLK.LinkedList;

public class FileOperation {
	private Workbook wb;

	public FileOperation(Workbook _wb) {
		this.wb = _wb;
	}

	public Workbook getWb() {
		return wb;
	}

	public void setWb(Workbook wb) {
		this.wb = wb;
	}

	public void write(LinkedList list) {
		int count = 1;
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("danh sach thua dat");
		Row row = sheet.createRow(0);

		Font font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setBold(true);

		Cell cell[] = new Cell[7];
		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		for (int i = 0; i < 7; i++) {
			cell[i] = row.createCell(i);
			cell[i].setCellStyle(style);
		}

		cell[0].setCellValue(createHelper.createRichTextString("STT"));
		cell[1].setCellValue(createHelper.createRichTextString("Địa chỉ"));
		cell[2].setCellValue(createHelper.createRichTextString("Diện tích"));
		cell[3].setCellValue(createHelper.createRichTextString("Chủ sở hữu"));
		cell[4].setCellValue(createHelper.createRichTextString("Loại nhà"));
		cell[5].setCellValue(createHelper.createRichTextString("Mục đích sử dụng"));
		cell[6].setCellValue(createHelper.createRichTextString("Giá tiền"));

		for (int i = 1; i <= list.Size(); i++) {
			row = sheet.createRow(i);
			ThuaDat td = list.getThuaDatTaiViTri(i - 1);
			row.createCell(0).setCellValue(count);
			row.createCell(1).setCellValue(createHelper.createRichTextString(td.getDiachi().toString()));
			row.createCell(2).setCellValue(td.getDientich());
			row.createCell(3).setCellValue(createHelper.createRichTextString(td.getChusohuu()));
			row.createCell(4).setCellValue(createHelper.createRichTextString(td.getLoainha().getName()));
			row.createCell(5).setCellValue(createHelper.createRichTextString(td.getMucdich().getName()));
			row.createCell(6).setCellValue(td.getGiatien());
			count++;
		}
	}
}
