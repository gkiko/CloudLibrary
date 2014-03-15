package model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import database.DBConnector;

public class CommentCollection {

	public ArrayList<Comment> getCommentsFrom(List<CommentMark> list){
		ArrayList<Comment> comments = new ArrayList<Comment>();
		DBConnector db = DBConnector.getInstance();
		for(CommentMark cm : list){
			comments.add(db.getCommentById(cm.getId()));
		}
		return comments;
	}
	
	public JSONArray getCommentsJsonFrom(List<CommentMark> list){
		ArrayList<Comment> comments = getCommentsFrom(list);
		JSONArray array = new JSONArray();
		JSONObject obj;
		for(Comment b : comments){
			obj = new JSONObject();
			obj.put("Date", b.getTime());
			obj.put("Id", b.getId());
			obj.put("Comment", b.getComment());
			array.add(obj);
		}
		return array;
	}
	
}
