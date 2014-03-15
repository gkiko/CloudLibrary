package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import database.DBConnector;

/**
 * Servlet implementation class MainService
 */
@WebServlet("/MainService")
public class MainService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double longitude = Double.parseDouble(request.getParameter("longitude"));
		double latitude = Double.parseDouble(request.getParameter("latitude"));
//		DBConnector db = DBConnector.getInstance();
		BookMark bm = new BookMark(longitude, latitude); //vaja
//		BookMark bm = new BookMark(44.789021, 41.724243); //dinamo
//		BookMark bm = new BookMark(44.818139, 41.710613); //mantobi
//		List<BookMark> ls = bm.getClosestBookMarks(1);
		
//		CommentMark bm = new CommentMark(44.818139, 41.710613);
//		List<CommentMark> ls = bm.getNearestCommentMarks(2);
//		for(CommentMark bm1 : ls){
//			System.out.println(bm1.getId());
//		}
		
		List<BookMark> ls = bm.getClosestBookMarks(2);
		BookCollection bCollection = new BookCollection();
		JSONArray array = bCollection.getBooksJsonFrom(ls);
		
		response.setContentType("text/javascript;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(array.toJSONString());
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
