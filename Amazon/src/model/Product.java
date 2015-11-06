package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long prodsku;

	private String prodbrand;

	private BigDecimal prodcost;

	private String proddescription;

	private String prodname;

	public Product() {
	}

	public long getProdsku() {
		return this.prodsku;
	}

	public void setProdsku(long prodsku) {
		this.prodsku = prodsku;
	}

	public String getProdbrand() {
		return this.prodbrand;
	}

	public void setProdbrand(String prodbrand) {
		this.prodbrand = prodbrand;
	}

	public BigDecimal getProdcost() {
		return this.prodcost;
	}

	public void setProdcost(BigDecimal prodcost) {
		this.prodcost = prodcost;
	}

	public String getProddescription() {
		return this.proddescription;
	}

	public void setProddescription(String proddescription) {
		this.proddescription = proddescription;
	}

	public String getProdname() {
		return this.prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

}