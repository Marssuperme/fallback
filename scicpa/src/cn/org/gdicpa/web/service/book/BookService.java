package cn.org.gdicpa.web.service.book;

import java.sql.Connection;

public class BookService {
	private Connection conn;
	public BookService(Connection conn){
		this.conn = conn;
	}
}
