package Beans;

import java.util.ArrayList;

public class User {
	private String name;
	private String ID;
	private String password;
	private String phoneNumber;
	private ShoppingCart cart;
	private CreditCard creCard;
	private ArrayList<Rent> rents;
	
	public User(String name,String ID,String password,String phoneNumber,CreditCard creditCard){
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.creCard = creditCard;
		this.rents = new ArrayList<Rent>();
	}
	public void setShoppingCart(ShoppingCart cart){
		this.cart = cart;
	}
	public void addRent(Rent rent){
		this.rents.add(rent);
	}
	public String getID(){
		return this.ID;
	}
	public String getName(){
		return this.name;
	}
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public String getPassword(){
		return this.password;
	}
	public ShoppingCart getShoppingCart(){
		return this.cart;
	}
	public ArrayList<Rent> getRents(){
		return this.rents;
	}
	public CreditCard getCreditCard(){
		return this.creCard;
	}
}
