package by.htp.library.action.manager;

import java.util.HashMap;

import by.htp.library.action.BaseAction;
import by.htp.library.action.web.chat.WriteMessageChatImpl;
import by.htp.library.constants.ActionNameConstant;

public class ActionManagerChat {

public static BaseAction defineAction(String action) {
		
		System.out.println("chat action: " + action);

		HashMap<String, Object> listAction = new HashMap<>();
		
		listAction.put(ActionNameConstant.ACTION_WRITE_MESSAGE, new WriteMessageChatImpl());
		
		//	public static final String ACTION_SEND_MESSAGE = "sendMessage";

		BaseAction act = null;
		act = (BaseAction) listAction.get(action);
		return act;
	}
	
	
}
