package by.htp.library.action.web.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.htp.library.action.BaseAction;
import by.htp.library.action.util.NoDataReply;
import by.htp.library.bean.BookCountReadEmployee;
import by.htp.library.bean.EmployeeBook;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.EmployeeBookDao;
import by.htp.library.dao.impl.EmployeeBookDaoMySql;

public class EmployeeBookListWebImpl implements BaseAction {

	private EmployeeBookDao dao = new EmployeeBookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String count = request.getParameter("count");
		EmployeeBook employeeBook = new EmployeeBook();
		employeeBook.setId(Integer.valueOf(count));

		Map<String, List<BookCountReadEmployee>> employeeBooks = dao.findFirstReport(employeeBook);

		PrintWriter out = response.getWriter();

		if (employeeBooks != null) {
			String json = new Gson().toJson(employeeBooks);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("EmployeeBookListConsoleImpl", "Employee");
			out.print(answer);
			out.close();
		}

	}

}
