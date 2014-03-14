package model;

public class Book {
	
	private String authorInfo, briefDescription, title, downloadUrl, imageUrl;
	
	public Book(String authorInfo, String briefDescription, String title, String downloadUrl, String imageUrl){
		this.authorInfo = authorInfo;
		this.briefDescription = briefDescription;
		this.title = title;
		this.downloadUrl = downloadUrl;
		this.imageUrl = imageUrl;
	}
	
	public Book(){
	}
	
	public void setAuthorInfo(String authorInfo){
		this.authorInfo = authorInfo;
	}
	
	public void setBriefDescription(String briefDescription){
		this.briefDescription = briefDescription;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setDownloadUrl(String downloadUrl){
		this.downloadUrl = downloadUrl;
	}
	
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}
	
	public String getAuthorInfo(){
		return authorInfo;
	}
	
	public String getBriefDescription(){
		return briefDescription;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDownloadUrl(){
		return downloadUrl;
	}
	
	public String getImageUrl(){
		return imageUrl;
	}
	
}
