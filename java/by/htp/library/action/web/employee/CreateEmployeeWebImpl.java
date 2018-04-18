package by.htp.library.action.web.employee;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.Employee;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.EmployeeDaoMySql;

public class CreateEmployeeWebImpl implements BaseAction {

	private EmployeeDao dao = new EmployeeDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		Long dateBirth = Long.parseLong(request.getParameter("dateBirth"));
		String statusAdmin = request.getParameter("statusAdmin");

		System.out.println(login);
		System.out.println(password);
		System.out.println(fullName);
		System.out.println(email);
		System.out.println(dateBirth);
		System.out.println(statusAdmin);
		
		Employee employee = new Employee();
		employee.setUserLoggin(login);
		employee.setUserPassword(password);
		employee.setName(fullName);
		employee.setEmail(email);
		employee.setDateBirth(dateBirth);
		employee.setSatatusAdmin(statusAdmin);

		dao.createEmployee(employee);

	}
}
