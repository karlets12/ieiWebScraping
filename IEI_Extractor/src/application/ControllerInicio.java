package application;

import java.awt.List;
import java.net.URL;

import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerInicio {
	@FXML
	private ComboBox<String> comboBox; 
	@FXML
	private TextField input;
	@FXML
	private CheckBox amazonCheck;
	@FXML
	private CheckBox fnacCheck;
	@FXML
	private CheckBox pcComponentsCheck;
	@FXML
	private Button buttonBuscar;
	
	protected Stage stage;
	
	public String marca="";
	public String modelo="";
	
	public void initialize() {
		stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("BUSCADOR");
		cargarComboMarcas();
		//obtener el valor del combo:
	}
	
	private void cargarComboMarcas() {
        ArrayList<String> marcas = new ArrayList<String>();
        marcas.add("Samsung");
        marcas.add("LG");
        marcas.add("Sony");
        marcas.add("Huawei");
        marcas.add("Motorola");
        marcas.add("Apple");
        marcas.add("One Plus");
        marcas.add("Lenovo");
        marcas.add("Xiaomi");
        ObservableList<String> obsA = FXCollections.observableArrayList(marcas);
        comboBox.setItems(obsA);
    }
	
	@FXML
   private void botonBuscar(ActionEvent event) {
    	marca = comboBox.getValue();
    	modelo = input.getText();
    	compruebaCheckBox(marca, modelo);
    	
    }
	
	
	public void compruebaCheckBox(String marca, String modelo) {
		if (amazonCheck.isSelected()) {
			String exePath = "C:\\firefox\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			System.out.print(marca +" " + modelo);
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.amazon.es/");
			   //localizamos el input del buscador
			   WebElement buscadorGoogle = driver.findElement(By.id("twotabsearchtextbox"));
			   //introducimos la cadena de búsqueda
			   String busqueda= marca + " " + modelo;
			   buscadorGoogle.sendKeys(busqueda);
			   buscadorGoogle.submit();
			   
			   //Esperar 10 segundos para una condición
			   WebDriverWait waiting = new WebDriverWait(driver, 10);
			  waiting.until( ExpectedConditions.presenceOfElementLocated( By.className("a-last") ) );
			  
			  //Comprobar el título de la página de respuesta
			   System.out.println("Título de la página " + driver.getTitle());
			   String titulo = driver.getTitle();
			   
			  String precio = driver.findElement(By.className("a-price-whole")).getText();
			  System.out.print(precio); 
			  
			  WebElement elem2 = waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='a-popover-trigger a-declarative']//span[@class='a-icon-alt']")));
			  System.out.print(elem2.getAttribute("textContent"));
			  
			  
			  
			   if( driver.getTitle().equals(titulo))
			   System.out.println("PASA");
			   else System.err.println("FALLA");
    	}
    	/*if(fnacCheck.isSelected()) {
    		
    	}
    	if(pcComponentsCheck.isSelected()) {
    		
    	}*/
	}
	
	
}
