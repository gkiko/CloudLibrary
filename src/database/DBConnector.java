package database;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import model.*;

public class DBConnector {

	static String server = "localhost";
	static String password = "1234";
	static String account = "root";
	static String database = "test";
	private static Connection con;
	private static DBConnector db;
	static Statement stmt;
	
	public static DBConnector getInstance(){
		if(db==null){
			db = new DBConnector();
		}
		return db;
	}
	
	private DBConnector(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + server,
					account, password);
			stmt = con.createStatement();
			stmt.executeQuery("USE " + database);
			System.out.println("done");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<BookMark> getAllBookMarks(){
		try{
			ResultSet rset = stmt.executeQuery("select * from book_coord");
			ArrayList<BookMark> list = new ArrayList<BookMark>();
			while(rset.next()){
					String bookIdStr = rset.getString("book_id"), longitudeStr = rset.getString("longitude"), latitudeStr = rset.getString("latitude");
					list.add(new BookMark(Long.parseLong(bookIdStr), Double.parseDouble(longitudeStr), Double.parseDouble(latitudeStr)));
			}
			return list;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public Book getBookById(long book_id){
		try{
			ResultSet rset = stmt.executeQuery("select * from books where id = "+book_id);
			if(!rset.next()) return null;
			String authorInfo = rset.getString("author"), briefDescription = rset.getString("description"),
					title = rset.getString("title"), downloadUrl = rset.getString("download_url"), imageUrl = rset.getString("image_url");
			Book book = new Book(authorInfo, briefDescription, title, downloadUrl, imageUrl);
			return book;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<CommentMark> getAllCommentMarks(){
		try{
			ResultSet rset = stmt.executeQuery("select * from comment_coord");
			ArrayList<CommentMark> list = new ArrayList<CommentMark>();
			while(rset.next()){
					String bookIdStr = rset.getString("comment_id"), longitudeStr = rset.getString("longitude"), latitudeStr = rset.getString("latitude");
					list.add(new CommentMark(Long.parseLong(bookIdStr), Double.parseDouble(longitudeStr), Double.parseDouble(latitudeStr)));
			}
			return list;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public Comment getCommentById(long comment_id){
		try{
			ResultSet rset = stmt.executeQuery("select * from comments where id = "+comment_id);
			if(!rset.next()) return null;
			String name = rset.getString("user_id"), comment = rset.getString("comment");
			Comment com = new Comment(comment, name, sdf.format(rset.getTimestamp("time").getTime()));
			return com;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
