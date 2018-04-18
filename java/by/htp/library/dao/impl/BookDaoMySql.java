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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import by.htp.library.action.util.DateFormater;
import by.htp.library.action.util.Email2SMS;
import by.htp.library.action.util.EmailSender;
import by.htp.library.action.util.LoggerUserAction;
import by.htp.library.action.util.PartDay;
import by.htp.library.bean.BookAdditionalInfo;
import by.htp.library.bean.Employee;
import by.htp.library.bean.Renting;
import by.htp.library.constants.EmailData;
import by.htp.library.constants.SQLConstants;
import by.htp.library.dao.BookDao;
import by.htp.library.service.model.Book;
import by.htp.library.service.model.CountBookRead;
import by.htp.library.service.model.LimitPage;
import by.htp.library.service.model.Rating;

public class BookDaoMySql implements BookDao {

	Connector connector = new Connector();
	LoggerUserAction loggerUserAction = new LoggerUserAction();

	{
		try {
			Class.forName(connector.getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, List<Book>> readAllBooks() {

		/*
		 * Get name method for logger and write to log
		 */
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		loggerUserAction.infoLog("Load all books from DB.", methodName);

		List<Book> list = new ArrayList<>();
		Map<String, List<Book>> arrBooks = new HashMap<String, List<Book>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQLConstants.SQL_SELECT_BOOKS);
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("ID"));
				book.setBrief(rs.getString("BRIEF"));
				book.setAuthor(rs.getString("AUTHOR"));
				book.setPublishYear(rs.getInt("PUBLISH_YEAR"));
				list.add(book);
			}
			arrBooks.put("books", list);

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
		return arrBooks;
	}

