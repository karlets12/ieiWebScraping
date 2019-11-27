package application;

import java.util.List;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

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
	public List<Smartphone> lista; 
	
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
			   //introducimos la cadena de b�squeda
			   String busqueda= marca + " " + modelo;
			   buscadorGoogle.sendKeys(busqueda);
			   buscadorGoogle.submit();
			   //Esperar 10 segundos para una condici�n
			   WebDriverWait waiting = new WebDriverWait(driver, 10);
			   waiting.until( ExpectedConditions.presenceOfElementLocated( By.className("a-last") ) );
			  //Comprobar el t�tulo de la p�gina de respuesta
			   System.out.println("T�tulo de la p�gina " + driver.getTitle());
			   String titulo = driver.getTitle();
			   
			  String precio = driver.findElement(By.className("a-price-whole")).getText();
			  System.out.print(precio); 
			  
			  WebElement elem2 = waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='a-popover-trigger a-declarative']//span[@class='a-icon-alt']")));
			  System.out.print(elem2.getAttribute("textContent"));
			  
			  
			  
			   if( driver.getTitle().equals(titulo))
			   System.out.println("PASA");
			   else System.err.println("FALLA");
    	}
    	if(fnacCheck.isSelected()) {
    		String exePath = "C:\\firefox\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			System.out.print(marca +" " + modelo);
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.fnac.es/");
			   //localizamos el input del buscador
			   WebElement buscadorGoogle = driver.findElement(By.id("Fnac_Search"));
			   //introducimos la cadena de b�squeda
			   String busqueda= "smartphone" + " " + marca + " " + modelo;
			   buscadorGoogle.sendKeys(busqueda);
			   buscadorGoogle.submit();
			   //Esperar 10 segundos para una condici�n
			   WebDriverWait waiting = new WebDriverWait(driver, 10);
			   waiting.until( ExpectedConditions.presenceOfElementLocated( By.className("f-icon")) );
			  //Comprobar el t�tulo de la p�gina de respuesta
			   System.out.println("T�tulo de la p�gina " + driver.getTitle());
			   String titulo = driver.getTitle();
			   if( driver.getTitle().equals(titulo))
				   System.out.println("PASA");
				   else System.err.println("FALLA");		
	  
			   
			   
			   
    	}
    	if(pcComponentsCheck.isSelected()) {
    		String exePath = "C:\\firefox\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.pccomponentes.com/");
			   //localizamos el input del buscador
			   WebElement buscadorGoogle = driver.findElement(By.name("query"));
			   //introducimos la cadena de b�squeda
			   String busqueda= marca + " " + modelo;
			   buscadorGoogle.sendKeys(busqueda);
			   buscadorGoogle.submit();
			   
			   //Esperar 10 segundos para una condici�n
			   WebDriverWait waiting = new WebDriverWait(driver, 1000);
			   waiting.until( ExpectedConditions.presenceOfElementLocated( By.xpath("//*[contains(@class, 'ais-Hits')]")) );
			  
			   waitForPageLoaded(driver);
			   
			  //Comprobar el t�tulo de la p�gina de respuesta
			   System.out.println("T�tulo de la p�gina " + driver.getTitle());
			   String titulo = driver.getTitle();
			   if( driver.getTitle().equals(titulo))
				   System.out.println("PASA");
				   else System.err.println("FALLA");
			   //Extracci�n de datos
			   
			   List<WebElement> listaElementos = driver.findElements(By.xpath("//*[contains(@class, 'ais-Hits')]"));
			  
			  
			   System.out.println("N�mero de elementos de la lista: " + listaElementos.size() );
					   //Obtener cada uno de los art�culos
					   WebElement elementoActual, navegacion;
					   int j=1;
					   for (int i=0; i<listaElementos.size(); i++)
					   {
					   elementoActual = listaElementos.get(i);
					   navegacion = elementoActual.findElement(By.xpath("/html/body/header/div[3]/div[2]/section/div[2]/div[2]/ol/li[" + j +"]/div/div/div[3]"));
					   System.out.println(j + " " + navegacion.getText());
					   j++;
					   }
    		
    	}
	}
	
	
	
	
	public static void waitForPageLoaded(WebDriver driver) {
		 ExpectedCondition<Boolean> expectation = new
		 ExpectedCondition<Boolean>() {
		 public Boolean apply(WebDriver driver) {
		 return ((JavascriptExecutor) driver).executeScript("returndocument.readyState").toString().equals("complete"); }
		 };
		 try {
		 Thread.sleep(1000);
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(expectation);
		 } catch (Throwable error) {
		 System.out.println("Timeout waiting for Page Load Request to complete.");
		 }
		 }
	
}
