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
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;
import by.htp.library.service.model.Book;

public class BookListFilterImpl implements BaseAction {

	private BookDao dao = new BookDaoMySql();	

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String text = request.getParameter("text");
		Book book = new Book(); 
		book.setBrief(text); 

		Map<String, List<Book>> books = dao.findBook(book);

		PrintWriter out = response.getWriter();

		if (books != null) {
			String json = new Gson().toJson(books);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("BookListFilterImpl", "BookDao");
			out.print(answer);
			out.close();
		}

	}

}
