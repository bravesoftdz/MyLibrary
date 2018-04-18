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
import by.htp.library.bean.BookAdditionalInfo;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;

public class AdditionalInfoBook implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.valueOf(request.getParameter("idBook"));

		BookAdditionalInfo bookAdditionalInfo = new BookAdditionalInfo();
		bookAdditionalInfo.setIdBook(id);

		Map<String, List<BookAdditionalInfo>> ratingAnswer = dao.additionalInfo(bookAdditionalInfo);

		PrintWriter out = response.getWriter();

		if (ratingAnswer != null) {
			String json = new Gson().toJson(ratingAnswer);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("AdditionalInfoBook", "BookDao");
			out.print(answer);
			out.close();
		}

	}

}
