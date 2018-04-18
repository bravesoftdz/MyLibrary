package by.htp.library.action.web.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.Employee;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.EmployeeDaoMySql;

public class DeleteEmployeeWebImpl implements BaseAction {

	private EmployeeDao dao = new EmployeeDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		Employee employee = new Employee();
		employee.setId(id);

		dao.deleteEmployee(employee);

	}

}
