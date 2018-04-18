package by.htp.library.dao;

import java.util.List;
import java.util.Map;

import by.htp.library.bean.BookCountReadEmployee;
import by.htp.library.bean.Employee;
import by.htp.library.bean.EmployeeBook;
import by.htp.library.bean.ListBookAccordionTable;
import by.htp.library.service.model.IssueBook;

public interface EmployeeBookDao {

	void createEmployeeBook(EmployeeBook entity);
	Map<String, List<BookCountReadEmployee>> findFirstReport(EmployeeBook entity);
	Map<String, List<IssueBook>> issueBookReport(IssueBook issueBook);	
	List<Employee> sendEmail(IssueBook issueBook);	
	Map<String, List<ListBookAccordionTable>> accListBook(ListBookAccordionTable entity);	
	void updateBook(EmployeeBook entity);	
	Map<String, List<IssueBook>> issueBookFindRow(IssueBook entity);	
	Map<String, List<IssueBook>> filterIssue(IssueBook entity);

}
