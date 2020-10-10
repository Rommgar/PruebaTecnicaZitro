package local.jbenito.loggin;

public class LogFactory {
	public LogSystem LogFile() {
		return new LogSystem(LogginFile.getInstance());
	}
	public LogSystem LogConsole() {
		return new LogSystem(LogginConsole.getInstance());
	}
	public LogSystem LogNull() {
		return null;
	}
}
