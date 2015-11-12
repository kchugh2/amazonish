package amazon;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;
import model.Productreview;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
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
				/*if (session.getAttribute("username") == null)
					response.sendRedirect("Login.jsp");*/
				String user = (String) session.getAttribute("username");
				Product p = new Product();
				Productreview pr = new Productreview();
				p = AmazonDB.getProduct((Integer) session.getAttribute("prodID"));
				pr.setCustomerusername(user);
				String rate = request.getParameter("rating");
				double rating = Double.valueOf(rate);
				BigDecimal r, id;
				pr.setCustrating(  r= new BigDecimal(rating));
				pr.setProdid((int) p.getProdsku());
				pr.setCustreview(request.getParameter("review"));
				AmazonDB.addToReviews(pr);
				
				response.sendRedirect("HomeServlet");
			}
		}

