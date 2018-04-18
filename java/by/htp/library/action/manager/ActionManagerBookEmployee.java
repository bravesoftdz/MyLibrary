package by.htp.library.action.manager;

import java.util.HashMap;

import by.htp.library.action.BaseAction;
import by.htp.library.action.web.employee.EmployeeBookListWebImpl;
import by.htp.library.action.web.issue.CreateBookEmployeeEmpl;
import by.htp.library.action.web.issue.UpdateEmployeeBookImpl;
import by.htp.library.action.web.renting.AnswerRenting;
import by.htp.library.action.web.renting.DeleteRentingBookId;
import by.htp.library.action.web.renting.RentingBookEmployeeId;
import by.htp.library.constants.ActionNameConstant;

public class ActionManagerBookEmployee {

	public static BaseAction defineAction(String action) {

		HashMap<String, Object> listAction = new HashMap<>();
		listAction.put(ActionNameConstant.ACTION_FINDFIRST_REPORT, new EmployeeBookListWebImpl());
		listAction.put(ActionNameConstant.ACTION_CREATE_EMPLOYEE_BOOK, new CreateBookEmployeeEmpl());
		listAction.put(ActionNameConstant.ACTION_UPDATE_BOOK_EMPLOYEE, new UpdateEmployeeBookImpl());
		listAction.put(ActionNameConstant.ACTION_ANSWER_RENTING, new AnswerRenting());
		listAction.put(ActionNameConstant.ACTION_SELECT_BOOK_RENT_EMPLOYEE, new RentingBookEmployeeId());
		listAction.put(ActionNameConstant.ACTION_DELETE_RENTING_BOOK_EMPLOYEE, new DeleteRentingBookId());

		BaseAction act = null;
		act = (BaseAction) listAction.get(action);
		return act;
	}

}
