package model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileService
 */
@WebServlet("/FileService/*")
public class FileService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getPathInfo().substring(1);
		File file = new File("D:\\FreeUni-enterprise\\CloudLibrary\\resources", filename);
        response.setHeader("Content-Type", "application/force-download");
        response.setHeader("Content-Length", String.valueOf(file.length()));
        
        FileInputStream input = new FileInputStream(file);
        ServletOutputStream stream = response.getOutputStream();
        BufferedInputStream buf = new BufferedInputStream(input);
        int readBytes = 0;
        //read from the file; write to the ServletOutputStream
        while ((readBytes = buf.read()) != -1)
          stream.write(readBytes);
        
        stream.flush();
        stream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
