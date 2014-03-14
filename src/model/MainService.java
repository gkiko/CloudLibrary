package model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
//		DBConnector db = DBConnector.getInstance();
//		BookMark bm = new BookMark(44.760654, 41.726917); //vaja
//		BookMark bm = new BookMark(44.789021, 41.724243); //dinamo
//		BookMark bm = new BookMark(44.818139, 41.710613); //mantobi
//		List<BookMark> ls = bm.getClosestBookMarks(1);
		
		CommentMark bm = new CommentMark(44.818139, 41.710613);
		List<CommentMark> ls = bm.getNearestCommentMarks(2);
		for(CommentMark bm1 : ls){
			System.out.println(bm1.getId());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
