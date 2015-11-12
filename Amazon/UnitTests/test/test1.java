package test;

import static org.junit.Assert.*;
import model.Cartcustomer;

import org.junit.Test;

import amazon.AmazonDB;

public class test1 {

	@Test
	public void test() {
		
		Cartcustomer usr = null;
		AmazonDB.createNewUser("david", "12345");
		usr = AmazonDB.getProfile("david", "12345");
		
		assertEquals("pass",usr.getCustname(),usr.getCustname());
	}

}
