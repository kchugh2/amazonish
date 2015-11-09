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
		Product dataset = new Product();
		String skustring =request.getParameter("prodID");
		HttpSession session = request.getSession();
		String prodString = request.getParameter("prodID");
		int prodID = Integer.parseInt(prodString);
		session.setAttribute("prodID", prodID );
		int sku = Integer.parseInt(skustring);
		dataset=AmazonDB.getProduct(sku);
		String message = "";
		message="<div class = \"row\"<br><td>" + dataset.getProdbrand()+"</td><td>"+
					"<a href= \"/ProductPage.jsp\">" + dataset.getProdname()+"</a>"+"</td><td>"
							 + dataset.getProddescription()+"</td><td>" + dataset.getProdcost()+"</td>"+"</div>";
		
		request.setAttribute("message",message);
		request.setAttribute("url", dataset.getImageLink());
		getServletContext().getRequestDispatcher("/ProdPage.jsp").forward(request, response);
	}
}
