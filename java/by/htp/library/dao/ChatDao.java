package by.htp.library.dao;

import java.util.List;
import java.util.Map;

import by.htp.library.bean.Chat;
import by.htp.library.bean.Employee;

public interface ChatDao {
	
	Map<String, List<Chat>> writeMessage(Chat chat);
	Map<String, List<Chat>> readMessage();
	Map<String, List<Employee>> selectChatUsers(Employee employee);
}
