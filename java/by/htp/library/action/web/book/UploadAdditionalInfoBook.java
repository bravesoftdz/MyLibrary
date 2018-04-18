package by.htp.library.action.web.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.BookAdditionalInfo;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySql;

public class UploadAdditionalInfoBook implements BaseAction {

	private BookDao dao = new BookDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int idBook = Integer.parseInt(request.getParameter("idBook"));
		String discriptrion = request.getParameter("discriptionBook");
		String imgEnCode = request.getParameter("imgEnCode");
		
		

		BookAdditionalInfo bookAdditionalInfo = new BookAdditionalInfo();
		bookAdditionalInfo.setIdBook(idBook);
		bookAdditionalInfo.setDiscriptionBook(discriptrion);
		bookAdditionalInfo.setNameImgBook(imgEnCode);

		dao.updateAdditionalInformation(bookAdditionalInfo);

	}

}
