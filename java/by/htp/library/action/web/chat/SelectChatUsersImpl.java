package by.htp.library.action.web.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.htp.library.action.BaseAction;
import by.htp.library.action.util.NoDataReply;
import by.htp.library.bean.Employee;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.ChatDao;
import by.htp.library.dao.impl.ChatDaoMySql;

public class SelectChatUsersImpl implements BaseAction {

	private ChatDao dao = new ChatDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String loginUser = request.getParameter("login");

		Employee employee = new Employee();
		employee.setUserLoggin(loginUser);

		Map<String, List<Employee>> chatArr = dao.selectChatUsers(employee);

		PrintWriter out = response.getWriter();

		if (chatArr != null) {
			String json = new Gson().toJson(chatArr);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("SelectChatUsersImpl", "ChatDao");
			out.print(answer);
			out.close();
		}

	}

}
