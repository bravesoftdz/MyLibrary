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

public class IssueBookFindRowImpl implements BaseAction {

	private EmployeeBookDao dao = new EmployeeBookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.valueOf(request.getParameter("idIssue"));
		
		IssueBook issueBook = new IssueBook();
		issueBook.setIdIssue(id);

		Map<String, List<IssueBook>> issueAnswer = dao.issueBookFindRow(issueBook);

		PrintWriter out = response.getWriter();

		if (issueAnswer != null) {
			String json = new Gson().toJson(issueAnswer);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("IssueBookFindRowImpl", "IssueBook");
			out.print(answer);
			out.close();
		}

	}

}

