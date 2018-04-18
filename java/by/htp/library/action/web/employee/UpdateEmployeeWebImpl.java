package by.htp.library.action.web.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.Employee;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.EmployeeDaoMySql;

public class UpdateEmployeeWebImpl implements BaseAction {

	private EmployeeDao dao = new EmployeeDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("idEmployee"));
		String name = request.getParameter("nameEmployee");
		String email = request.getParameter("emailEmployee");
		long dateBirth = Long.parseLong(request.getParameter("dateBirthEmployee"));
		String photoEmployee = request.getParameter("photoEmployee");
		String tellEmployee = request.getParameter("tellEmployee");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setDateBirth(dateBirth);
		employee.setPhotoEmployee(photoEmployee);
		employee.setTellNumber(tellEmployee);

		dao.updateEmployee(employee);

	}

}
