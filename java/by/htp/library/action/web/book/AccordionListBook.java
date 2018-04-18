package by.htp.library.action.web.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.htp.library.action.BaseAction;
import by.htp.library.action.util.NoDataReply;
import by.htp.library.bean.ListBookAccordionTable;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.EmployeeBookDao;
import by.htp.library.dao.impl.EmployeeBookDaoMySql;

public class AccordionListBook implements BaseAction {

	private EmployeeBookDao dao = new EmployeeBookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int idEmployee = Integer.valueOf(request.getParameter("idEmployee"));
		ListBookAccordionTable listBookAccordionTable = new ListBookAccordionTable();
		listBookAccordionTable.setIdEmployee(idEmployee);

		Map<String, List<ListBookAccordionTable>> employeeBooks = dao.accListBook(listBookAccordionTable);

		PrintWriter out = response.getWriter();

		if (employeeBooks != null) {
			String json = new Gson().toJson(employeeBooks);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("AccordionListBook", "BookDao");
			out.print(answer);
			out.close();
		}

	}

}
