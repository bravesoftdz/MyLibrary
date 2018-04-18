package by.htp.library.action.web.issue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.htp.library.action.BaseAction;
import by.htp.library.action.util.NoDataReply;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.EmployeeBookDao;
import by.htp.library.dao.impl.EmployeeBookDaoMySql;
import by.htp.library.service.model.IssueBook;

public class IssueBookFilterImpl implements BaseAction {

	private EmployeeBookDao dao = new EmployeeBookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String text = request.getParameter("text");
		IssueBook issueBook = new IssueBook();
		issueBook.setNameEmployee(text);

		Map<String, List<IssueBook>> issueBookAnswer = dao.filterIssue(issueBook);

		PrintWriter out = response.getWriter();

		if (issueBookAnswer != null) {
			String json = new Gson().toJson(issueBookAnswer);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("IssueBookFilterImpl", "IssueBook");
			out.print(answer);
			out.close();
		}

	}

}