	@Override
	public void createBook(Book entity) {

		if (entity != null) {
			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_CREATE_BOOK);
				ps.setString(1, entity.getBrief()); // brief
				ps.setInt(2, entity.getPublishYear()); // publisher
				ps.setString(3, entity.getAuthor()); // author
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
	public void updateBook(Book entity) {
		if (entity != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_UPDATE_BOOK);
				ps.setString(1, entity.getBrief()); // brief
				ps.setString(2, entity.getAuthor()); // author
				ps.setInt(3, entity.getPublishYear()); // publisher
				ps.setInt(4, entity.getId()); // ID
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
	public void deleteBook(Book entity) {
		if (entity != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_DELETE_BOOK);
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
	public Map<String, List<Book>> findBook(Book entity) {
		List<Book> list = new ArrayList<>();
		Map<String, List<Book>> arrBooks = new HashMap<String, List<Book>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String txt = entity.getBrief();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_FILTER_BOOK);
			ps.setString(1, txt); // text_1
			ps.setString(2, txt); // text_2
			ps.setString(3, txt); // text_2
			ps.setString(4, txt); // text_2
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				Book book = new Book();
				book.setId(results.getInt("ID"));
				book.setBrief(results.getString("BRIEF"));
				book.setAuthor(results.getString("AUTHOR"));
				book.setPublishYear(results.getInt("PUBLISH_YEAR"));
				list.add(book);
			}
			arrBooks.put("books", list);

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
		return arrBooks;
	}

	@SuppressWarnings({ "resource", "static-access" })
	@Override
	public List<Book> createXLS(Book entity) {

		// Create workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("book");

		// Create style border
		HSSFCellStyle headLbls = workbook.createCellStyle();
		headLbls.setAlignment(headLbls.ALIGN_RIGHT);

		// Create style border
		HSSFCellStyle styleTable = workbook.createCellStyle();
		styleTable.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleTable.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleTable.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleTable.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleTable.setAlignment(styleTable.ALIGN_LEFT);

		HSSFFont font = workbook.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setFontHeightInPoints((short) 10);
		font.setBold(false);
		font.setColor(HSSFColor.BLACK.index);
		styleTable.setFont(font);

		// Create style border
		HSSFCellStyle styleBold = workbook.createCellStyle();
		styleBold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleBold.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleBold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleBold.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleBold.setAlignment(styleBold.ALIGN_CENTER);

		HSSFFont fontBold = workbook.createFont();
		fontBold.setFontName(HSSFFont.FONT_ARIAL);
		fontBold.setFontHeightInPoints((short) 10);
		fontBold.setBold(true);
		fontBold.setColor(HSSFColor.BLACK.index);
		styleBold.setFont(fontBold);

		// Create style border
		HSSFCellStyle styleFooter = workbook.createCellStyle();
		styleFooter.setAlignment(styleBold.ALIGN_RIGHT);

		HSSFFont fontFooter = workbook.createFont();
		fontFooter.setFontName(HSSFFont.FONT_ARIAL);
		fontFooter.setFontHeightInPoints((short) 10);
		fontFooter.setBold(true);
		fontFooter.setColor(HSSFColor.BLACK.index);
		styleFooter.setFont(fontFooter);

		// Create style border
		HSSFCellStyle titleReport = workbook.createCellStyle();
		titleReport.setAlignment(styleBold.ALIGN_CENTER);

		HSSFFont fontTitleReport = workbook.createFont();
		fontTitleReport.setFontName(HSSFFont.FONT_ARIAL);
		fontTitleReport.setFontHeightInPoints((short) 10);
		fontTitleReport.setBold(true);
		fontTitleReport.setColor(HSSFColor.BLACK.index);
		titleReport.setFont(fontTitleReport);

		List<Book> bookList = new ArrayList<>();

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String txt = entity.getBrief();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_FILTER_BOOK);
			ps.setString(1, txt); // par_1
			ps.setString(2, txt); // par_2
			ps.setString(3, txt); // par_3
			ps.setString(4, txt); // par_4
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				Book book = new Book();
				book.setId(results.getInt("ID"));
				book.setBrief(results.getString("BRIEF"));
				book.setAuthor(results.getString("AUTHOR"));
				book.setPublishYear(results.getInt("PUBLISH_YEAR"));
				bookList.add(book);
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

		int rowNum = 4;

		sheet.setColumnWidth(0, 2000);
		sheet.setColumnWidth(1, 2000);
		sheet.setColumnWidth(2, 12000);
		sheet.setColumnWidth(3, 1700);
		sheet.setColumnWidth(4, 8000);

		for (int i = 0; i < 3; i++) {
			CellRangeAddress reporHeadtLbl = new CellRangeAddress(i, i, 0, 1);
			sheet.addMergedRegion(reporHeadtLbl);

			CellRangeAddress reportHeadInfo = new CellRangeAddress(i, i, 2, 4);
			sheet.addMergedRegion(reportHeadInfo);
		}

		// authoe report
		Row authorReport = sheet.createRow(0);
		authorReport.createCell(0).setCellValue("Author:");
		authorReport.createCell(2).setCellValue("Library.com");
		authorReport.getCell(0).setCellStyle(headLbls);

		// report
		Row nameReport = sheet.createRow(1);
		nameReport.createCell(0).setCellValue("Report:");
		nameReport.createCell(2).setCellValue("List book");
		nameReport.getCell(0).setCellStyle(headLbls);

		// date
		Row dateReport = sheet.createRow(2);
		dateReport.createCell(0).setCellValue("Date:");
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String requiredDate = df.format(new Date()).toString();
		dateReport.createCell(2).setCellValue(requiredDate);
		dateReport.getCell(0).setCellStyle(headLbls);

		// title report
		CellRangeAddress behiverRow = new CellRangeAddress(3, 3, 0, 4);
		sheet.addMergedRegion(behiverRow);
		Row titleReportHead = sheet.createRow(3);
		titleReportHead.createCell(0).setCellValue("LIST OF BOOKS");
		titleReportHead.getCell(0).setCellStyle(titleReport);

		// head list report
		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue("#");
		row.createCell(1).setCellValue("ID");
		row.createCell(2).setCellValue("NAME OF BOOK");
		row.createCell(3).setCellValue("YEAR");
		row.createCell(4).setCellValue("AUTHOR");
		for (int i = 0; i < rowNum + 1; i++) {
			row.getCell(i).setCellStyle(styleBold);
		}

		int countRow = 0;
		for (Book dataModel : bookList) {
			createSheetHeader(sheet, ++rowNum, dataModel, styleTable);
			countRow++;
		}

		// footer report
		int countRowTotal = countRow + 5;
		CellRangeAddress reporFooterTotalLbl = new CellRangeAddress(countRowTotal, countRowTotal, 0, 2);
		sheet.addMergedRegion(reporFooterTotalLbl);
		Row footerReport = sheet.createRow(countRowTotal);
		footerReport.createCell(0).setCellValue("TOTAL books in list:");
		footerReport.createCell(3).setCellValue(countRow);
		footerReport.getCell(0).setCellStyle(styleFooter);
		footerReport.getCell(3).setCellStyle(styleFooter);

		
		try (FileOutputStream out = new FileOutputStream(new File("src\\main\\upload\\book.xls"))) {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bookList;
	}



	private static void createSheetHeader(HSSFSheet sheet, int rowNum, Book dataModel, HSSFCellStyle styleTable) {
		Row row = sheet.createRow(rowNum);

		row.createCell(0).setCellValue(rowNum - 4);
		row.createCell(1).setCellValue(dataModel.getId());
		row.createCell(2).setCellValue(dataModel.getBrief());
		row.createCell(3).setCellValue(dataModel.getPublishYear());
		row.createCell(4).setCellValue(dataModel.getAuthor());

		row.getCell(0).setCellStyle(styleTable);
		row.getCell(1).setCellStyle(styleTable);
		row.getCell(2).setCellStyle(styleTable);
		row.getCell(3).setCellStyle(styleTable);
		row.getCell(4).setCellStyle(styleTable);

	}

	@Override
	public List<Book> selectBookId(Book entity) {

		List<Book> bookList = new ArrayList<>();

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			String txt = entity.getBrief();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_BOOKS_ID);
			ps.setString(1, txt);
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				Book book = new Book();
				book.setId(results.getInt("ID"));
				book.setBrief(results.getString("BRIEF"));
				book.setAuthor(results.getString("AUTHOR"));
				book.setPublishYear(results.getInt("PUBLISH_YEAR"));
				bookList.add(book);
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

		return bookList;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Map<String, List<Rating>> rating(Rating entity) {
		List<Rating> rantlist = new ArrayList<>();
		Map<String, List<Rating>> arrBooksRant = new HashMap<String, List<Rating>>();

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int idBook = entity.getIdBook();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_RATING_BOOK);
			ps.setInt(1, idBook);
			ResultSet results = ps.executeQuery();

			if (!results.isBeforeFirst()) {
				Rating rating = new Rating();
				rating.setIdBook(0);
				rating.setNameBook("unknown");
				rating.setCntBook(0);
				rating.setCntIssue(0);
				rating.setRating(0.00);
				rantlist.add(rating);
			} else {
				while (results.next()) {
					Rating rating = new Rating();
					rating.setIdBook(results.getInt("idBook"));
					rating.setNameBook(results.getString("nameBook"));
					rating.setCntBook(results.getInt("cntBook"));
					rating.setCntIssue(results.getInt("cntIssue"));
					rating.setRating(results.getDouble("rating"));
					rantlist.add(rating);
				}
			}

			arrBooksRant.put("rantlist", rantlist);

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

		return arrBooksRant;
	}

