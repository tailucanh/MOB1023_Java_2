package lesson1.java2;

import java.util.Scanner;

import lab1.java2.DAO;

public class SinhVien{
	
	private String id;
	private String name;
	private double point;
	
	public SinhVien() {
		
	}
	
	public SinhVien(String id, String name, double point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
	public void input(Scanner scanner) {
		try {
			boolean check = false;
			do {
				try {
					System.out.print(" - Enter ID: ");
					
					this.id = scanner.nextLine();
					
					
					if (this.id.isEmpty() || this.id.equals(" ")) {
						System.out.println("  --> PLEASE ENTER ID!");
						check = true;
					}else {
						check = false;
					}
				} catch (Exception e) {
					check = true;
				}
			} while (check);
			
			do {
				try {
					System.out.print(" - Enter name: ");
					this.name = scanner.nextLine();
					if (this.name.isEmpty() || this.name.equals(" ")) {
						System.out.println("\t  --> PLEASE ENTER NAME!");
						check = true;
					}else {
						check = false;
					}
				} catch (Exception e) {
					check = true;
				}
			} while (check);
			
			do {
				try {
					System.out.print(" - Enter point: ");
					String assignPoint = String.valueOf(this.point);
					assignPoint = scanner.nextLine();
					
					String checkPoint = "\\d{1,5}";
					
					if (assignPoint.isEmpty() || assignPoint.equals(" ")) {
						System.out.println("\t  --> PLEASE ENTER POINT!");
						check = true;
					}else if (!assignPoint.matches(checkPoint)) {
						System.out.println("\t  --> PLEASE ENTER THE CORRECT NUMBER OF POINTS!");
						check = true;
					}else if (Double.valueOf(assignPoint) < 0 ) {
						System.out.println("\t  --> POINT MUST BE GREATER THAN 0! PLEASE RE-ENTER!");
						check = true;
					}else{
						check = false;
						this.point = Double.valueOf(assignPoint);
					}
				} catch (Exception e) {
					check = true;
				}
			} while (check);			
		} catch (Exception e) {
			System.out.println("==> ERROR!");
		}

		
	}
	
	public void output() {
		System.out.printf("\n %20s %20s %20.1f ",id,name,point);
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}



	
	
	
}
