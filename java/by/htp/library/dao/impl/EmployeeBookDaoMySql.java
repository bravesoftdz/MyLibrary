package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.library.action.util.DateFormater;
import by.htp.library.action.util.EmailSender;
import by.htp.library.action.util.PartDay;
import by.htp.library.bean.BookCountReadEmployee;
import by.htp.library.bean.Employee;
import by.htp.library.bean.EmployeeBook;
import by.htp.library.bean.ListBookAccordionTable;
import by.htp.library.constants.SQLConstants;
import by.htp.library.dao.EmployeeBookDao;
import by.htp.library.service.model.IssueBook;

public class EmployeeBookDaoMySql implements EmployeeBookDao {

	Connector connector = new Connector();

	{
		try {
			Class.forName(connector.getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createEmployeeBook(EmployeeBook entity) {

		if (entity != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_CREATE_EMPLOYEE_BOOK);

				ps.setLong(1, entity.getDateTimeOn()); // dateOn
				ps.setInt(2, entity.getBookId()); // idBook
				ps.setInt(3, entity.getEmployeeId()); // idEmployee
				ps.setLong(4, entity.getDateTimeReturn()); // dateOff
				ps.setString(5, entity.getStatus()); // status
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
	public Map<String, List<BookCountReadEmployee>> findFirstReport(EmployeeBook entity) {

		List<BookCountReadEmployee> listEmployeeBook = new ArrayList<>();
		Map<String, List<BookCountReadEmployee>> arrEmployeeBook = new HashMap<String, List<BookCountReadEmployee>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int idRow = entity.getId();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_NUMBER_TOOK_MORE_1_BOOK);
			ps.setInt(1, idRow); // text_1
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				BookCountReadEmployee employeeBookFirstReport = new BookCountReadEmployee();

				employeeBookFirstReport.setKodeEmployee(results.getInt("kodeEmployee"));
				employeeBookFirstReport.setNameEmployee(results.getString("nameEmployee"));
				employeeBookFirstReport.setDateBirth(results.getInt("birthDayEmployee"));
				employeeBookFirstReport.setCountBook(results.getInt("numberBook"));

				listEmployeeBook.add(employeeBookFirstReport);
			}
			arrEmployeeBook.put("employeeBookFirstReport", listEmployeeBook);

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

		return arrEmployeeBook;
	}

	@Override
	public Map<String, List<IssueBook>> issueBookReport(IssueBook issueBook) {
		List<IssueBook> issueBookList = new ArrayList<>();
		Map<String, List<IssueBook>> arrIssueBook = new HashMap<String, List<IssueBook>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_ISSUED_BOOKS);
			ResultSet results = ps.executeQuery();

			while (results.next()) { // results.getInt("kodeEmployee")

				IssueBook issueBookDataModel = new IssueBook();
				issueBookDataModel.setIdIssue(results.getInt("ISSUE_ID"));
				issueBookDataModel.setIdEmployee(results.getInt("EMP_ID"));
				issueBookDataModel.setNameEmployee(results.getString("EMPL_NAME"));
				issueBookDataModel.setIdBook(results.getInt("BOOK_AD"));
				issueBookDataModel.setNameBook(results.getString("BOOK_NAME"));
				issueBookDataModel.setDateOn(results.getInt("DATE_ON"));
				issueBookDataModel.setDateOff(results.getInt("DATE_OFF"));
				issueBookDataModel.setStatus(results.getString("STATUS_RETURN"));

				long dateOffValue = results.getLong("DATE_OFF");
				if (dateOffValue == 0) {
					long a = System.currentTimeMillis() / 1000;
					long dateOnValue = results.getLong("DATE_ON");
					int countDay = (int) ((a - dateOnValue) / 86400);
					issueBookDataModel.setCountDay(countDay);
				} else {
					long a = dateOffValue;
					long dateOnValue = results.getLong("DATE_ON");
					int countDay = (int) ((a - dateOnValue) / 86400);
					issueBookDataModel.setCountDay(countDay);
				}

				issueBookList.add(issueBookDataModel);
			}
			arrIssueBook.put("issueBook", issueBookList);

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

		return arrIssueBook;
	}

	@Override
	public List<Employee> sendEmail(IssueBook issueBook) {
		List<Employee> employeeList = new ArrayList<>();

		Connection cn = null;
		try {

			String email = null;

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int idEmpl = issueBook.getIdEmployee();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_EMPLOYEE_ID);
			ps.setInt(1, idEmpl);
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				Employee employee = new Employee();
				employee.setId(results.getInt("ID"));
				employee.setName(results.getString("NAME"));
				employee.setDateBirth(results.getInt("DATE_OF_BIRTH"));
				employee.setEmail(results.getString("EMAIL"));
				email = employee.getEmail();
				employeeList.add(employee);
			}

			long dateOn = issueBook.getDateOn();
			int idBook = issueBook.getIdBook();
			String nameBook = issueBook.getNameBook();
			String nameEmployee = issueBook.getNameEmployee();

			PartDay timeDay = new PartDay();
			String gritting = timeDay.getTimeDay();

			long epoch = System.currentTimeMillis() / 1000;
			long tSummary = epoch - dateOn;
			int countDay = ((int) (tSummary / 86400)) - 10;

			DateFormater dateFormater = new DateFormater();
			String dateAfteFormater = dateFormater.formDate(dateOn);

			String subject = "Reminder of terms of return the book to the library.";
			String bodyMessage = gritting + "\nDear, " + nameEmployee + "."
					+ "\nWe inform you that you are overdue the period for the return of the book from our library."
					+ "\nWe kindly ask you to return it." + "\nYou have expired the return for " + countDay + " day(s)."
					+ "\n" + "\nData" + "\n======================================================="
					+ "\nDate of the book: " + dateAfteFormater + "\nBook ID: " + idBook + "\nName of the book: "
					+ nameBook + "\n=======================================================" + "\n"
					+ "\nIf you have any problems with the return of the book," + "\nplease report this."
					+ "\nThis letter is generated automatically.\r\n" + "Do not answer it.";

			EmailSender emailSender = new EmailSender();
			emailSender.sendingEmail(email, subject, bodyMessage);

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
	public Map<String, List<ListBookAccordionTable>> accListBook(ListBookAccordionTable entity) {
		List<ListBookAccordionTable> listAccordion = new ArrayList<>();
		Map<String, List<ListBookAccordionTable>> arrAccordionBook = new HashMap<String, List<ListBookAccordionTable>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int idEmployee = entity.getIdEmployee();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_COUNT_BOOK_ACC);
			ps.setInt(1, idEmployee); // text_1
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				ListBookAccordionTable listBookAccordionTable = new ListBookAccordionTable();

				listBookAccordionTable.setIdEmployee(results.getInt("EMPLOYEE_ID"));
				listBookAccordionTable.setIdBook(results.getInt("BOOK_ID"));
				listBookAccordionTable.setBrief(results.getString("BRIEF"));
				listBookAccordionTable.setDateOn(results.getInt("DATE_TIME_ON"));

				listAccordion.add(listBookAccordionTable);
			}
			arrAccordionBook.put("accordionBookEmployee", listAccordion);

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

