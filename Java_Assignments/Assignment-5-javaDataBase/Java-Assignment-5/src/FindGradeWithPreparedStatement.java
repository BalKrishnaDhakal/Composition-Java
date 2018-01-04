
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.*;

public class FindGradeWithPreparedStatement extends Application
{
	private PreparedStatement preparedStatement;
	private TextField tfSIN = new TextField();
	private Label lblStatus = new Label();
	
	@Override
	public void start(Stage primaryStage)
	{
		// INITIALIZE THE DATABASE CONNECTION AND CREATE A STATEMENT OBJECT================
		
		initializeDB();
		Button btShowGrade = new Button(" Show Grade");
		HBox hBox = new HBox(10);
		hBox.setStyle("-fx-margin:20,10,10,10; -fx-padding:10,10,10,10;-fx-background-color:WHITE; -fx-border-radius:10;-fx-padding:5; -fx-background-radius:10");
		hBox.getChildren().addAll(new Label(" SIN"), tfSIN, (btShowGrade));
		btShowGrade.setStyle("-fx-font: 16 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10;");
		tfSIN.setStyle("-fx-font: 14 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10");
		tfSIN.setPrefWidth(200);
		VBox vBox = new VBox(10);
		btShowGrade.setMouseTransparent(false);
		vBox.setStyle("-fx-margin:20,10,10,10; -fx-padding:10,10,10,10;-fx-background-color:#ffff99;-fx-border-radius:10;-fx-padding:5; -fx-background-radius:10;");
		vBox.getChildren().addAll(hBox, lblStatus);
		lblStatus.setStyle("-fx-font: 18 Verdana;");
		tfSIN.setPrefColumnCount(5);
			
		// REGISTER HANDLER ==================================

		btShowGrade.setOnAction(e -> showGrade());
		// ROUTINE FOR UI===============================================
		
		Scene scene = new Scene(vBox, 400, 200);
		primaryStage.setTitle("Find Grade");
		primaryStage.setScene(scene);
		primaryStage.show();		
		
	}
	
	private void initializeDB()
	{
		try
		{
			// LOAD JDBC DRIVER =====================================
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			System.out.println("Driver loaded.");
			// TO ESTABLISH CONNECTION ===================
				
			Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD","COMP228_F18_126","password");  
			
			System.out.println("Database connected.");
			
			// CREATE STATEMENT ========================
			String queryString = "select FIRSTNAME, MI, LASTNAME, GRADE from STUDENT where STUDENT.SIN= ?";
			preparedStatement = connection.prepareStatement(queryString);
			
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
			
		}		
	}
	
	private void showGrade()
	{
		String sin = tfSIN.getText();
		try
		{
			preparedStatement.setString(1, sin);
			ResultSet rset = preparedStatement.executeQuery();
			
			if(rset.next())
			{
				String lastName = rset.getNString(1);
				String mi = rset.getString(2);
				String firstName = rset.getString(3);
				String grade = rset.getString(4);
				
				// DISPLAY RESULT IN A LABEL =======================
				
				lblStatus.setText(firstName + " " + mi + " " + lastName + "'s grade is " + grade);
			}
			else
			{
				lblStatus.setText("Record Not Found.Please Try Again!");
				lblStatus.setTextFill(Color.RED);
				
			}	
			
		}
		
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}
	// MAIN METHOD TO LAUNCH THE APPLICATION ==========================
	
	public static void main(String[] args)
	{
		Application.launch(args);
		
	}
	
}
