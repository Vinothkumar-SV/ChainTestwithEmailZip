package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	public static void refreshEclipse() {
        try {
        	 String eclipsePath = "C:\\Users\\admin\\eclipse\\java-2024-12\\eclipse\\eclipse.exe";

             // Start Eclipse with a refresh argument (if supported)
             ProcessBuilder processBuilder = new ProcessBuilder(eclipsePath, "-refresh");
             processBuilder.directory(new File("C:\\Users\\admin\\eclipse\\java-2024-12\\eclipse"));
             processBuilder.start();
             System.out.println("Eclipse workspace refreshed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void refreshReport() {
		File reportFolder = new File("./target");

		if (reportFolder.exists()) {
			deleteDirectory(reportFolder);
		}

		// Recreate the folder
		reportFolder.mkdir();
	}

	private static void deleteDirectory(File file) {
		if (file.isDirectory()) {
			for (File subFile : file.listFiles()) {
				deleteDirectory(subFile);
			}
		}
		file.delete();
	}

	public static void zipFolder(String sourceFolder, String zipFilePath) throws IOException {

		FileOutputStream fos = new FileOutputStream(zipFilePath);
		ZipOutputStream zos = new ZipOutputStream(fos);
		File folder = new File(sourceFolder);
		zipFile(folder, folder.getName(), zos);
		zos.close();
		fos.close();
	}

	private static void zipFile(File fileToZip, String fileName, ZipOutputStream zos) throws IOException {
		if (fileToZip.isHidden()) {
			return;
		}
		if (fileToZip.isDirectory()) {
			if (fileName.endsWith("/")) {
				zos.putNextEntry(new ZipEntry(fileName));
				zos.closeEntry();
			} else {
				zos.putNextEntry(new ZipEntry(fileName + "/"));
				zos.closeEntry();
			}
			File[] children = fileToZip.listFiles();
			for (File childFile : children) {
				zipFile(childFile, fileName + "/" + childFile.getName(), zos);
			}
			return;
		}
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		fis.close();
	}

}
