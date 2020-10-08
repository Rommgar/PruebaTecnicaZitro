package local.jbenito.loggin;

public class LogSystem {
	private LogginInt loggin;
	
	public LogSystem(LogginInt loggin) {
		this.loggin = loggin;
	}
	
	public void send(String log) {
		this.loggin.writeLog(log);
	}
}
