package by.htp.library.constants;

public class SQLConstants {

	// ENTRANCE
	/**
	 * SQL for select user in authorities
	 */
	public static final String SQL_USER_ENTRANCE = "SELECT "
			                                     + "ID, "
			                                     + "LOGIN, "
			                                     + "PASSWORD, "
			                                     + "STATUS_ADMIN "
												 + "FROM "
												 + "employee "
												 + "WHERE LOGIN=?;";
	
	public static final String SQL_VIEW_USER_EMTRANCE = "SELECT "
			                                          + "user_entrance.USER_NAME, "
			                                          + "user_entrance.DATE_TIME_ON, "
			                                          + "user_entrance.IP, "
			                                          + "user_entrance.SESSION_ON "
			                                          + "FROM user_entrance;";
	
	public static final String SQL_ADD_ENTRANCE = "INSERT "
			                                    + "INTO user_entrance "
												+ "(user_entrance.USER_NAME, "
												+ "user_entrance.DATE_TIME_ON, "
												+ "user_entrance.IP, "
												+ "user_entrance.SESSION_ON) "
												+ "VALUES (?, ?, ?, ?);";
	// BOOK
	public static final String SQL_SELECT_BOOK_PAGE = "SELECT "
			                                        + "book.ID, "
			                                        + "book.BRIEF, "
			                                        + "book.PUBLISH_YEAR, "
			                                        + "book.AUTHOR "
			                                        + "FROM book limit ?, ?;";
	
	public static final String SQL_SELECT_BOOKS = "SELECT "
			                                    + "book.ID, "
			                                    + "book.BRIEF, "
			                                    + "book.PUBLISH_YEAR, "
			                                    + "book.AUTHOR "
												+ "FROM book;";
	
	public static final String SQL_SELECT_BOOKS_ID = "SELECT "
			                                       + "book.ID, "
			                                       + "book.BRIEF, "
			                                       + "book.PUBLISH_YEAR, "
			                                       + "book.AUTHOR "
												   + "FROM book "
												   + "WHERE book.ID=?;";
	
	public static final String SQL_CREATE_BOOK = "INSERT INTO book "
			                                   + "(book.BRIEF, "
			                                   + "book.PUBLISH_YEAR, "
			                                   + "book.AUTHOR) "
			                                   + "VALUES (?, ?, ?);";
	
	public static final String SQL_UPDATE_BOOK = "UPDATE book "
			                                   + "SET book.BRIEF = ?, "
			                                   + "book.AUTHOR = ?, "
			                                   + "book.PUBLISH_YEAR = ? "
			                                   + "WHERE book.ID=?;";
	
	public static final String SQL_DELETE_BOOK = "DELETE "
											   + "FROM book "
											   + "WHERE book.ID=?;";
	
	public static final String SQL_SELECT_READ_BOOK_EMPLOYEE = "SELECT"
			                                                 + " employee_book.BOOK_ID AS idBook, "
			                                                 + "book.BRIEF AS nameBook, "
			                                                 + "employee_book.DATE_TIME_ON AS dateOn "
			                                                 + "FROM employee_book, book "
			                                                 + "WHERE book.ID = employee_book.BOOK_ID "
			                                                 + "AND employee_book.EMPLOYEE_ID = ?;";
	// EMPLOYEE
	public static final String SQL_SELECT_EMPLOYEE = "SELECT "
			                                       + "employee.ID, "
			                                       + "employee.Name, "
			                                       + "employee.DATE_OF_BIRTH, "
			                                       + "employee.EMAIL "
			                                       + "FROM employee "
			                                       + "WHERE employee.LOGIN <> 'admin';";
	
	public static final String SQL_SELECT_EMPLOYEE_ID = "SELECT "
			                                          + "employee.ID, "
			                                          + "employee.Name, "
			                                          + "employee.DATE_OF_BIRTH, "
			                                          + "employee.EMAIL "
			                                          + "FROM employee "
			                                          + "WHERE employee.ID=?;";
	
	public static final String SQL_CREATE_EMPLOYEE = "INSERT INTO "
			                                       + "`library_task`.`employee` "
			                                       + "(`NAME`, "
			                                       + "`DATE_OF_BIRTH`, "
			                                       + "`EMAIL`, "
			                                       + "`LOGIN`, "
			                                       + "`PASSWORD`, "
			                                       + "`STATUS_ADMIN`) "
			                                       + "VALUES (?, ?, ?, ?, ?, ?);";
	
	public static final String SQL_DELETE_EMPLOYEE = "DELETE "
			                                       + "FROM "
			                                       + "employee "
			                                       + "WHERE employee.ID=?";
	
