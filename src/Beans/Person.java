package Beans;

public class Person {
	private String name;
	private String ID;
	private String password;
	private String phoneNumber;
	private String email;
	private int age;
	private String address;
	public Person(String name,String ID,int age,String password,String phoneNumber,String email,String address){
		this.name = name;
		this.age = age;
		this.ID = ID;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
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
	public String getEmail(){
		return this.email;
	}
	public String getAddress(){
		return this.address;
	}
	public int getAge(){
		return this.age;
	}
}
