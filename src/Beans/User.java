package Beans;

import java.util.ArrayList;

public class User {
	private String ID;
	private String name;
	private String password;
	private String phoneNumber;
	private ShoppingCart cart;
	private ArrayList<Rent> rents;

	public User(String iD, String name, String password, String phoneNumber,
			ShoppingCart cart, ArrayList<Rent> rents) {
		super();
		ID = iD;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.cart = cart;
		this.rents = rents;
	}

	public User(String name, String password, String phoneNumber,
			ShoppingCart cart, ArrayList<Rent> rents) {
		super();
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.cart = cart;
		this.rents = rents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public ArrayList<Rent> getRents() {
		return rents;
	}

	public void setRents(ArrayList<Rent> rents) {
		this.rents = rents;
	}

}
