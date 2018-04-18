package by.htp.library.action.web.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.htp.library.action.BaseAction;
import by.htp.library.action.util.NoDataReply;
import by.htp.library.bean.Employee;
import by.htp.library.constants.ResponseSetting;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.EmployeeDaoMySql;

public class LoadAccauntEmployeeWebImpl implements BaseAction {

	private EmployeeDao dao = new EmployeeDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int idEmployee = Integer.valueOf(request.getParameter("idEmployee"));
		Employee employee = new Employee();
		employee.setId(idEmployee);

		Map<String, List<Employee>> employes = dao.selectAccountEmployeeId(employee);

		PrintWriter out = response.getWriter();

		if (employes != null) {
			String json = new Gson().toJson(employes);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("LoadAccauntEmployeeConsoleImpl", "Employee");
			out.print(answer);
			out.close();
		}

	}

}
