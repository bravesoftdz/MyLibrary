package by.htp.library.action.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import by.htp.library.constants.LoggerConst;
import by.htp.library.constants.SQLConstants;
import by.htp.library.dao.impl.Connector;

public class LoggerUserAction {

	Connector connector = new Connector();
	StackTraceElement ste = Thread.currentThread().getStackTrace()[2];

	{
		try {
			Class.forName(connector.getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void infoLog(String msgLog, String methodName) {
		try {
			String log = msgLog;
			LoggerUserAction loggerUserAction = new LoggerUserAction();
			loggerUserAction.writeLogFile(LoggerConst.TUPE_INFO, log, methodName + " " + ste);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void errorLog(String msgLog, String methodName) {
		try {
			String log = msgLog;
			LoggerUserAction loggerUserAction = new LoggerUserAction();
			loggerUserAction.writeLogFile(LoggerConst.TUPE_ERROR, log, methodName + " " + ste);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void notifactionLog(String msgLog, String methodName) {
		try {
			String log = msgLog;
			LoggerUserAction loggerUserAction = new LoggerUserAction();
			loggerUserAction.writeLogFile(LoggerConst.TUPE_NOTIFACTION, log, methodName + " " + ste);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeLogFile(String typeLog, String log, String methodName) throws IOException {

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];
			cn = DriverManager.getConnection(url, login, pass);
			Date dateOn = new Date();
			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_WRITE_LOG);
			ps.setString(1, dateOn.toString());
			ps.setString(2, typeLog);
			ps.setString(3, log);
			ps.setString(4, methodName);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
