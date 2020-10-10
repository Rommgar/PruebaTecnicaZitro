package local.jbenito.loggin;

public class LogginConsole extends LogginConsoleAbs{
	
	private static LogginConsole instance;
	
	private LogginConsole() {
		
	}
	
	public static LogginConsole getInstance() {
		if (instance == null) {
			instance = new LogginConsole();
		}
		return instance;
	}
	
	@Override
	void printLogs(String log) {
		System.out.println(log);
	}

}
