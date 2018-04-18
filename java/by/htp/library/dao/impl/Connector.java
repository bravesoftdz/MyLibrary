package by.htp.library.dao.impl;

import java.util.ResourceBundle;

public class Connector {

	public String[] getConnectInitValue() {
		ResourceBundle rb = ResourceBundle.getBundle("db_config");
		String dbURL = rb.getString("db.url");
		String user = rb.getString("db.login");
		String pass = rb.getString("db.pass");
		String driver = rb.getString("db.driver.name");
		return new String[] { dbURL, user, pass, driver };
	}

}
