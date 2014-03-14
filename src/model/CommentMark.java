package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import database.DBConnector;

public class CommentMark {
	
	private long commentId;
	
	private double longitude, latitude;
	
	public CommentMark(double longitude, double latitude){
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public CommentMark(long commentId, double longitude, double latitude){
		this.commentId = commentId;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public double getLongitude(){
		return longitude;
	}
	
	public double getLatitude(){
		return latitude;
	}
	
	public long getId(){
		return commentId;
	}
	
	
	public List<CommentMark> getNearestCommentMarks(int maxNumResponses){
		List<CommentMark> allCommentMarks = DBConnector.getInstance().getAllCommentMarks();
		HashSet<Long> usedCommentIds = new HashSet<Long>();
		ArrayList<CommentMark> comments = new ArrayList<CommentMark>();
		for(CommentMark cm : allCommentMarks){
			if(comments.size() >= maxNumResponses) break;
			if(usedCommentIds.contains(cm.getId())) continue;
			usedCommentIds.add(cm.getId());
			comments.add(cm);
		}
		return comments;
	}
	
	public static double getDistance(CommentMark cm1, CommentMark cm2){
		int R = 6371; // km
		double lon2 = cm2.getLongitude(), lon1 = cm1.getLongitude(), lat1 = cm1.getLatitude(), lat2 = cm2.getLatitude();
		double x = (lon2 - lon1) * Math.cos((lat1 + lat2) / 2);
		double y = (lat2 - lat1);
		double distance = Math.sqrt(x * x + y * y) * R;
		return distance;
	}
	
	public Comparator<CommentMark> compareCommentsDistance = new Comparator<CommentMark>() {

		@Override
		public int compare(CommentMark arg0, CommentMark arg1) {
			CommentMark cm = new CommentMark(getLongitude(), getLatitude());
			double dist1 = getDistance(cm, arg0), dist2 = getDistance(cm, arg1);
			return dist1<dist2 ? -1 : (dist1>dist2 ? 1 : 0);
		}
	};

}
