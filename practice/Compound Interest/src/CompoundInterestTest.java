import java.util.Scanner;

public class CompoundInterestTest {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("enter principal");
		double principal = input.nextDouble();
		System.out.print("enter interest rate");
		double interestRate = input.nextDouble();
		System.out.print("enter year");
		int year = input.nextInt();
		CompoundInterest myInterset = new CompoundInterest(principal, interestRate, year);
		//double result = myInterset.Calculate();
		System.out.printf("%.2f", myInterset.Calculate());
	}

}