	public static final String SQL_UPDATE_EMPLOYEE = "UPDATE "
			                                       + "`library_task`.`employee` "
			                                       + "SET "
			                                       + "`NAME`=?, "
			                                       + "`DATE_OF_BIRTH`=?, "
			                                       + "`EMAIL`=?, "
			                                       + "`PHOTO`=?, "
			                                       + "`TELL`=? "
			                                       + "WHERE  `ID`=?;";
	
	public static final String SQL_SELECT_EMPLOYEE_ACCOUNT_ID = "SELECT "
			                                                  + "employee.ID, "
			                                                  + "employee.Name AS nameEmployee, "
			                                                  + "employee.EMAIL AS emailEmployee, "
			                                                  + "employee.DATE_OF_BIRTH AS dateBirthEmployee, "
			                                                  + "employee.PHOTO AS photoEmployee, "
			                                                  + "employee.TELL AS tellEmployee "
			                                                  + "FROM employee "
			                                                  + "WHERE employee.ID = ?;";
	
	public static final String SQL_SELECT_NUMBER_PHONE = "SELECT "
			                                           + "employee.TELL AS tellNumber "
			                                           + "FROM "
			                                           + "employee "
			                                           + "WHERE employee.EMAIL = ?;";
	
	public static final String SQL_WRITE_INFORMATION_VISITER = "INSERT INTO `library_task`.`visiters` ("
			                                                 + "`IP`, "
			                                                 + "`COUNTRY_CODE`, "
			                                                 + "`COUNTRY_NAME`, "
			                                                 + "`REGION_CODE`, "
			                                                 + "`REGION_NAME`, "
			                                                 + "`CITY`, "
			                                                 + "`ZIP_CODE`, "
			                                                 + "`TIME_ZONE`, "
			                                                 + "`LATITUDE`, "
			                                                 + "`LANGITUDE`, "
			                                                 + "`METRO_CODE`"
			                                                 + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	// ADDITIONAL QYERY
	public static final String SQL_NUMBER_TOOK_MORE_1_BOOK = "SELECT "
			                                               + "empl.ID AS kodeEmployee, "
			                                               + "empl.NAME AS nameEmployee, "
			                                               + "empl.DATE_OF_BIRTH AS birthDayEmployee, "
			                                               + "COUNT(*) AS numberBook "
			                                               + "FROM "
			                                               + "employee_book emplBook "
			                                               + "INNER JOIN employee empl "
			                                               + "ON emplBook.EMPLOYEE_ID = empl.ID "
			                                               + "GROUP BY empl.NAME "
			                                               + "HAVING numberBook > ?;";
	
	public static final String SQL_NUMBER_TOOK_LESS_2_BOOK = "SELECT "
			                                               + "empl.NAME AS nameEmployee, "
			                                               + "empl.DATE_OF_BIRTH AS birthDayEmployee, "
			                                               + "COUNT(*) AS numberBook "
			                                               + "FROM employee_book emplBook "
			                                               + "INNER JOIN employee empl "
			                                               + "ON emplBook.EMPLOYEE_ID = empl.ID "
			                                               + "GROUP BY empl.NAME "
			                                               + "HAVING numberBook <= 2;";
	
	public static final String SQL_FILTER_BOOK = "SELECT "
			                                   + "book.ID, "
			                                   + "book.BRIEF, "
			                                   + "book.PUBLISH_YEAR, "
			                                   + "book.AUTHOR "
			                                   + "FROM book "
			                                   + "WHERE book.BRIEF "
			                                   + "LIKE CONCAT('%', ?,'%') "
			                                   + "OR book.AUTHOR "
			                                   + "LIKE CONCAT('%', ?, '%') "
			                                   + "OR book.PUBLISH_YEAR "
			                                   + "LIKE CONCAT('%', ?, '%') "
			                                   + "OR book.ID "
			                                   + "LIKE CONCAT('%', ?, '%');";
	
	public static final String SQL_FILTER_EMPLOYEE = "SELECT "
			                                       + "employee.ID, "
			                                       + "employee.Name, "
			                                       + "employee.DATE_OF_BIRTH, "
			                                       + "employee.EMAIL "
			                                       + "FROM employee "
			                                       + "WHERE employee.ID "
			                                       + "LIKE CONCAT('%', ?, '%') "
			                                       + "OR employee.NAME "
			                                       + "LIKE CONCAT('%', ?, '%') "
			                                       + "OR employee.EMAIL "
			                                       + "LIKE CONCAT('%', ?, '%');";
	
