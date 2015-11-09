package amazon;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double totalCost = 0, cost=0;
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null)
			response.sendRedirect("LoginServlet");
		else {
			PrintWriter out = response.getWriter();
			ArrayList<Cart> dataset = new ArrayList<Cart>();

			dataset = AmazonDB.PullCart((String) session
					.getAttribute("username"));
			String message = "";
			for (int i = 0; i < dataset.size(); i++) {
				message = message + "<div class = \"row\"<br><tr><td>"
						+ dataset.get(i).getProduct() + "</td><td>"
						+ dataset.get(i).getProdcost() + "</td></tr><br>";
			
				cost = (dataset.get(i).getProdcost()).doubleValue();
				totalCost= totalCost+ cost ;
			}
			request.setAttribute("message", message);
			request.setAttribute("cost", totalCost);
			getServletContext().getRequestDispatcher("/Fullcart.jsp").forward(
					request, response);

		}
	}
}
