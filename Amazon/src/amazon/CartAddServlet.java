package amazon;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddServlet() {
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
				HttpSession session = request.getSession();
				// TODO Auto-generated method stub
				String user = (String) session.getAttribute("username");
				Product p = new Product();
				p = AmazonDB.getProduct((Integer) session.getAttribute("prodID"));
				Cart cartItem = new Cart();
				cartItem.setProduct(p.getProdname());
				cartItem.setCustname(user);
				cartItem.setProdcost(p.getProdcost());
				AmazonDB.addToCart(cartItem);
				
				response.sendRedirect("CartServlet");
			}
		}

