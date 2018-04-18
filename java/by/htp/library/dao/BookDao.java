package by.htp.library.dao;

import java.util.List;
import java.util.Map;

import by.htp.library.bean.BookAdditionalInfo;
import by.htp.library.bean.Employee;
import by.htp.library.bean.Renting;
import by.htp.library.service.model.Book;
import by.htp.library.service.model.CountBookRead;
import by.htp.library.service.model.LimitPage;
import by.htp.library.service.model.Rating;

public interface BookDao {

	Map<String, List<Book>> readAllBooks();
	void createBook(Book entity);
	void updateBook(Book entity);
	void deleteBook(Book entity);
	Map<String, List<Book>> findBook(Book entity);
	List<Book> createXLS(Book entity);
	List<Book> selectBookId(Book entity);
	Map<String, List<Rating>> rating(Rating entity);
	Map<String, List<BookAdditionalInfo>> additionalInfo(BookAdditionalInfo entity);	
	void updateAdditionalInformation(BookAdditionalInfo bookAdditionalInfo);	
	void createRent(Renting renting);	
	Map<String, List<Renting>> readAllRent();	
	void anserRenting(Renting entity);	
	Map<String, List<Renting>> selectBookRentEmployee(Renting renting);	
	void deleteRentingBookEmployee(Renting renting);
	Map<String, List<CountBookRead>> countReadBook(Employee employee);
	Map<String, List<Book>> findBookPage(LimitPage limitPage);

}
