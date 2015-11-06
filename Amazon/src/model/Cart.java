package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the CART database table.
 * 
 */
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cart_seq")
    @SequenceGenerator(schema="testuserdb", name="cart_seq", sequenceName="cart_seq", allocationSize=1)
	private long cartkey;

	private BigDecimal cartid;

	private String custname;

	private BigDecimal prodcost;

	private String product;

	public Cart() {
	}

	public long getCartkey() {
		return this.cartkey;
	}

	public void setCartkey(long cartkey) {
		this.cartkey = cartkey;
	}

	public BigDecimal getCartid() {
		return this.cartid;
	}

	public void setCartid(BigDecimal cartid) {
		this.cartid = cartid;
	}

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public BigDecimal getProdcost() {
		return this.prodcost;
	}

	public void setProdcost(BigDecimal prodcost) {
		this.prodcost = prodcost;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}