	////////////
	@Override
	public Map<String, List<BookAdditionalInfo>> additionalInfo(BookAdditionalInfo entity) {

		List<BookAdditionalInfo> additioallist = new ArrayList<>();
		Map<String, List<BookAdditionalInfo>> arrBooksAditional = new HashMap<String, List<BookAdditionalInfo>>();

		Connection cn = null;
		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int idBook = entity.getIdBook();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_ADDITIONAL_INFO_BOOK);
			ps.setInt(1, idBook);
			ResultSet results = ps.executeQuery();

			if (!results.isBeforeFirst()) {
				BookAdditionalInfo bookAdditionalInfo = new BookAdditionalInfo();
				bookAdditionalInfo.setIdBook(0);
				bookAdditionalInfo.setDiscriptionBook("Unfortunately there is no description for this book.");
				bookAdditionalInfo.setNameImgBook("img/book/nophoto.png");
				additioallist.add(bookAdditionalInfo);
			} else {
				while (results.next()) {
					BookAdditionalInfo bookAdditionalInfo = new BookAdditionalInfo();
					bookAdditionalInfo.setIdBook(results.getInt("idBook"));
					bookAdditionalInfo.setDiscriptionBook(results.getString("discriptionBook"));
					bookAdditionalInfo.setNameImgBook(results.getString("nameImgBook"));
					additioallist.add(bookAdditionalInfo);
				}
			}

