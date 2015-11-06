package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the CARTCUSTOMERS database table.
 * 
 */
@Entity
@Table(name="CARTCUSTOMERS")
@NamedQuery(name="Cartcustomer.findAll", query="SELECT c FROM Cartcustomer c")


public class Cartcustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
    @SequenceGenerator(schema="testuserdb", name="customer_seq", sequenceName="customer_seq", allocationSize=1)
	private long custid;

	private String custname;

	private String custpassword;

	public Cartcustomer() {
	}

	public long getCustid() {
		return this.custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustpassword() {
		return this.custpassword;
	}

	public void setCustpassword(String custpassword) {
		this.custpassword = custpassword;
	}

}