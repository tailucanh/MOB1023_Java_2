package lab1.java2;

import java.util.Scanner;



public class Product implements DAO{
	private String name;
	private double price;
	
	
	public Product() {

	}
	
	
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	

	public double getImportTax() {
		return 0.1*price;
	}
	
	
	public void input() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("-> Enter name: ");
			name = scanner.nextLine();
			System.out.print("-> Enter price: ");
			price = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("==> ERROR!");
		}
		
	}
	
	public void output() {
		System.out.printf("\t %-20s  %-20.1f  %-20.1f ", name,price,getImportTax());
		
	}


	@Override
	public void insert() {
		System.out.println("Insert success!");
		
	}


	@Override
	public void update() {
		System.out.println("update success!");
		
	}


	@Override
	public void delete() {
		System.out.println("Delete success!");
		
	}


	@Override
	public void select() {
		System.out.println("Select success!");
		
	} 
	

	

	

}
