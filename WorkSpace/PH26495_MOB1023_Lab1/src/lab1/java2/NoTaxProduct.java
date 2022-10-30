package lab1.java2;

public class NoTaxProduct extends Product{

	
	@Override
	public double getImportTax() {
		return 0;
	}
	
}
