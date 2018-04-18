package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.library.bean.Chat;
import by.htp.library.bean.Employee;
import by.htp.library.constants.SQLConstants;
import by.htp.library.dao.ChatDao;

public class ChatDaoMySql implements ChatDao {

	Connector connector = new Connector();

	{
		try {
			Class.forName(connector.getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, List<Chat>> readMessage() {

		List<Chat> listMsg = new ArrayList<>();
		Map<String, List<Chat>> arrChatMessage = new HashMap<String, List<Chat>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQLConstants.SQL_READ_CHAT_MSG);
			while (rs.next()) {
				Chat ch = new Chat();
				ch.setIdMessage(rs.getInt("id"));
				ch.setDateOn(rs.getLong("dateOn"));
				ch.setFromUser(rs.getString("fromUser"));
				ch.setToUser(rs.getString("toUser"));
				ch.setMessage(rs.getString("message"));
				listMsg.add(ch);
			}
			arrChatMessage.put("msgList", listMsg);

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
		return arrChatMessage;
	}

	@Override
	public Map<String, List<Chat>> writeMessage(Chat chat) {

		List<Chat> listMsg = new ArrayList<>();
		Map<String, List<Chat>> arrChatMessage = new HashMap<String, List<Chat>>();

		long dateOn = chat.getDateOn();
		String fromUser = chat.getFromUser();
		String toUser = chat.getToUser();
		String message = chat.getMessage();

		if (chat != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_WRITE_CHAT_MSG);
				ps.setLong(1, dateOn); 
				ps.setString(2, fromUser);
				ps.setString(3, toUser); 
				ps.setString(4, message); 
				ps.executeUpdate();

				System.out.println("dateOnImpl: " + dateOn);
				System.out.println("fromUserImpl: " + fromUser);
				System.out.println("toUserImpl: " + toUser);
				System.out.println("messageImpl: " + message);

				Chat ch = new Chat();
				ch.setDateOn(dateOn);
				ch.setFromUser(fromUser);
				ch.setToUser(toUser);
				ch.setMessage(message);

				listMsg.add(ch);
				arrChatMessage.put("msg", listMsg);

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
		
		return arrChatMessage;
	}

	@Override
	public Map<String, List<Employee>> selectChatUsers(Employee employee) {

		List<Employee> listUsers = new ArrayList<>();
		Map<String, List<Employee>> arrChatUsers = new HashMap<String, List<Employee>>();
		
		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String loggin = employee.getUserLoggin();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_CHAT_USER);
			ps.setString(1, loggin);
			ResultSet results = ps.executeQuery();
			
			while (results.next()) {
				Employee empl = new Employee();
				empl.setUserLoggin(results.getString("LOGIN"));
				listUsers.add(empl);
			}
			arrChatUsers.put("listChatUsers", listUsers);

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
		
		return arrChatUsers;
	}
}
