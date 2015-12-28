package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Movie;
import DatabaseLayer.MovieDAO;

/**
 * Servlet implementation class CreateMoveController
 */
@WebServlet("/CreateMoveController")
public class CreateMoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMoveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         MovieDAO.insertMoive(new Movie(request.getParameter("movieName"), request.getParameter("movieYear"), Float.valueOf(request.getParameter("movieReating")), request.getParameter("movieType"), request.getParameter("movieDescription"), Integer.valueOf(request.getParameter("movieQuality")), Integer.valueOf(request.getParameter("movieQuantity")), Float.valueOf("moivePrice"), request.getParameter("movieCast"))); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request, response);
	}

}
