package local.jbenito.loggin;

public class LogFactory {
	
	private static LogFactory instance;
	
	private LogFactory() {
		
	}
	
	public static LogFactory getInstance() {
		if (LogFactory.instance == null) {
			LogFactory.instance = new LogFactory();
		}
		return instance;
	}
	
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
