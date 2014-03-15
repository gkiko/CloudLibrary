package model;


public class Comment {
	
	private String comment;
	
	private String time;
	
	private String id;
	
	public Comment(String comment, String id, String time){
		this.comment = comment;
		this.id = id;
		this.time = time;
	}
	
	public String getComment(){
		return comment;
	}
	
	public String getId(){
		return id;
	}
	
	public String getTime(){
		return time;
	}
	
}
