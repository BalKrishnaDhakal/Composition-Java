import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
    private TextField textFieldAnnualIntRate = new TextField();
    private TextField textFieldNumberOfYears = new TextField();
    private TextField textFieldLoanAmount = new TextField();
    private TextField textFieldMonthlyPateyment = new TextField();
    private TextField textFieldTotalPayment = new TextField();
    private Button buttonCalculate = new Button("Calculate");
    private Button buttonReset = new Button(" Reset ");
  
    @Override 
    public void start(Stage primaryStage) {
        // TO CREATE USER INTERFACE=============================
    	
    	GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(new Label("Annual Interest Rate:"), 0,0); // (columnIndex ,rowIndex)
        gridPane.add(textFieldAnnualIntRate, 1, 0);    
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(textFieldNumberOfYears, 1, 1);
        gridPane.add(new Label("Loan Amount:"), 0, 2);
        gridPane.add(textFieldLoanAmount, 1, 2);
        gridPane.add(new Label("Monthly Payment:"), 0, 3);
        gridPane.add(textFieldMonthlyPateyment, 1, 3);
        gridPane.add(new Label("Total Payment:"), 0, 4);
        gridPane.add(textFieldTotalPayment, 1, 4);
        gridPane.add(buttonCalculate, 1, 5);
        gridPane.add(buttonReset, 0, 5);
    
        //TO SET THE PROPERTIES FOR THE USER INTERFACE=======================
        gridPane.setAlignment(Pos.CENTER);
        textFieldAnnualIntRate.setAlignment(Pos.BOTTOM_RIGHT);
        textFieldNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        textFieldLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        textFieldMonthlyPateyment.setAlignment(Pos.BOTTOM_RIGHT);
        textFieldTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        textFieldMonthlyPateyment.setEditable(false);
        textFieldTotalPayment.setEditable(false);
        GridPane.setHalignment(buttonCalculate, HPos.RIGHT);
        GridPane.setHalignment(buttonReset, HPos.LEFT);
        gridPane.setStyle("-fx-background-color: #ffff99;-fx-font: 15 Verdana;  -fx-border-color: #2e8b57; -fx-border-width: 2px; -fx-padding: 4;  -fx-spacing: 4;");
        buttonReset.setStyle("-fx-font: 18 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5; -fx-background-radius:10");
        buttonCalculate.setStyle("-fx-font: 18 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5; -fx-background-radius:10");
        
        // BEGINS PROCESS EVENTS HERE =========================
        buttonCalculate.setOnAction(e -> calculateLoanPayment(e));
        buttonReset.setOnAction(e -> Reset());
  
        // TO CREATE SECENE AND PLACE IT INSIDE STAGE=================
        Scene scene = new Scene(gridPane, 400, 350);
 
        primaryStage.setTitle("JavaFx Loan Calculator"); // Set title
        
        primaryStage.setScene(scene); // Place the scene in the stage
      // TO DISPLAY THE STAGE==========================
      
          primaryStage.show(); 
    	}
    
    private void calculateLoanPayment(ActionEvent event) {
        // TO GET USER'S INPUT ============================
    	
        	 try { 
        double interest = Double.parseDouble(textFieldAnnualIntRate.getText());
        int year = Integer.parseInt(textFieldNumberOfYears.getText());
        
        double loanAmount = Double.parseDouble(textFieldLoanAmount.getText());

        Loan loan = new Loan(interest, year, loanAmount);

      //  TO DISPLAY MONTHLY PAYMENT AND TOTAL PAYMENT============================
       
        	
        textFieldMonthlyPateyment.setText(String.format("$%.2f",
                                               loan.getMonthlyPayament()));
        textFieldTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
    	 	}
        	 // TO CHECK VALIDATITY AND RETURN THE ERROR MESSAGE======================
    	 catch (NumberFormatException ex ) {
    		 textFieldAnnualIntRate.setText("Enter Rate");
    		 textFieldAnnualIntRate.setStyle("-fx-text-inner-color: red;");
    		 textFieldNumberOfYears.setText("Enter Number of Years");
    		 textFieldNumberOfYears.setStyle("-fx-text-inner-color: red;");
    		 textFieldLoanAmount.setText("Enter Loan Amount");
    		 textFieldLoanAmount.setStyle("-fx-text-inner-color: red;");
    		 
    	    }
    }
    
    private void Reset() {
 
    	textFieldAnnualIntRate.clear();
    	textFieldNumberOfYears.clear();
    	textFieldLoanAmount.clear();
    	textFieldMonthlyPateyment.clear();
    	textFieldTotalPayment.clear();
    }
   
    public static void main(String[] args) {
        launch(args);
    }

}
