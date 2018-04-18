package by.htp.library.action.web.renting;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.Renting;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;

public class AnswerRenting implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int ibRenting = Integer.valueOf(request.getParameter("idRenting"));
		String emailEmployee = request.getParameter("emailEmployee");
		long dateOnEmployee = Integer.valueOf(request.getParameter("dateOnEmployee"));
		String bookName = request.getParameter("bookName");
		
		Renting renting = new Renting();
		renting.setIdRent(ibRenting);
		renting.setEmailEmployee(emailEmployee);
		renting.setDateOnRenting(dateOnEmployee);
		renting.setNameBook(bookName);	
		
		dao.anserRenting(renting);

	}

}
