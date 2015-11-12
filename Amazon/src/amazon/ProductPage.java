package amazon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Productreview;

/**
 * Servlet implementation class ProductPage
 */
@WebServlet("/ProductPage")
public class ProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductPage() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		PrintWriter out = response.getWriter();
		Product dataset = new Product();
		int i=0;
		ArrayList<Productreview> dataset2 = new ArrayList<Productreview>();
		String skustring = request.getParameter("prodID");

		HttpSession session = request.getSession();
		String prodString = request.getParameter("prodID");
		int prodID = Integer.parseInt(prodString);
		session.setAttribute("prodID", prodID);
		int sku = Integer.parseInt(skustring);
		dataset = AmazonDB.getProduct(sku);

		dataset2 = AmazonDB.getProductreview(sku);
		String message = "";
		String message2 = "";
		message = message + "<div class = \"row\"<br><td>" + dataset.getProdbrand()
				+ "</td><td>" + dataset.getProdname() + "</td><td>"
				+ dataset.getProddescription() + "</td><td>"
				+ dataset.getProdcost() + "</td>" + "</div>";

		if (dataset2 != null) {
			for(int j = 0; j< dataset2.size(); j++) {
				message2 = message2 + "<div <br><tr><td>"
						+ dataset2.get(j).getCustomerusername() + "</td><td>"
						+ dataset2.get(j).getCustrating() + "</td><td>"
						+ dataset2.get(j).getCustreview() + "</td><td>"
						+ "</tr></div>";
			}
		} else
			message2 = "<h4> There Are No Reviews Yet</h4>";

		request.setAttribute("message", message);
		request.setAttribute("message2", message2);
		request.setAttribute("url", dataset.getImageLink());
		getServletContext().getRequestDispatcher("/ProdPage.jsp").forward(
				request, response);
	}
}
