package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCTREVIEW database table.
 * 
 */
@Entity
@NamedQuery(name="Productreview.findAll", query="SELECT p FROM Productreview p")
public class Productreview implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/*CHANGE PRODID FROM BIGDECIMAL TO INT!*/
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="review_seq")
    @SequenceGenerator(schema="testuserdb", name="review_seq", sequenceName="review_seq", allocationSize=1)
	private long reviewkey;

	private String customerusername;

	private BigDecimal custrating;

	private String custreview;

	private int prodid;

	public Productreview() {
	}

	public long getReviewkey() {
		return this.reviewkey;
	}

	public void setReviewkey(long reviewkey) {
		this.reviewkey = reviewkey;
	}

	public String getCustomerusername() {
		return this.customerusername;
	}

	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}

	public BigDecimal getCustrating() {
		return this.custrating;
	}

	public void setCustrating(BigDecimal custrating) {
		this.custrating = custrating;
	}

	public String getCustreview() {
		return this.custreview;
	}

	public void setCustreview(String custreview) {
		this.custreview = custreview;
	}

	public int getProdid() {
		return this.prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

}