package model;

import java.util.ArrayList;
import java.util.List;

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
	
}
