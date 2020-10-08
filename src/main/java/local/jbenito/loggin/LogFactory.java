package local.jbenito.loggin;

public class LogFactory {
	public LogSystem LogFile() {
		return new LogSystem(new LogginFile());
	}
	public LogSystem LogConsole() {
		return new LogSystem(new LogginConsole());
	}
	public LogSystem LogNull() {
		return null;
	}
}
