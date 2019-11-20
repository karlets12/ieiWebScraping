package application;
	
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			   ControllerInicio ci = new ControllerInicio();
			   //ControladorPrincipal controlador = loader.getController();
			   //controlador.setPrimaryStage(primaryStage);
			   
			   //-------------------------------------------SELENIUM-------------------------------------------
			   WebDriver driver = new FirefoxDriver();
			   driver.get("https://www.amazon.es/");
			   //localizamos el input del buscador
			   WebElement buscadorAmazon = driver.findElement(By.cssSelector("input.__mk_es_ES"));
			   //introducimos la cadena de búsqueda
			   String busqueda = ci.marca + ci.modelo;
			   buscadorAmazon.sendKeys(busqueda);
			   buscadorAmazon.submit();
			   
			   //Esperar 10 segundos para una condición
			   WebDriverWait waiting = new WebDriverWait(driver, 10);
			  	 //Comprobar el título de la página de respuesta
			   if( driver.getTitle().equals("Universidad Politécnica de Valencia") )
			   System.out.println("PASA");
			   else System.err.println("FALLA");
			   
		   } catch (IOException e) { 
	         e.printStackTrace(); 
		   }
	   } 
	 
	 
	public static void main(String[] args) {
		launch(args);
	}
}
