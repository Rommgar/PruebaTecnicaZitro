package local.jbenito.loggin;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public abstract class LogginFileAbs implements LogginInt{
	FileWriter file;
	PrintWriter printWriter;
	File logFile;
	
	public void writeLog(String log) {
		pathExist();
		tryToWrite(log);
		closeFile();
	}
	
	abstract void tryToWrite(String log);
	
	abstract void closeFile();
	
	abstract void pathExist();
	
}
