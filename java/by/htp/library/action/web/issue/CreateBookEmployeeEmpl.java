package by.htp.library.action.web.issue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.EmployeeBook;
import by.htp.library.dao.EmployeeBookDao;
import by.htp.library.dao.impl.EmployeeBookDaoMySql;

public class CreateBookEmployeeEmpl implements BaseAction {

	private EmployeeBookDao dao = new EmployeeBookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int idEmployee = Integer.valueOf(request.getParameter("idEmployee"));
		int idBook = Integer.valueOf(request.getParameter("idBook"));
		long dateOn = Long.valueOf(request.getParameter("dateOn"));
		long dateOff = Long.valueOf(request.getParameter("dateOff"));
		String status = request.getParameter("status");

		EmployeeBook employeeBook = new EmployeeBook();
		employeeBook.setDateTimeOn(dateOn);
		employeeBook.setDateTimeReturn(dateOff);
		employeeBook.setBookId(idBook);
		employeeBook.setEmployeeId(idEmployee);
		employeeBook.setStatus(status);

		dao.createEmployeeBook(employeeBook); 

	}

}