package by.htp.library.action.web.employee;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.action.BaseAction;
import by.htp.library.bean.Visiters;
import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.impl.EmployeeDaoMySql;

public class EmployeeWriteVisiterImpl implements BaseAction {

	private EmployeeDao dao = new EmployeeDaoMySql();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String ip = request.getParameter("ipVisit");
		String countryCode = request.getParameter("countryCode");
		String countyName = request.getParameter("countyName");
		String regionCode = request.getParameter("regionCode");
		String regionName = request.getParameter("regionName");
		String city = request.getParameter("city");
		String zipCode = request.getParameter("zipCode");
		String timeZone = request.getParameter("timeZone");
		double latitude = Double.valueOf(request.getParameter("latitude"));
		double langitude = Double.valueOf(request.getParameter("langitude"));
		int metroCode = Integer.valueOf(request.getParameter("metroCode"));	
		

		Visiters visiters = new Visiters();		
		

		visiters.setIP(ip);
		visiters.setCountryCode(countryCode);
		visiters.setCountyName(countyName);
		visiters.setRegionCode(regionCode);
		visiters.setRegionName(regionName);
		visiters.setCity(city);
		visiters.setZipCode(zipCode);
		visiters.setTimeZone(timeZone);
		visiters.setLatitude(latitude);
		visiters.setLangitude(langitude);
		visiters.setMetroCode(metroCode);		

		dao.writeVisiters(visiters);

	}

}
