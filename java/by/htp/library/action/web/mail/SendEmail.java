package by.htp.library.action.web.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.htp.library.action.BaseAction;
import by.htp.library.action.util.NoDataReply;
import by.htp.library.bean.Employee;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.EmployeeBookDao;
import by.htp.library.dao.impl.EmployeeBookDaoMySql;
import by.htp.library.service.model.IssueBook;

public class SendEmail implements BaseAction {

	private EmployeeBookDao dao = new EmployeeBookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String text = request.getParameter("value");

		String[] strArr;
		strArr = text.split("/");

		long dateOn = Long.parseLong(strArr[1]);
		int idBook = Integer.parseInt(strArr[2]);
		int idEmployee = Integer.parseInt(strArr[3]);
		String nameBook = strArr[4];
		String nameEmployee = strArr[5];
		String status = strArr[6];

		IssueBook issueBook = new IssueBook();
		issueBook.setDateOn(dateOn);
		issueBook.setIdBook(idBook);
		issueBook.setIdEmployee(idEmployee);
		issueBook.setNameBook(nameBook);
		issueBook.setNameEmployee(nameEmployee);
		issueBook.setStatus(status);

		List<Employee> issueBooks = dao.sendEmail(issueBook);

		PrintWriter out = response.getWriter();

		if (issueBooks != null) {
			String json = new Gson().toJson(issueBooks);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("SendEmail", "Email");
			out.print(answer);
			out.close();
		}

	}

}