		return arrAccordionBook;
	}

	@Override
	public void updateBook(EmployeeBook entity) {
		if (entity != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_UPDATE_EMPLOYEE_BOOK);
				ps.setLong(1, entity.getDateTimeReturn());
				ps.setString(2, entity.getStatus());
				ps.setInt(3, entity.getId());
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
	public Map<String, List<IssueBook>> issueBookFindRow(IssueBook entity) {
		List<IssueBook> issueBookList = new ArrayList<>();
		Map<String, List<IssueBook>> arrIssueBook = new HashMap<String, List<IssueBook>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_VIEW_EMPLOYEE_BOOK);
			ps.setInt(1, entity.getIdIssue());
			ResultSet results = ps.executeQuery();

			while (results.next()) { // results.getInt("kodeEmployee")

				IssueBook issueBookDataModel = new IssueBook();
				issueBookDataModel.setIdIssue(results.getInt("ISSUE_ID"));
				issueBookDataModel.setIdEmployee(results.getInt("EMP_ID"));
				issueBookDataModel.setNameEmployee(results.getString("EMPL_NAME"));
				issueBookDataModel.setIdBook(results.getInt("BOOK_AD"));
				issueBookDataModel.setNameBook(results.getString("BOOK_NAME"));
				issueBookDataModel.setDateOn(results.getInt("DATE_ON"));
				issueBookDataModel.setDateOff(results.getInt("DATE_OFF"));
				issueBookDataModel.setStatus(results.getString("STATUS_RETURN"));

				long dateOffValue = results.getLong("DATE_OFF");
				if (dateOffValue == 0) {
					long a = System.currentTimeMillis() / 1000;
					long dateOnValue = results.getLong("DATE_ON");
					int countDay = (int) ((a - dateOnValue) / 86400);
					issueBookDataModel.setCountDay(countDay);
				} else {
					long a = dateOffValue;
					long dateOnValue = results.getLong("DATE_ON");
					int countDay = (int) ((a - dateOnValue) / 86400);
					issueBookDataModel.setCountDay(countDay);
				}

				issueBookList.add(issueBookDataModel);
			}
			arrIssueBook.put("issueBookFindRow", issueBookList);

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

		return arrIssueBook;
	}

	@Override
	public Map<String, List<IssueBook>> filterIssue(IssueBook entity) {
		List<IssueBook> issueBookList = new ArrayList<>();
		Map<String, List<IssueBook>> arrIssueBook = new HashMap<String, List<IssueBook>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_FILTER_ISSUE_BOOK);
			ps.setString(1, entity.getNameEmployee());
			ResultSet results = ps.executeQuery();

			while (results.next()) { // results.getInt("kodeEmployee")

				IssueBook issueBookDataModel = new IssueBook();
				issueBookDataModel.setIdIssue(results.getInt("idIssue"));
				issueBookDataModel.setIdEmployee(results.getInt("idEmployee"));
				issueBookDataModel.setNameEmployee(results.getString("nameEmployee"));
				issueBookDataModel.setIdBook(results.getInt("idBook"));
				issueBookDataModel.setNameBook(results.getString("nameBook"));
				issueBookDataModel.setDateOn(results.getInt("dateOn"));
				issueBookDataModel.setDateOff(results.getInt("dateOff"));
				issueBookDataModel.setStatus(results.getString("statusReturn"));

				long dateOffValue = results.getLong("dateOff");
				if (dateOffValue == 0) {
					long a = System.currentTimeMillis() / 1000;
					long dateOnValue = results.getLong("dateOn");
					int countDay = (int) ((a - dateOnValue) / 86400);
					issueBookDataModel.setCountDay(countDay);
				} else {
					long a = dateOffValue;
					long dateOnValue = results.getLong("dateOn");
					int countDay = (int) ((a - dateOnValue) / 86400);
					issueBookDataModel.setCountDay(countDay);
				}

				issueBookList.add(issueBookDataModel);
			}
			arrIssueBook.put("issueBookFilter", issueBookList);

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

		return arrIssueBook;
	}

	

}
