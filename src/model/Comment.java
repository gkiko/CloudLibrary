package model;


public class Comment {
	
	private String comment;
	
	private String time;
	
	private String name;
	
	public Comment(String comment, String name, String time){
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
	
	public String getTime(){
		return time;
	}
	
}
