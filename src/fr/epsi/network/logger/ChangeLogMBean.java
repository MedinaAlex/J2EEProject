package fr.epsi.network.logger;

public interface ChangeLogMBean {

	String getNiveau();
	void debug();
	void info();
	void error();

}
