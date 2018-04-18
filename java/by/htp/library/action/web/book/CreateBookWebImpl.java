package by.htp.library.action.web.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;
import by.htp.library.service.model.Book;

public class CreateBookWebImpl implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		String brief = request.getParameter("brief");
		int publisher = Integer.parseInt(request.getParameter("publisher"));
		String author = request.getParameter("author");

		Book book = new Book();
		book.setBrief(brief);
		book.setAuthor(author);
		book.setPublishYear(publisher);

		dao.createBook(book);

	}

}