	public static final String SQL_FILTER_ISSUE_BOOK = "SELECT "
			                                         + "employee_book.ID AS idIssue, "
			                                         + "employee.ID AS idEmployee, "
			                                         + "employee.NAME AS nameEmployee, "
			                                         + "book.ID AS idBook, "
			                                         + "book.BRIEF AS nameBook, "
			                                         + "employee_book.DATE_TIME_ON AS dateOn, "
			                                         + "employee_book.DATE_TIME_RETURN AS dateOff, "
			                                         + "employee_book.`STATUS` AS statusReturn "
			                                         + "FROM book, employee, employee_book "
			                                         + "WHERE employee_book.BOOK_ID = book.ID "
			                                         + "AND employee_book.EMPLOYEE_ID = employee.ID "
			                                         + "AND employee.NAME "
			                                         + "LIKE CONCAT('%', ?, '%');";
	
	public static final String SQL_ADDITIONAL_INFO_BOOK = "SELECT "
			                                            + "additional_information_book.id_book AS idBook, "
			                                            + "additional_information_book.book_discripthion AS discriptionBook, "
			                                            + "additional_information_book.book_img AS nameImgBook "
			                                            + "FROM additional_information_book "
			                                            + "WHERE additional_information_book.id_book = ?;";
	
	public static final String SQL_CREATE_UPDATE_INFO_BOOK = "INSERT "
			                                               + "INTO `library_task`.`additional_information_book` "
			                                               + "(`id_book`, "
			                                               + "`book_discripthion`, "
			                                               + "`book_img`) "
			                                               + "VALUES (?, ?, ?) "
			                                               + "ON DUPLICATE KEY UPDATE id_book = ?, "
			                                               + "book_discripthion = ?, "
			                                               + "book_img = ?;";
	// EMPLOYEE_BOOK
	public static final String SQL_CREATE_EMPLOYEE_BOOK = "INSERT "
			                                            + "INTO `library_task`.`employee_book` "
			                                            + "(`DATE_TIME_ON`, "
			                                            + "`BOOK_ID`, "
			                                            + "`EMPLOYEE_ID`, "
			                                            + "`DATE_TIME_RETURN`, "
			                                            + "`STATUS`) "
			                                            + "VALUES (?, ?, ?, ?, ?);";
	
	public static final String SQL_VIEW_EMPLOYEE_BOOK = "SELECT "
			                                          + "employee_book.ID AS ISSUE_ID, "
			                                          + "employee.ID AS EMP_ID, "
			                                          + "employee.NAME AS EMPL_NAME, "
			                                          + "book.ID AS BOOK_AD, "
			                                          + "book.BRIEF AS BOOK_NAME, "
			                                          + "employee_book.DATE_TIME_ON AS DATE_ON, "
			                                          + "employee_book.DATE_TIME_RETURN AS DATE_OFF, "
			                                          + "employee_book.`STATUS` AS STATUS_RETURN FROM book, "
			                                          + "employee, employee_book "
			                                          + "WHERE employee_book.BOOK_ID = book.ID "
			                                          + "AND employee_book.EMPLOYEE_ID = employee.ID "
			                                          + "AND employee_book.ID = ?;";
	
	public static final String SQL_UPDATE_EMPLOYEE_BOOK = "UPDATE `library_task`.`employee_book` "
			                                            + "SET "
			                                            + "`DATE_TIME_RETURN` = ?, "
			                                            + "`STATUS` = ? "
			                                            + "WHERE  `ID`= ? ;";
	// REPORT
	public static final String SQL_ISSUED_BOOKS = "SELECT "
			                                    + "employee_book.ID AS ISSUE_ID, "
			                                    + "employee.ID AS EMP_ID, "
			                                    + "employee.NAME AS EMPL_NAME, "
			                                    + "book.ID AS BOOK_AD, "
			                                    + "book.BRIEF AS BOOK_NAME, "
			                                    + "employee_book.DATE_TIME_ON AS DATE_ON, "
			                                    + "employee_book.DATE_TIME_RETURN AS DATE_OFF, "
			                                    + "employee_book.`STATUS` AS STATUS_RETURN FROM book, "
			                                    + "employee, employee_book "
			                                    + "WHERE employee_book.BOOK_ID = book.ID "
			                                    + "AND employee_book.EMPLOYEE_ID = employee.ID;";
	
	public static final String SQL_SELECT_COUNT_BOOK_ACC = "SELECT "
			                                             + "employee_book.EMPLOYEE_ID, "
			                                             + "employee_book.BOOK_ID, "
			                                             + "book.BRIEF, "
			                                             + "employee_book.DATE_TIME_ON "
			                                             + "FROM "
			                                             + "employee_book, book "
			                                             + "WHERE employee_book.EMPLOYEE_ID = ? "
			                                             + "AND employee_book.BOOK_ID = book.ID;";
	
