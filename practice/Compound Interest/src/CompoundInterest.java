
public class CompoundInterest {
	private double principal;
	private double interestRate;
	private int year;

	// CONSTRUCTOR=================================================
	public CompoundInterest(double principal, double interestRate, int year) {
		this.principal = principal;
		this.interestRate = interestRate;
		this.year = year;
	}

	public String toString() {
		String output = "";
		output += "=====================================";
		output += "Year" + "Amount";
		return output;
	}

	public double Calculate() {
		double amount = this.principal * Math.pow(1 + this.interestRate / 100, this.year);
		return amount;
	}
}
