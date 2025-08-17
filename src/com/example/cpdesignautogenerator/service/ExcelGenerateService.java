package com.example.cpdesignautogenerator.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.cpdesignautogenerator.config.ConfigParam;
import com.example.cpdesignautogenerator.service.sheet.ListSheetService;
import com.example.cpdesignautogenerator.util.PathsUtil;
import com.example.cpdesignautogenerator.writer.ExcelWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelGenerateService {

	public void createExcel() {

		Path tmpDirectoryPath = ConfigParam.getReadDirPath();
		Path shareDirectoryPath = ConfigParam.getWriteDirPath();

		List<Path> javaFilePaths = PathsUtil.getJavaClassPaths(tmpDirectoryPath);

		try (Workbook workbook = new XSSFWorkbook()) {
			
			// クラス名・メソッド名一覧シート作成
			ListSheetService.createSheet(workbook);

			// エクセル出力
			ExcelWriter excelWriter = new ExcelWriter();
			excelWriter.write(shareDirectoryPath, workbook);

		} catch (IOException e) {
			log.error("処理中に異常が発生しました。", e);
		}
	}
}