	public static final String SQL_RATING_BOOK = "SELECT "
			                                   + "employee_book.BOOK_ID AS idBook, "
			                                   + "book.BRIEF AS nameBook, "
			                                   + "COUNT(book.ID) AS cntBook, "
			                                   + "(SELECT COUNT(*) "
			                                   + "FROM book) AS cntIssue, "
			                                   + "TRUNCATE(((COUNT(book.ID)/(SELECT COUNT(*) FROM book))*100), 2) AS rating "
			                                   + "FROM employee_book, book "
			                                   + "WHERE employee_book.BOOK_ID = book.ID AND book.ID = ? "
			                                   + "GROUP BY nameBook;";
	// RENTING
	public static final String SQL_CREATE_RENTING = "INSERT "
			                                      + "INTO `library_task`.`renting` "
			                                      + "(`id_book`, "
			                                      + "`id_employee`, "
			                                      + "`dateOn`, "
			                                      + "`status_rent`) "
			                                      + "VALUES (?, ?, ?, ?);";
	
	public static final String SQL_SELECT_RENTING = "SELECT "
			                                      + "renting.id AS idRent, "
			                                      + "book.ID AS idBook, "
			                                      + "employee.ID AS idEmployee, "
			                                      + "book.BRIEF AS nameBook, "
			                                      + "employee.NAME AS nameEmployee, "
			                                      + "employee.EMAIL AS emailEmployee, "
			                                      + "renting.dateOn AS dateOnRenting, "
			                                      + "renting.status_rent AS statusRent "
			                                      + "FROM "
			                                      + "renting "
			                                      + "INNER JOIN book ON book.ID = renting.id_book "
			                                      + "INNER JOIN employee ON employee.ID = renting.id_employee "
			                                      + "WHERE renting.status_rent = 'false';";
	
	public static final String SQL_RENTING_NO = "DELETE FROM `library_task`.`renting` "
			                                  + "WHERE  `id`= ?;";
	
	public static final String SQL_SELECT_RENT_BOOK_EMPLOYEE = "SELECT "
			                                                 + "renting.id AS idRent, "
			                                                 + "renting.id_book AS idBook, "
			                                                 + "book.BRIEF AS nameBook, "
			                                                 + "renting.dateOn AS dateRent "
			                                                 + "FROM renting, book "
			                                                 + "WHERE book.ID = renting.id_book "
			                                                 + "AND renting.id_employee = ?;";
	//CHAT
	public static final String SQL_SELECT_MSG_FROM_USER = "SELECT "
			                                            + "messenger.id AS idMsg, "
			                                            + "messenger.date_on AS dateOnMsg, "
			                                            + "messenger.from_user AS userFromMsg, "
			                                            + "messenger.to_user AS userTomsg, "
			                                            + "messenger.message AS msg "
			                                            + "FROM messenger "
			                                            + "WHERE messenger.from_user = ?;";
	
    public static final String SQL_CREATE_MSG_CHAT = "INSERT INTO "
    		                                       + "`library_task`.`messenger` "
    		                                       + "(`date_on`, "
    		                                       + "`from_user`, "
    		                                       + "`to_user`, "
    		                                       + "`message`) "
    		                                       + "VALUES (?, ?, ?, ?);";
    //LOG
    public static final String SQL_WRITE_LOG = "INSERT INTO "
    		                                 + "`library_task`.`log` "
    		                                 + "(`dateOn`, "
    		                                 + "`typeLog`, "
    		                                 + "`msgLog`, "
    		                                 + "`methodName`) "
    		                                 + "VALUES (?, ?, ?, ?);";
    
    //CHAT
    public static final String SQL_WRITE_CHAT_MSG = "INSERT INTO `library_task`.`chat` "
    		                                      + "(`dateOn`, "
    		                                      + "`fromUser`, "
    		                                      + "`toUser`, "
    		                                      + "`message`) "
    		                                      + "VALUES (?, ?, ?, ?);";
    
    public static final String SQL_READ_CHAT_MSG = "SELECT * FROM (SELECT "
    		                                     + "chat.id, "
    		                                     + "chat.dateOn, "
    		                                     + "chat.fromUser, "
    		                                     + "chat.toUser, "
    		                                     + "chat.message "
    		                                     + "FROM chat ORDER BY id DESC LIMIT 10) t "
    		                                     + "WHERE t.id>10;";
    
    public static final String SQL_SELECT_CHAT_USER = "SELECT employee.LOGIN "
    		                                        + "FROM employee "
    		                                        + "WHERE "
    		                                        + "employee.LOGIN <> ?;";
    
}
