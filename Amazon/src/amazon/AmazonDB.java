package amazon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;






import model.Cart;
import model.Cartcustomer;
import model.Product;
import model.Productreview;





public class AmazonDB {
	public static ArrayList<Product> PullProducts() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Product> fd = null;

		try {
			String sql = "select t from Product t ";
			TypedQuery<Product> results = em.createQuery(sql,
					Product.class);
			
			fd = results.getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return new ArrayList<Product>(fd);
	}
	public static ArrayList<Cart> PullAllOrders() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Cart> fd = null;

		try {
			String sql = "select t from Cart t ";
			TypedQuery<Cart> results = em.createQuery(sql,
					Cart.class);
			
			fd = results.getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return new ArrayList<Cart>(fd);
	}
	
	public static ArrayList <Productreview> getProductreview(int ID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Productreview> productReview = null;

		try {
			String sql = "select u from Productreview u where u.prodid = :ID";
			TypedQuery<Productreview> q = em.createQuery(sql, Productreview.class);
			q.setParameter("ID", ID);

			productReview = q.getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return new ArrayList<Productreview>(productReview);
	}
	
	public static ArrayList<Cart> PullCart(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Cart> fd = null;

		try {
			String sql = "select t from Cart t where t.custname = :username";
			TypedQuery<Cart> results = em.createQuery(sql,
					Cart.class);
			results.setParameter("username", username);
			fd = results.getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return new ArrayList<Cart>(fd);
	}
	
	public static boolean createNewUser(String username, String pwd) {
		boolean isSuccess = false;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		Cartcustomer user = new Cartcustomer();
		user.setCustpassword(pwd);
		user.setCustname(username);

		trans.begin();

		try {
			em.persist(user);
			trans.commit();
			isSuccess = true;
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}

		return isSuccess;
	}
	
	public static boolean addToCart(Cart cartItem) {
		boolean isSuccess = false;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		/*Cartcustomer user = new Cartcustomer();
		user.setCustpassword(pwd);
		user.setCustname(username);*/

		trans.begin();

		try {
			em.persist(cartItem);
			trans.commit();
			isSuccess = true;
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}

		return isSuccess;
	}
	
	public static Product getProduct(int ID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Product prod = null;

		try {
			String sql = "select u from Product u where u.prodsku = :ID";
			TypedQuery<Product> q = em.createQuery(sql, Product.class);
			q.setParameter("ID", ID);

			prod = q.getSingleResult();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return prod;
	}
	

	
	public static Cartcustomer getProfile(String username, String pwd) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Cartcustomer usr = null;

		try {
			String sql = "select u from Cartcustomer u where u.custname = :username and u.custpassword = :pwd";
			TypedQuery<Cartcustomer> q = em.createQuery(sql, Cartcustomer.class);
			q.setParameter("username", username);
			q.setParameter("pwd", pwd);

			usr = q.getSingleResult();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return usr;
	}


	public static boolean addToReviews(Productreview pr) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();


		trans.begin();

		try {
			em.persist(pr);
			trans.commit();
			isSuccess = true;
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}

		return isSuccess;
	}
	
	/*public static void main(String[] args)
	{
		int i = 0;

		ArrayList<Productreview> p = null;
		//p.setCustomerusername("kunal");
		p =  getProductreview(1);
		for (i = 0; i <p.size(); i++) {
		System.out.println(p.get(i).getCustomerusername());
		}
	}*/
}
