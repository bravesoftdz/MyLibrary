package by.htp.library.action.web.renting;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.Renting;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;

public class DeleteRentingBookId implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int ibRenting = Integer.valueOf(request.getParameter("idRent"));

		Renting renting = new Renting();
		renting.setIdRent(ibRenting);

		dao.deleteRentingBookEmployee(renting);

	}

}
