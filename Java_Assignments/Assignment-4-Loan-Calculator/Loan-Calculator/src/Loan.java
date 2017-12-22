
public class Loan {
	
	// PRIVATE INSTANCE VARIABLES=====================
	private double annualInterestRate ;
	private int numberOfYears;
	private double loanAmount;
	
	// PUBLIC METHODS GETTER AND SETTER=====================
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	
	// CONSTRUCTORS WHICH TAKES THREE ARGUMENTS ================================
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount)
	{
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
	}
	
	// PUBLIC METHOD TO CALCULATE MONTHLY PAYMENT AND RETURN TO IT =======================
   public double getMonthlyPayament()
   {
		  double monthlyInterestRate = annualInterestRate / 1200;
		  double  monthlyPayment = loanAmount * monthlyInterestRate / (1-(1 /Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		  return monthlyPayment;
   }
   
 //  PUBLIC METHOD TO CALCULATE TOTAL PAYMENT AND RETURN TO IT ================
   public double getTotalPayment()
   {
	   double totalPayment = getMonthlyPayament() * numberOfYears * 12; 
	   return totalPayment;
	  
   }
}
