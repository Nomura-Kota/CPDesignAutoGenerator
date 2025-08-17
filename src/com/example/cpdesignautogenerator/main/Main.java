package com.example.cpdesignautogenerator.main;

import com.example.cpdesignautogenerator.config.ConfigParam;
import com.example.cpdesignautogenerator.service.ExcelGenerateService;

import lombok.extern.slf4j.Slf4j;

/**
 * メインクラスです。
 */
@Slf4j
public class Main {
	public static void main(String[] args) {

		ConfigParam.logInitialize();

		log.info("CP設計出力処理 開始");

		ExcelGenerateService excelGenerateService = new ExcelGenerateService();
		excelGenerateService.createExcel();

		log.info("CP設計出力処理 終了");

	}
}

//		// Excel作成
//		Workbook workbook = new XSSFWorkbook();
//		Sheet sheet = workbook.createSheet("テストシート");
//
//		// ヘッダー
//		Row header = sheet.createRow(0);
//		header.createCell(0).setCellValue("No");
//		header.createCell(1).setCellValue("クラス名");
//		header.createCell(2).setCellValue("メソッド名");
//
//		int currentRowIndex = 1; // データを書き込む行番号（1行目はヘッダーなので2行目から）
//		int currentNumbering = 1; // 「No」列に出力する連番
//
//		//　各javaファイル解析
//		try {
//			for (Path javaFilePath : javaFilePaths) {
//				CompilationUnit compilationUnit = StaticJavaParser.parse(javaFilePath);
//
//				// クラスごとの処理
//				for (ClassOrInterfaceDeclaration classDeclaration : compilationUnit
//						.findAll(ClassOrInterfaceDeclaration.class)) {
//
//					// パッケージ宣言付きのクラス名
//					String className = compilationUnit.getPackageDeclaration()
//							.map(pd -> pd.getNameAsString() + "." + classDeclaration.getNameAsString())
//							.orElse(classDeclaration.getNameAsString());
//
//					// メソッドごとの処理
//					for (MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
//						Row row = sheet.createRow(currentRowIndex++);
//						row.createCell(0).setCellValue(currentNumbering++);
//						row.createCell(1).setCellValue(className);
//						row.createCell(2).setCellValue(methodDeclaration.getNameAsString());
//					}
//				}
//			}
//
//		} catch (IOException e) {
//			System.out.println("Javaファイル情報の取得に失敗しました。");
//		}
//		
//		// 列幅自動調整
//        for (int columnIndex = 0; columnIndex <= 2; columnIndex++) {
//            sheet.autoSizeColumn(columnIndex);
//        }
//		
//        Path shareDirectoryPath = ConfigParam.getWriteDirPath();
//        
//        ExcelWriter excelWriter = new ExcelWriter();
//        excelWriter.write(shareDirectoryPath, workbook);
