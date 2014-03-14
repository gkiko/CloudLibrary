package model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import database.DBConnector;

public class BookCollection {

	public ArrayList<Book> getBooksFrom(List<BookMark> list){
		ArrayList<Book> books = new ArrayList<Book>();
		DBConnector db = DBConnector.getInstance();
		for(BookMark bm : list){
			books.add(db.getBookById(bm.getBookId()));
		}
		return books;
	}
	
	public JSONArray getBooksJsonFrom(List<BookMark> list){
		ArrayList<Book> books = getBooksFrom(list);
		JSONArray array = new JSONArray();
		JSONObject obj;
		for(Book b : books){
			obj = new JSONObject();
			obj.put("Author", b.getAuthorInfo());
			obj.put("Description", b.getBriefDescription());
			obj.put("Title", b.getTitle());
			obj.put("Download_url", b.getDownloadUrl());
			obj.put("Image_url", b.getImageUrl());
			array.add(obj);
		}
		return array;
	}
	
}
