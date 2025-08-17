package com.example.cpdesignautogenerator.style;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class CellStyleController {

	public static void setHeightAndWidth(Sheet sheet) {

		// 1) 既定の行高を1文字分に
		sheet.setDefaultRowHeightInPoints(15f); // フォントにより微調整

		// 2) すべての列幅を 全角2文字 ≈ 512 に
		int maxCols = SpreadsheetVersion.EXCEL2007.getMaxColumns(); // 16384 (A〜XFD)
		int zenkakuTwoCharWidth = 1024;

		for (int column = 0; column < maxCols; column++) {
			sheet.setColumnWidth(column, zenkakuTwoCharWidth);
		}
	}

	public static CellStyle setCellStyle(CellStyle cellStyle) {
		cellStyle.setAlignment(HorizontalAlignment.LEFT); // 横方向 = 左寄せ
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 縦方向 = 中央寄せ

		return cellStyle;
	}

	public static CellStyle setLightBlueStyle(CellStyle cellStyle) {
		cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		return cellStyle;
	}

	/**
	 * セルに枠線を作成します。
	 * 
	 * @param cellStyle
	 * @return
	 */
	public static CellStyle setBorderStyle(CellStyle cellStyle) {
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		return cellStyle;
	}

	/**
	 * 結合されたセルに枠線を作成します。
	 * 
	 * @param cellStyle
	 * @return
	 */
	public static void setRegionBorderStyle(Sheet sheet, CellRangeAddress region) {
		RegionUtil.setBorderTop(BorderStyle.THIN, region, sheet);
		RegionUtil.setBorderBottom(BorderStyle.THIN, region, sheet);
		RegionUtil.setBorderLeft(BorderStyle.THIN, region, sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, region, sheet);
	}
}