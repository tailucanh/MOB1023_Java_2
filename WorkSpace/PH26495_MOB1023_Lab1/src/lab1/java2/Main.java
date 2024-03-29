package lab1.java2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {	

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			
			ArrayList<Product> listProducts = new ArrayList<Product>();
			
			
			Product product = new Product();
			NoTaxProduct noPr = new NoTaxProduct();
			boolean check = true;
			
			int i = 1;
			do {
				try {
					System.out.print("  >> SELECT TYPE\n\t 1.Product 2.NoTaxProduct\n Please choose: ");
					int select = Integer.parseInt(scanner.nextLine());
					System.out.printf("  >> IMPORT THE PRODUCTS %d \n",i);
					switch (select) {
						case 1: 
							product.input();
							listProducts.add(product);
							break;
						case 2: 
							noPr.input();
							listProducts.add(noPr);
							break;
						default:
							System.out.println("   --> Please re-enter!");
					}
					
		
					System.out.print("  >> SELECT TYPE\n\t 1.Insert 2.Update 3.Delete 4.Select\n Please choose: ");
					int select2 = Integer.parseInt(scanner.nextLine());
					switch (select2) {
					case 1: 
						product.insert();
						break;
					case 2: 
						product.update();
						break;
					case 3: 
						product.delete();
						break;
					case 4: 
						product.select();
						break;
					default:
						System.out.println("   --> Please re-enter!");
					}					
					
					
					
					System.out.print("--> Do you want to continue entering? Y/N: ");
					String enter =  scanner.nextLine();
					i++;
					if(enter.equalsIgnoreCase("y")) {
						check = true;
					}else {
						check = false;
					}
				
				} catch (Exception e) {
					check = true;
				}
				
			} while (check);
			
			System.out.printf("\t %-20s  %-20s  %-20s \n", "Name","Price", "ImportTax");
			for(Product list : listProducts) {
				list.output();
				System.out.println("");
			}			
		} catch (Exception e) {
			System.out.println("==> ERROR!");
		}
		

		
			
	}

}
