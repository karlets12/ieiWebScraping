package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	 private Stage primaryStage; 
	   private AnchorPane rootLayout; 
	
	
	 @Override 
	   public void start(Stage primaryStage) {
		   this.primaryStage = primaryStage; 
		   
		   initRootLayout(); 
	   } 
	 
	 public void initRootLayout() {
		   try { 
			   // Load root layout from fxml file. 
			   FXMLLoader loader = new FXMLLoader();       
			   loader.setLocation(Main.class.getResource("./Inicio.fxml")); 
			   rootLayout = (AnchorPane) loader.load();  
			   // Show the scene containing the root layout.
			   Scene scene = new Scene(rootLayout);
			   primaryStage.setScene(scene);
			   
			   //fijar tamaño ventana 
			   primaryStage.setMinHeight(400);
			   primaryStage.setMinWidth(600);
			   primaryStage.setMaxHeight(400);
			   primaryStage.setMaxWidth(600);
			   
			   primaryStage.show(); 
			   //ControladorPrincipal controlador = loader.getController();
			   //controlador.setPrimaryStage(primaryStage);
		   } catch (IOException e) { 
	         e.printStackTrace(); 
		   }
	   } 
	 
	 
	public static void main(String[] args) {
		launch(args);
	}
}
