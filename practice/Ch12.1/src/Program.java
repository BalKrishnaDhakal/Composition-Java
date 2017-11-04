import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {
		String firstNumber= JOptionPane.showInputDialog("Please, enter first integer: ");
		String secondNumber= JOptionPane.showInputDialog("Please, enter second integer: ");
		 int num1=Integer.parseInt(firstNumber);
		 int num2 =Integer.parseInt(secondNumber);
		 int result = num1+num2;
		 JOptionPane.showMessageDialog(null, "The sum of your input is: "+ result, "The sum of two Integer", JOptionPane.PLAIN_MESSAGE);

	}

}
