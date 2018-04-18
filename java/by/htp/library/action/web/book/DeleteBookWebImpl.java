package by.htp.library.action.web.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;
import by.htp.library.service.model.Book;

public class DeleteBookWebImpl implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		Book book = new Book();
		book.setId(id);

		dao.deleteBook(book);

	}

}