			arrBooksAditional.put("arrBooksAditional", additioallist);

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

		return arrBooksAditional;
	}

	@Override
	public void updateAdditionalInformation(BookAdditionalInfo bookAdditionalInfo) {
		if (bookAdditionalInfo != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_CREATE_UPDATE_INFO_BOOK);
				ps.setInt(1, bookAdditionalInfo.getIdBook());
				ps.setString(2, bookAdditionalInfo.getDiscriptionBook());
				ps.setString(3, bookAdditionalInfo.getNameImgBook());
				ps.setInt(4, bookAdditionalInfo.getIdBook());
				ps.setString(5, bookAdditionalInfo.getDiscriptionBook());
				ps.setString(6, bookAdditionalInfo.getNameImgBook());
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
	public void createRent(Renting renting) {
		if (renting != null) {
			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_CREATE_RENTING);
				ps.setInt(1, renting.getIdBook());
				ps.setInt(2, renting.getIdEmployee());
				ps.setLong(3, renting.getDateOnRenting());
				ps.setString(4, renting.getStatusRenting());
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
	public Map<String, List<Renting>> readAllRent() {
		List<Renting> rentlist = new ArrayList<>();
		Map<String, List<Renting>> arrBooksRent = new HashMap<String, List<Renting>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQLConstants.SQL_SELECT_RENTING);
			while (rs.next()) {
				Renting renting = new Renting();
				renting.setIdRent(rs.getInt("idRent"));
				renting.setIdBook(rs.getInt("idBook"));
				renting.setIdEmployee(rs.getInt("idEmployee"));
				renting.setNameBook(rs.getString("nameBook"));
				renting.setNameEmployee(rs.getString("nameEmployee"));
				renting.setEmailEmployee(rs.getString("emailEmployee"));
				renting.setDateOnRenting(rs.getLong("dateOnRenting"));
				renting.setStatusRenting(rs.getString("statusRent"));
				rentlist.add(renting);
			}
			arrBooksRent.put("allRentBooks", rentlist);

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
		return arrBooksRent;
	}

	@Override
	public void anserRenting(Renting renting) {

		if (renting != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_RENTING_NO);
				ps.setInt(1, renting.getIdRent());
				ps.executeUpdate();

				PartDay timeDay = new PartDay();
				String gritting = timeDay.getTimeDay();
				DateFormater dateFormater = new DateFormater();
				String dateAfteFormater = dateFormater.formDate(renting.getDateOnRenting());
				String subject = "Lack of a book in stock.";
				String bodyMessage = gritting + "\nUnfortunately we could not book for you on your order:" + "\r\n"
						+ "Date renting: " + dateAfteFormater + "\r\n" + "Name of book: '" + renting.getNameBook() + "'"
						+ "\r\n" + "Reason: not available.\r\n" + "Please try again later.";
				String email = renting.getEmailEmployee();
				EmailSender emailSender = new EmailSender();
				emailSender.sendingEmail(email, subject, bodyMessage);

				PreparedStatement psPhoneNumber = cn.prepareStatement(SQLConstants.SQL_SELECT_NUMBER_PHONE);
				psPhoneNumber.setString(1, renting.getEmailEmployee());
				ResultSet resultsPhoneNumber = psPhoneNumber.executeQuery();
				while (resultsPhoneNumber.next()) {
					String bodyForSMS = "The books on your request aren't available. \r\n" + "Try again later.";
					Email2SMS email2Sms = new Email2SMS();
					email2Sms.sendingSms(EmailData.EMAIL_USER_NAME, resultsPhoneNumber.getString("tellNumber"),
							bodyForSMS);
				}

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
	public Map<String, List<Renting>> selectBookRentEmployee(Renting renting) {
		List<Renting> rentlist = new ArrayList<>();
		Map<String, List<Renting>> arrBooksRent = new HashMap<String, List<Renting>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_RENT_BOOK_EMPLOYEE);
			ps.setInt(1, renting.getIdEmployee());
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				Renting rentLst = new Renting();
				rentLst.setIdRent(results.getInt("idRent"));
				rentLst.setIdBook(results.getInt("idBook"));
				rentLst.setNameBook(results.getString("nameBook"));
				rentLst.setDateOnRenting(results.getLong("dateRent"));
				rentlist.add(rentLst);
			}
			arrBooksRent.put("allRentBooksEmployee", rentlist);

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
		return arrBooksRent;
	}

	@Override
	public void deleteRentingBookEmployee(Renting renting) {

		if (renting != null) {

			Connection cn = null;

			try {

				String url = connector.getConnectInitValue()[0];
				String login = connector.getConnectInitValue()[1];
				String pass = connector.getConnectInitValue()[2];

				cn = DriverManager.getConnection(url, login, pass);

				PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_RENTING_NO);
				ps.setInt(1, renting.getIdRent());
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
	public Map<String, List<CountBookRead>> countReadBook(Employee employee) {
		List<CountBookRead> listReadBook = new ArrayList<>();
		Map<String, List<CountBookRead>> arrReadBooks = new HashMap<String, List<CountBookRead>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int idEmployee = employee.getId();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_READ_BOOK_EMPLOYEE);
			ps.setInt(1, idEmployee); // idEmployee
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				CountBookRead countBookRead = new CountBookRead();
				countBookRead.setIdBook(results.getInt("idBook"));
				countBookRead.setNameBook(results.getString("nameBook"));
				countBookRead.setDateOn(results.getInt("dateOn"));
				listReadBook.add(countBookRead);
			}
			arrReadBooks.put("readBooks", listReadBook);

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
		return arrReadBooks;
	}

	@Override
	public Map<String, List<Book>> findBookPage(LimitPage limitPage) {

		List<Book> listPage = new ArrayList<>();
		Map<String, List<Book>> arrBooksPage = new HashMap<String, List<Book>>();

		Connection cn = null;

		try {

			String url = connector.getConnectInitValue()[0];
			String login = connector.getConnectInitValue()[1];
			String pass = connector.getConnectInitValue()[2];

			cn = DriverManager.getConnection(url, login, pass);

			int start = limitPage.getStart();
			int end = limitPage.getEnd();

			PreparedStatement ps = cn.prepareStatement(SQLConstants.SQL_SELECT_BOOK_PAGE);
			ps.setInt(1, start); // from
			ps.setInt(2, end); // to
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				Book book = new Book();
				book.setId(results.getInt("ID"));
				book.setBrief(results.getString("BRIEF"));
				book.setAuthor(results.getString("AUTHOR"));
				book.setPublishYear(results.getInt("PUBLISH_YEAR"));
				listPage.add(book);
			}
			arrBooksPage.put("pages", listPage);

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
		return arrBooksPage;
	}

}
