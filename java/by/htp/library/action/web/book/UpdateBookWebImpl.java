package by.htp.library.action.web.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;
import by.htp.library.service.model.Book;

public class UpdateBookWebImpl implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		String brief = request.getParameter("brief");
		int publisher = Integer.parseInt(request.getParameter("publisher"));
		String author = request.getParameter("author");

		System.out.println(id);
		System.out.println(brief);
		System.out.println(publisher);
		System.out.println(author);

		Book book = new Book();
		book.setId(id);
		book.setBrief(brief);
		book.setPublishYear(publisher);
		book.setAuthor(author);

		dao.updateBook(book);

	}

}
