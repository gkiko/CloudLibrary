package Model;
import java.util.*;

import database.*;

public class BookMark {
	private long bookId;
	
	private double longitude, latitude;
	
	public BookMark(long bookId, double longitude, double latitude){
		this.bookId = bookId;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	private BookMark(double longitude, double latitude){
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public long getBookId(){
		return bookId;
	}
	
	public double getLongitude(){
		return longitude;
	}
	
	public double getLatitude(){
		return latitude;
	}
	
	public static double getDistanceBetween(BookMark bm1, BookMark bm2){
		int R = 6371; // km
		double lon2 = bm2.getLongitude(), lon1 = bm1.getLongitude(), lat1 = bm1.getLatitude(), lat2 = bm2.getLatitude();
		double x = (lon2 - lon1) * Math.cos((lat1 + lat2) / 2);
		double y = (lat2 - lat1);
		double distance = Math.sqrt(x * x + y * y) * R;
		return distance;
	}
	
	public List<BookMark> getClosestBookMarks(double longitude, double latitude, int maxNumResponses){
		List<BookMark> allBookMarks = DBConnector.getInstance().getAllBookMarks();
		Collections.sort(allBookMarks, new BookMark(longitude, latitude).compareBookMarksDist);
		HashSet<Long> usedIds = new HashSet<Long>();
		ArrayList<BookMark> list = new ArrayList<BookMark>();
		for(BookMark mark : allBookMarks){
			if(list.size()>=maxNumResponses) return list;
			if(usedIds.contains(mark.getBookId())) continue;
			usedIds.add(mark.getBookId());
			list.add(mark);
		}
		return list;
	}
	
	public Comparator<BookMark> compareBookMarksDist = new Comparator<BookMark>() {
		
		@Override
		public int compare(BookMark arg0, BookMark arg1) {
			double lon = getLongitude(), lat = getLatitude();
			double dist1 = getDistanceBetween(new BookMark(lon, lat), arg0), dist2 = getDistanceBetween(new BookMark(lon, lat), arg1);
			return dist1<dist2 ? -1 : dist1>dist2 ? 1 : arg0.hashCode() - arg1.hashCode();
		}
	};
	
	public static Comparator<BookMark> compareBookMarks = new Comparator<BookMark>() {
		
		@Override
		public int compare(BookMark arg0, BookMark arg1) {
			long dif = arg0.getBookId() - arg1.getBookId();
			return (dif>0 ? 1 : (dif<0 ? -1 : 0));
		}
	};
	
}
