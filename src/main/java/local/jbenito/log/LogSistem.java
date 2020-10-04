package local.jbenito.log;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class LogSistem {
	public static synchronized void printLog(String gableString) {
		System.out.println(gableString);
	}

	public static synchronized void fileLog(String log) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		File logFile = checkFiles("/casino-log.txt");
		try {
			file = new FileWriter(logFile, true);
			printWriter = new PrintWriter(file);
			printWriter.println(log);
			;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != file)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static synchronized void fileExceptions(String excep) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		File logFile = checkFiles("/casino-excep.txt");
		try {
			file = new FileWriter(logFile, true);
			printWriter = new PrintWriter(file);
			printWriter.println(excep);
			;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != file)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static File checkFiles(String option) {
		String basePath = new File("").getAbsolutePath();
		File logPath = new File(basePath + "/log/");
		existPath(logPath);
		File logFile = new File(logPath.toString() + option);
		return logFile;
	}

	private static void existPath(File pathLog) {
		if (!pathLog.exists()) {
			pathLog.mkdirs();
		}
	}
}
