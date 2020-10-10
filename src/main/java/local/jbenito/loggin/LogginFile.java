package local.jbenito.loggin;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class LogginFile extends LogginFileAbs {
	
	private static LogginFile instance;
	
	private LogginFile() {
	}
	
	public static LogginFile getInstance() {
		if (instance == null) {
			instance = new LogginFile();
		}
		return instance;
	}
	
	
	@Override
	void tryToWrite(String log) {
		try {
			file = new FileWriter(logFile, true);
			printWriter = new PrintWriter(file);
			printWriter.println(log);
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void closeFile() {
		try {
			if (null != file)
				file.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	@Override
	void pathExist() {
		String basePath = new File("").getAbsolutePath();
		File logPath = new File(basePath + "/log/");
		if (!logPath.exists()) {
			logPath.mkdirs();
		}
		this.logFile = new File(logPath.toString() + "/casino-log.txt");
		
	}

}
