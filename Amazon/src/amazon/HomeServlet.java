package amazon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Cartcustomer;
import model.Product;
/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		PrintWriter out  = response.getWriter();
		ArrayList <Product> dataset = new ArrayList <Product> ();
		dataset=AmazonDB.PullProducts();
		String message = "";
		for(int i = 0; i<dataset.size(); i++){
			
			message=message + "<div class = \"row\"<br><tr><td>" + dataset.get(i).getProdbrand()+"</td><td>"+
					"<a href= \"ProductPage?prodID="+ dataset.get(i).getProdsku()+"\">" + dataset.get(i).getProdname()+"</a>"+"</td><td>"
							 + dataset.get(i).getProddescription()+"</td><td>" + dataset.get(i).getProdcost()+"</td></tr>"+"</div>";
		}
		request.setAttribute("message",message);
		getServletContext().getRequestDispatcher("/Homepage.jsp").forward(request, response);
	}
}
