package com.example.cpdesignautogenerator.service.sheet;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import com.example.cpdesignautogenerator.style.CellStyleController;

public class ListSheetService {

	public static void createSheet(Workbook workbook) {

		Sheet sheet = workbook.createSheet("クラス・メソッド名一覧");

		// セル幅調整
		CellStyleController.setHeightAndWidth(sheet);
		
		// ----- 処理詳細 -----
		// 1行目(A1) を作成して値を入れる
		Row row1 = sheet.createRow(0);
		Cell cellA1 = row1.createCell(0);
		cellA1.setCellValue("処理詳細");

		CellRangeAddress regionA1F1 = new CellRangeAddress(0, 1, 0, 5); // A1〜F2
		sheet.addMergedRegion(regionA1F1);

		// スタイル適応
		CellStyle cellA1Style = workbook.createCellStyle();
		CellStyleController.setCellStyle(cellA1Style);
		CellStyleController.setLightBlueStyle(cellA1Style);
		
		cellA1.setCellStyle(cellA1Style);

		// ----- モジュール名 -----
		Cell cellG1 = row1.createCell(6);
		cellG1.setCellValue("モジュール名");

		CellRangeAddress regionG1AL1 = new CellRangeAddress(0, 0, 6, 37); // G1〜AL1
		sheet.addMergedRegion(regionG1AL1);

		// スタイル適応
		CellStyle celG1Style = workbook.createCellStyle();
		CellStyleController.setCellStyle(celG1Style);
		CellStyleController.setLightBlueStyle(celG1Style);
		cellG1.setCellStyle(celG1Style);
		
		Row row2 = sheet.createRow(1);
		Cell cellG2 = row2.createCell(6);
		cellG2.setCellValue("テストモジュール");

		CellRangeAddress regionG2AL2 = new CellRangeAddress(1, 1, 6, 37); // G2〜AL2
		sheet.addMergedRegion(regionG2AL2);

		// スタイル適応
		CellStyle celG2Style = workbook.createCellStyle();
		CellStyleController.setCellStyle(celG2Style);
		cellG2.setCellStyle(celG2Style);
		
		// ----- 枠線作成 -----
		RegionUtil.setBorderRight(BorderStyle.THIN, regionA1F1, sheet);
		
		RegionUtil.setBorderBottom(BorderStyle.THIN, regionG1AL1, sheet);
		
		CellRangeAddress regionA1AL2 = new CellRangeAddress(0, 1, 0, 37); // A1〜AL2
		RegionUtil.setBorderTop(BorderStyle.THIN, regionA1AL2, sheet);
		RegionUtil.setBorderBottom(BorderStyle.THIN, regionA1AL2, sheet);
		RegionUtil.setBorderLeft(BorderStyle.THIN, regionA1AL2, sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, regionA1AL2, sheet);
	}
}
