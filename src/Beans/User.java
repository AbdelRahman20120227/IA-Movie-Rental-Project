package Beans;

import java.util.ArrayList;

public class User extends Person{
	
	private ShoppingCart cart;
	private ArrayList<Rent> rents;
	
	public User(String name,String ID,int age,String password,String phoneNumber,String email,String address){
		super(name, ID, age, password, phoneNumber, email, address);
		this.rents = new ArrayList<Rent>();
	}
	public void setShoppingCart(ShoppingCart cart){
		this.cart = cart;
	}
	public void addRent(Rent rent){
		this.rents.add(rent);
	}
	public ShoppingCart getShoppingCart(){
		return this.cart;
	}
	public ArrayList<Rent> getRents(){
		return this.rents;
	}
}
