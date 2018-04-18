package by.htp.library.dao;

import org.junit.Before;
import org.junit.Test;

import by.htp.library.dao.impl.BookDaoMySql;

import org.junit.Assert;

public class BookDaoSimpleTest {

	// clean compile test package

	private BookDao dao = null;

	@Before
	public void initData() {
		dao = new BookDaoMySql();
		// dao = new SimpleBookDaoImpl();
	}

	@Test
	public void testReadAllListNotNull() {
		Assert.assertNotNull(dao);
		Assert.assertNotNull(dao.readAllBooks());
	}

}
