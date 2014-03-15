package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

/**
 * Servlet implementation class CommentService
 */
@WebServlet("/CommentService")
public class CommentService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		double longitude = Double.parseDouble(request.getParameter("longitude"));
		double latitude = Double.parseDouble(request.getParameter("latitude"));
		CommentMark bm = new CommentMark(longitude, latitude);
		List<CommentMark> ls = bm.getNearestCommentMarks(2);
		
		CommentCollection cCollection = new CommentCollection();
		JSONArray array = cCollection.getCommentsJsonFrom(ls);
		response.setContentType("text/javascript;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(array.toJSONString());
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		BufferedReader br = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		System.out.println(br.readLine());
		while((line = br.readLine()) != null){
			System.out.println(line);
			sb.append(line);
		}
		System.out.println(sb.toString());
	}

}
