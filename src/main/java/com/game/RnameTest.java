package com.game;

import java.io.File;
import java.util.Iterator;

public class RnameTest {
	public static void main(String[] args) {
		String rootPath = "C:\\dev\\works\\html\\img";
		String targetPath = "C:\\dev\\works\\html\\img\\cards\\";
		File rootFile = new File(rootPath);
		File[] dirs = rootFile.listFiles();
		int num = 0;
		for(File dir : dirs) {
			if(dir.isDirectory()) {
				File[] files = dir.listFiles();
				for(File file : files) {
					File targetFile = new File(targetPath+(num++)+".png");
					file.renameTo(targetFile);
					String name = file.getName();
					System.out.println(name);
				}
			}
		}
	}
}
