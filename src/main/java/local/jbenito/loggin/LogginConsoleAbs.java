package local.jbenito.loggin;

public abstract class LogginConsoleAbs implements LogginInt{
	public void writeLog(String log) {
		printLogs(log);
	}
	
	abstract void printLogs(String log);
}
