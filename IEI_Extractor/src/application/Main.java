package application;
	
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
			   
			   //fijar tama�o ventana 
			   primaryStage.setMinHeight(400);
			   primaryStage.setMinWidth(600);
			   primaryStage.setMaxHeight(400);
			   primaryStage.setMaxWidth(600);
			   
			   primaryStage.show(); 
			   }
		 catch(Exception e) {}
		
	 }
	 
	 private static WebDriver driver = null;
	 
	public static void main(String[] args) {
		launch(args);
		/*String exePath = "C:\\firefox\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);*/
		
	}
	/*
	 * public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("**************** Inicio de Selenium *********************");
		String exePath = "C:\\firefox\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);
		
		WebDriver driver = new FirefoxDriver();
		   driver.get("https://www.google.com/");
		   //localizamos el input del buscador
		   WebElement buscadorGoogle = driver.findElement(By.name("q"));
		   //introducimos la cadena de b�squeda
		   //String busqueda = ci.marca + ci.modelo;
		   String busqueda= "upv";
		   buscadorGoogle.sendKeys(busqueda);
		   //buscadorGoogle.sendKeys(Keys.ENTER);
		   buscadorGoogle.submit();
		   
		   //Esperar 10 segundos para una condici�n
		   WebDriverWait waiting = new WebDriverWait(driver, 1cb0);
		   waiting.until( ExpectedConditions.presenceOfElementLocated( By.id("pnnext") ) );
		  	 //Comprobar el t�tulo de la p�gina de respuesta
		   System.out.println("T�tulo de la p�gina " + driver.getTitle());
		   if( driver.getTitle().equals("upv - Buscar con Google") )
		   System.out.println("PASA");
		   else System.err.println("FALLA");

	}*/
}
