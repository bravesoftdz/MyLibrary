package by.htp.library.action.web.issue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.EmployeeBook;
import by.htp.library.dao.EmployeeBookDao;
import by.htp.library.dao.impl.EmployeeBookDaoMySql;

public class UpdateEmployeeBookImpl implements BaseAction {

	private EmployeeBookDao dao = new EmployeeBookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("idIssue"));
		long dateReturn = Integer.parseInt(request.getParameter("dateReturn"));
		String status = request.getParameter("status");

		EmployeeBook employeeBook = new EmployeeBook();
		employeeBook.setId(id);
		employeeBook.setDateTimeReturn(dateReturn);
		employeeBook.setStatus(status);

		dao.updateBook(employeeBook);

	}
}
