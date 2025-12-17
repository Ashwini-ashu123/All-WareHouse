package Utility;

import java.io.File;

public class DownLoadHelper {
	
public static boolean isFileDownloaded(String downloadPath, String fileName) {
    File dir = new File(downloadPath);
    File[] dirContents = dir.listFiles();

    if (dirContents == null) {
        return false;
    }

    for (File file : dirContents) {
        if (file.getName().equals(fileName)) {
            return true;
        }
    }
    return false;
}

}