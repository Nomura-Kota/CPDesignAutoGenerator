package com.example.cpdesignautogenerator.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathsUtil {

	
	public static List<Path> getJavaClassPaths(Path targetPath) {
		
		List<Path> javaFilePaths = new ArrayList<>();
		
		try (Stream<Path> walk = Files.walk(targetPath)) {
			javaFilePaths = walk
					.filter(filePath -> filePath.toString().endsWith(".java"))
					.collect(Collectors.toList());

		} catch (IOException e) {
			System.out.println("[Files.walk]に失敗しました。");
		}
		
		return javaFilePaths;
	}
}
