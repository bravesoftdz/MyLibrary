package by.htp.library.action.web.communion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.Renting;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;

public class CreateRentingImpl implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int idBook = Integer.valueOf(request.getParameter("idBook"));
		int idEmployee = Integer.valueOf(request.getParameter("idEmployee"));
		int dateOn = Integer.valueOf(request.getParameter("dateOn"));
		String status = request.getParameter("status");

		Renting renting = new Renting();
		renting.setIdBook(idBook);
		renting.setIdEmployee(idEmployee);
		renting.setDateOnRenting(dateOn);
		renting.setStatusRenting(status);

		dao.createRent(renting);

	}

}
