package by.htp.library.dao.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import by.htp.library.action.util.EmailSender;
import by.htp.library.action.util.Encryption;
import by.htp.library.action.util.LoggerUserAction;
import by.htp.library.bean.Employee;
import by.htp.library.bean.Visiters;
import by.htp.library.constants.Pathes;
import by.htp.library.constants.SQLConstants;
import by.htp.library.constants.TimeZones;
import by.htp.library.dao.EmployeeDao;

public class EmployeeDaoMySql implements EmployeeDao {

	LoggerUserAction loggerUserAction = new LoggerUserAction();

	Connector connector = new Connector();

	{
		try {
			Class.forName(connector.getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, List<Employee>> readAllEmployee() {
		List<Employee> list = new ArrayList<>();
		Map<String, List<Employee>> arrEmployee = new HashMap<String, List<Employee>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQLConstants.SQL_SELECT_EMPLOYEE);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setName(rs.getString("NAME"));
				employee.setDateBirth(rs.getInt("DATE_OF_BIRTH"));
				employee.setEmail(rs.getString("EMAIL"));
				list.add(employee);
			}
			arrEmployee.put("employee", list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrEmployee;
	}

	@Override
	public void createEmployee(Employee employee) {
		if (employee != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				Encryption encription = new Encryption();

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_CREATE_EMPLOYEE);

				ps.setString(1, employee.getName()); // fullName
				ps.setLong(2, employee.getDateBirth()); // dateUnix
				ps.setString(3, employee.getEmail()); // email
				ps.setString(4, employee.getUserLoggin()); // login
				ps.setString(5, encription.enCodePassword(employee.getUserPassword())); // password
				ps.setString(6, employee.getSatatusAdmin()); // statusAdmin

				String email = employee.getEmail();
				String subject = "Registration new user";
				String bodyMessage = "Dear " + employee.getName() + " welcome to our library.\r\n"
						+ "You have registered with our system.\r\n" + "Your data:\r\n" + "login:"
						+ employee.getUserLoggin() + "\r\n" + "password:" + employee.getUserPassword() + "\r\n"
						+ "Some data you can change in your account.\r\n"
						+ "-------------------------------------------------- -----------------------------------";
				EmailSender emailSender = new EmailSender();
				emailSender.sendingEmail(email, subject, bodyMessage);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (cn != null) {
						cn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void updateEmployee(Employee entity) {
		if (entity != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_UPDATE_EMPLOYEE);

				ps.setString(1, entity.getName());
				ps.setLong(2, entity.getDateBirth());
				ps.setString(3, entity.getEmail());
				ps.setString(4, entity.getPhotoEmployee());
				ps.setString(5, entity.getTellNumber());
				ps.setInt(6, entity.getId());
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (cn != null) {
						cn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void deleteEmployee(Employee entity) {
		if (entity != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_DELETE_EMPLOYEE);
				ps.setInt(1, entity.getId()); // ID
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (cn != null) {
						cn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Map<String, List<Employee>> findEmployee(Employee entity) {
		List<Employee> list = new ArrayList<>();
		Map<String, List<Employee>> arrEmployee = new HashMap<String, List<Employee>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String txt = entity.getName();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_FILTER_EMPLOYEE);
			ps.setString(1, txt); // text_1
			ps.setString(2, txt); // text_2
			ps.setString(3, txt); // text_3
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				Employee employee = new Employee();
				employee.setId(results.getInt("ID"));
				employee.setName(results.getString("NAME"));
				employee.setDateBirth(results.getInt("DATE_OF_BIRTH"));
				employee.setEmail(results.getString("EMAIL"));
				list.add(employee);
			}
			arrEmployee.put("employee", list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrEmployee;
	}

	@SuppressWarnings("resource")
	@Override
	public List<Employee> createXLS(Employee entity) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("employee");

		List<Employee> employeeList = new ArrayList<>();

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String txt = entity.getName();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_FILTER_EMPLOYEE);
			ps.setString(1, txt); // text_1
			ps.setString(2, txt); // text_2
			ps.setString(3, txt); // text_3
			ResultSet results = ps.executeQuery();
			while (results.next()) {

				Employee employee = new Employee();
				employee.setId(results.getInt("ID"));
				employee.setName(results.getString("NAME"));
				employee.setDateBirth(results.getInt("DATE_OF_BIRTH"));
				employee.setEmail(results.getString("EMAIL"));
				employeeList.add(employee);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		int rowNum = 0;

		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("DATE_OF_BIRTH");
		row.createCell(3).setCellValue("EMAIL");

		for (Employee dataModel : employeeList) {
			createSheetHeader(sheet, ++rowNum, dataModel);
		}

		try (FileOutputStream out = new FileOutputStream(new File(Pathes.XLS_EMPLOYEE_PATH_SAVE))) {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	private static void createSheetHeader(HSSFSheet sheet, int rowNum, Employee dataModel) {
		Row row = sheet.createRow(rowNum);

		long unixSeconds = dataModel.getDateBirth();
		Date date = new Date(unixSeconds * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone(TimeZones.TIME_ZONE_MINSK));
		String formattedDate = sdf.format(date);

		row.createCell(0).setCellValue(dataModel.getId());
		row.createCell(1).setCellValue(dataModel.getName());
		row.createCell(2).setCellValue(formattedDate);
		row.createCell(3).setCellValue(dataModel.getEmail());
	}

	@Override
	public List<Employee> selectEmployeeId(Employee entity) {

		List<Employee> employeeList = new ArrayList<>();

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String txt = entity.getName();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_EMPLOYEE_ID);
			ps.setString(1, txt);
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				Employee employee = new Employee();
				employee.setId(results.getInt("ID"));
				employee.setName(results.getString("NAME"));
				employee.setDateBirth(results.getInt("DATE_OF_BIRTH"));
				employee.setEmail(results.getString("EMAIL"));
				employeeList.add(employee);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employeeList;
	}

	@Override
	public Map<String, List<Employee>> entranceUser(Employee employee) {
		List<Employee> list = new ArrayList<>();
		Map<String, List<Employee>> arrUser = new HashMap<String, List<Employee>>();

		Connection cn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			Encryption encryption = new Encryption();

			// validation user to entrance
			prepStmt = cn.prepareStatement(SQLConstants.SQL_USER_ENTRANCE);
			prepStmt.setString(1, employee.getUserLoggin());
			rs = prepStmt.executeQuery();

			Employee user = new Employee();
			while (rs.next()) {

				String inputPassword = encryption.enCodePassword(employee.getUserPassword());
				String getDBPassword = rs.getString("PASSWORD");

				if (inputPassword.equals(getDBPassword)) {
					user.setId(rs.getInt("ID"));
					user.setUserLoggin(rs.getString("LOGIN"));
					user.setSatatusAdmin(rs.getString("STATUS_ADMIN"));
					list.add(user);
				} else {

				}

			}

			arrUser.put("entrance", list);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrUser;

	}

	@Override

	public Map<String, List<Employee>> selectAccountEmployeeId(Employee employee) {
		List<Employee> listAccount = new ArrayList<>();
		Map<String, List<Employee>> arrAccount = new HashMap<>();

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int idEmployee = employee.getId();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_EMPLOYEE_ACCOUNT_ID);
			ps.setInt(1, idEmployee);
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				Employee empl = new Employee();
				empl.setId(results.getInt("ID"));
				empl.setName(results.getString("nameEmployee"));
				empl.setDateBirth(results.getInt("dateBirthEmployee"));
				empl.setEmail(results.getString("emailEmployee"));
				empl.setPhotoEmployee(results.getString("photoEmployee"));
				empl.setTellNumber(results.getString("tellEmployee"));
				listAccount.add(empl);
			}
			arrAccount.put("account", listAccount);

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrAccount;
	}

	@Override
	public void writeVisiters(Visiters visiters) {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		loggerUserAction.infoLog("Write informaion visiters.", methodName);

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String ip = visiters.getIP();
			String countryCode = visiters.getCountryCode();
			String countyName = visiters.getCountyName();
			String regionCode = visiters.getRegionCode();
			String regionName = visiters.getRegionName();
			String city = visiters.getCity();
			String zipCode = visiters.getZipCode();
			String timeZone = visiters.getTimeZone();
			double latitude = visiters.getLatitude();
			double langitude = visiters.getLangitude();
			int metroCode = visiters.getMetroCode();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_WRITE_INFORMATION_VISITER);
			ps.setString(1, ip);
			ps.setString(2, countryCode);
			ps.setString(3, countyName);
			ps.setString(4, regionCode);
			ps.setString(5, regionName);
			ps.setString(6, city);
			ps.setString(7, zipCode);
			ps.setString(8, timeZone);
			ps.setDouble(9, latitude);
			ps.setDouble(10, langitude);
			ps.setInt(11, metroCode);
			ps.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
