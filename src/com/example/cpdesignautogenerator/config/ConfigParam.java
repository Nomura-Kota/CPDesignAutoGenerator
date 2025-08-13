package com.example.cpdesignautogenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigParam {

	/** インスタンス */
	static ConfigParam configParam;
	/** 読込ディレクトリ */
	Path readDirPath;
	/** 書込ディレクトリ */
	Path writeDirPath;

	public static void logInitialize() {

		configParam = new ConfigParam();

		Properties props = new Properties();
		String confPath = System.getProperty("conf.path");

		try (FileInputStream fis = new FileInputStream(confPath)) {
			props.load(fis);
		} catch (IOException e) {
			log.error("設定ファイルの読込に失敗しました。", e);
			System.exit(1);
		}

		try {
			String strReadDirPath = props.getProperty("READ_DIR_PATH");
			String strWriteDirPath = props.getProperty("WRITE_DIR_PATH");
			
			// ここでエラー処理をするといいかも

			configParam.readDirPath = Paths.get(strReadDirPath);
			configParam.writeDirPath = Paths.get(strWriteDirPath);
		} catch (Exception e) {
			log.error("設定ファイルの値を確認してください。", e);
		}

		log.info("設定ファイルの読込が完了しました。");
	}
	
	public static Path getReadDirPath() {
		return configParam.readDirPath;
	}
	
	public static Path getWriteDirPath() {
		return configParam.writeDirPath;
	}
}
