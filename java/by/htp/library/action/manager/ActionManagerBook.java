package by.htp.library.action.manager;

import java.util.HashMap;

import by.htp.library.action.BaseAction;
import by.htp.library.action.web.book.AccordionListBook;
import by.htp.library.action.web.book.AdditionalInfoBook;
import by.htp.library.action.web.book.BookListCreateXLS;
import by.htp.library.action.web.book.BookListFilterImpl;
import by.htp.library.action.web.book.BookListSelectRowImpl;
import by.htp.library.action.web.book.BookListWebImpl;
import by.htp.library.action.web.book.CountReadBookImpl;
import by.htp.library.action.web.book.CreateBookWebImpl;
import by.htp.library.action.web.book.DeleteBookWebImpl;
import by.htp.library.action.web.book.RatingBookIdImpl;
import by.htp.library.action.web.book.SelectBookPageImpl;
import by.htp.library.action.web.book.UpdateBookWebImpl;
import by.htp.library.action.web.book.UploadAdditionalInfoBook;
import by.htp.library.action.web.communion.CreateRentingImpl;
import by.htp.library.action.web.employee.LoadAccauntEmployeeWebImpl;
import by.htp.library.action.web.employee.UpdateEmployeeWebImpl;
import by.htp.library.action.web.issue.IssueBookFilterImpl;
import by.htp.library.action.web.issue.IssueBookFindRowImpl;
import by.htp.library.action.web.issue.IssueBookListImpl;
import by.htp.library.action.web.renting.RentListWebImpl;
import by.htp.library.constants.ActionNameConstant;

public class ActionManagerBook {

	public static BaseAction defineAction(String action) {
		
		System.out.println("book action: " + action);

		HashMap<String, Object> listAction = new HashMap<>();
		
		listAction.put(ActionNameConstant.ACTION_ROUD_BOOKS, new CountReadBookImpl());
		listAction.put(ActionNameConstant.ACTION_READ_ALL_BOOK_1, new BookListWebImpl());
		listAction.put(ActionNameConstant.ACTION_CREATE_BOOK, new CreateBookWebImpl());
		listAction.put(ActionNameConstant.ACTION_UPDATE_BOOK, new UpdateBookWebImpl());
		listAction.put(ActionNameConstant.ACTION_DELETE_BOOK, new DeleteBookWebImpl());
		listAction.put(ActionNameConstant.ACTION_FIND_BOOK, new BookListFilterImpl());
		listAction.put(ActionNameConstant.ACTION_CREATE_XLS_BOOK, new BookListCreateXLS());
		listAction.put(ActionNameConstant.ACTION_SELECT_BOOK_ID, new BookListSelectRowImpl());
		listAction.put(ActionNameConstant.ACTION_ISSUE_BOOK_REPORT, new IssueBookListImpl());
		listAction.put(ActionNameConstant.ACTION_ACC_LIST_BOOK, new AccordionListBook());
		listAction.put(ActionNameConstant.ACTION_ISSUE_BOOK_FIND_ROW, new IssueBookFindRowImpl());
		listAction.put(ActionNameConstant.ACTION_FILTER_ISSUE, new IssueBookFilterImpl());
		listAction.put(ActionNameConstant.ACTION_RATING, new RatingBookIdImpl());
		listAction.put(ActionNameConstant.ACTION_ADDITIONAL_INFO, new AdditionalInfoBook());
		listAction.put(ActionNameConstant.ACTION_UPDATE_ADDITIONAL_INFORMATION, new UploadAdditionalInfoBook());
		listAction.put(ActionNameConstant.ACTION_CREATE_RENT, new CreateRentingImpl());
		listAction.put(ActionNameConstant.ACTION_READ_ALL_RENT, new RentListWebImpl());
		listAction.put(ActionNameConstant.ACTION_UPDATE_EMPLOYEE, new UpdateEmployeeWebImpl());
		listAction.put(ActionNameConstant.ACTION_SELECT_ACCOUNT_EMPLOYEE, new LoadAccauntEmployeeWebImpl());
		listAction.put(ActionNameConstant.ACTION_SELECT_BOOK_PAGE, new SelectBookPageImpl());
		

		BaseAction act = null;
		act = (BaseAction) listAction.get(action);
		return act;
	}

}
