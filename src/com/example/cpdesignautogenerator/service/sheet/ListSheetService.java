package com.example.cpdesignautogenerator.service.sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.example.cpdesignautogenerator.style.CellStyleController;

public class ListSheetService {

	public static void createSheet(Workbook workbook) {

		Sheet sheet = workbook.createSheet("クラス・メソッド名一覧");

		// セル幅調整
		CellStyleController.setHeightAndWidth(sheet);

		// 1行目(A1) を作成して値を入れる
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("処理詳細");

		CellRangeAddress region = new CellRangeAddress(0, 1, 0, 5); // A1〜F2
		sheet.addMergedRegion(region);

		// スタイル適応
		CellStyle cellStyle = workbook.createCellStyle();
		CellStyleController.setCellStyle(cellStyle);
		CellStyleController.setLightBlueStyle(cellStyle);
		CellStyleController.setRegionBorderStyle(sheet, region);
		cell.setCellStyle(cellStyle);
	}
}
