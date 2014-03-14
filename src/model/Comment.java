package model;

import java.util.Calendar;

public class Comment {
	
	private String comment;
	
	private Calendar time;
	
	private String name;
	
	public Comment(String comment, String name, Calendar time){
		this.comment = comment;
		this.name = name;
		this.time = time;
	}
	
	public String getComment(){
		return comment;
	}
	
	public String getName(){
		return name;
	}
	
	public Calendar getTime(){
		return time;
	}
	
}
