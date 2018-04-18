package by.htp.library.action.manager;

import java.util.HashMap;

import by.htp.library.action.BaseAction;
import by.htp.library.action.web.employee.CreateEmployeeWebImpl;
import by.htp.library.action.web.employee.DeleteEmployeeWebImpl;
import by.htp.library.action.web.employee.EmployeeEntranceWebImpl;
import by.htp.library.action.web.employee.EmployeeListCreateXLS;
import by.htp.library.action.web.employee.EmployeeListFilterImpl;
import by.htp.library.action.web.employee.EmployeeListSelectRowImpl;
import by.htp.library.action.web.employee.EmployeeListWebImpl;
import by.htp.library.action.web.employee.EmployeeWriteVisiterImpl;
import by.htp.library.constants.ActionNameConstant;

public class ActionManagerEmployee {

	public static BaseAction defineAction(String action) {

		HashMap<String, Object> listAction = new HashMap<>();
		listAction.put(ActionNameConstant.ACTION_READ_ALL_EMPLOYEE, new EmployeeListWebImpl());
		listAction.put(ActionNameConstant.ACTION_ENTRANCE_USER, new EmployeeEntranceWebImpl());
		listAction.put(ActionNameConstant.ACTION_CREATE_EMPLOYEE_8, new CreateEmployeeWebImpl());
		listAction.put(ActionNameConstant.ACTION_FIND_EMPLOYEE, new EmployeeListFilterImpl());
		listAction.put(ActionNameConstant.ACTION_DELETE_EMPLOYEE, new DeleteEmployeeWebImpl());
		listAction.put(ActionNameConstant.ACTION_CREATE_XLS_EMPLOYEE, new EmployeeListCreateXLS());
		listAction.put(ActionNameConstant.ACTION_SELECT_EMPLOYEE_ID, new EmployeeListSelectRowImpl());
		listAction.put(ActionNameConstant.ACTION_CREATE_EMPLOYEE_21, new CreateEmployeeWebImpl());
		listAction.put(ActionNameConstant.ACTION_WRITE_VISITERS, new EmployeeWriteVisiterImpl());

		BaseAction act = null;
		act = (BaseAction) listAction.get(action);
		return act;
	}

}
