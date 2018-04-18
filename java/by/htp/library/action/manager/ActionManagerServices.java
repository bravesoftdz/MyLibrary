package by.htp.library.action.manager;

import java.util.HashMap;

import by.htp.library.action.BaseAction;
import by.htp.library.action.web.chat.ReadMessageChatImpl;
import by.htp.library.action.web.chat.SelectChatUsersImpl;
import by.htp.library.action.web.chat.WriteMessageChatImpl;
import by.htp.library.action.web.mail.SendEmail;
import by.htp.library.constants.ActionNameConstant;

public class ActionManagerServices {	
	
	public static BaseAction defineAction(String action) {
		
		HashMap<String, Object> listAction = new HashMap<>();
		listAction.put(ActionNameConstant.ACTION_SEND_EMAIL, new SendEmail());
		listAction.put(ActionNameConstant.ACTION_WRITE_MESSAGE, new WriteMessageChatImpl());
		listAction.put(ActionNameConstant.ACTION_READ_MESSAGE, new ReadMessageChatImpl());
		listAction.put(ActionNameConstant.ACTION_SELECT_USERS_CHAT, new SelectChatUsersImpl());
		
		BaseAction act = null;		
		act = (BaseAction) listAction.get(action);
		return act;
	}

}
