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

import javafx.application.Platform;
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

	public String marca = "";
	public String modelo = "";
	public String telf = "teléfono móvil";
	public Double precio;

	public void initialize() {
		stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("BUSCADOR");
		cargarComboMarcas();
		// obtener el valor del combo:
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
	private void botonBuscar(ActionEvent event) throws InterruptedException {
		marca = comboBox.getValue();
		modelo = input.getText();
		compruebaCheckBox(marca, modelo);

	}

	 public void compruebaCheckBox(String marca, String modelo) throws InterruptedException {
		if (amazonCheck.isSelected()) {
			String exePath = "C:\\firefox\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.amazon.es/");
			// BUSCADOR
			WebElement buscadorAmazon = driver.findElement(By.id("twotabsearchtextbox"));
			// CADENA DE BÚSQUEDA
			String busqueda = marca + " " + modelo;
			buscadorAmazon.sendKeys(busqueda);
			buscadorAmazon.submit();
			// ESPERA
			WebDriverWait waiting = new WebDriverWait(driver, 10);
			waiting.until(ExpectedConditions.presenceOfElementLocated(By.className("a-last")));
			// TÍTULO DE RESPUESTA
			System.out.println("Título de la página " + driver.getTitle());

			List<WebElement> listaPreciosAmazon = driver
					.findElements(By.xpath("//*[contains(@class, 'a-price-whole')]"));
			
			//DUDA NO ME LISTA LOS NOMBRES DE LOS PRODUCTOS DE AMAZON
			List<WebElement> listaNombresAmazon = driver
					.findElements(By.xpath("//*[contains(@class, 's-result-item')]"));

			System.out.println("Número de elementos de la lista: " + listaNombresAmazon.size());
			
			WebElement precioActual, nombreActual, precio;
			String nombre;
			int j = 1;
			for (int i = 0; i < 5; i++) {
				precioActual = listaPreciosAmazon.get(i);
				nombreActual = listaNombresAmazon.get(i);
				Thread.sleep(400);
				try {
				precio = precioActual
						.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/span[4]/div[1]/div[" + j
								+ "]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/span[2]"));
				nombre = nombreActual.findElement(By.cssSelector("span.a-text-normal")).getText().substring(0,18);
				System.out.println(nombre);
					System.out.println(j + " " + precio.getText());
				}catch(Exception e) {
					System.out.println("No hay más resultados para esta búsqueda");
				}
				j++;
			}

		}
		if (fnacCheck.isSelected()) {
			String exePath = "C:\\firefox\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			System.out.print(marca + " " + modelo);
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.fnac.es/");
			//BUSCADOR
			WebElement buscadorFnac = driver.findElement(By.id("Fnac_Search"));
			//CADENA DE BÚSQUEDA
			String busqueda = marca + " " + modelo;
			buscadorFnac.sendKeys(busqueda);
			buscadorFnac.submit();
			//ESPERA
			WebDriverWait waiting = new WebDriverWait(driver, 10);
			waiting.until(ExpectedConditions.presenceOfElementLocated(By.className("f-icon")));
			//TÍTULO PÁGINA
			System.out.println("Título de la página " + driver.getTitle());
			//BUSCANDO ELEMENTOS
			List<WebElement> listaPreciosFnac = driver
					.findElements(By.xpath("//*[contains(@class, 'a-price-whole')]"));
			//System.out.println("Número de elementos de la lista: " + listaElementosAmazon.size());
			
			WebElement precioActual, nombreActual, precio, nombre;
			/*int j = 1;
			for (int i = 0; i < 5; i++) {
				precioActual = listaPreciosAmazon.get(i);
				Thread.sleep(400);
				try {
				precio = precioActual
						.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/span[4]/div[1]/div[" + j
								+ "]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/span[2]"));
				nombre = nombreActual.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/span[4]/div[1]/div[" +j +"]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));
				System.out.println(nombre);
					System.out.println(j + " " + precio.getText());
				}catch(Exception e) {
					System.out.println("No hay más resultados para esta búsqueda");
				}
				j++;
			}*/

		}
		if (pcComponentsCheck.isSelected()) {
			String exePath = "C:\\firefox\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.pccomponentes.com/");
			// localizamos el input del buscador
			WebElement buscadorPcComponents= driver.findElement(By.name("query"));
			// introducimos la cadena de búsqueda
			String busqueda = telf + " " + marca + " " + modelo;
			buscadorPcComponents.sendKeys(busqueda);
			buscadorPcComponents.submit();

			// Esperar 10 segundos para una condición
			WebDriverWait waiting = new WebDriverWait(driver, 1000);
			waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ais-Hits')]")));
			waitForPageLoaded(driver);
			// Comprobar el título de la página de respuesta
			System.out.println("Título de la página " + driver.getTitle());
			String titulo = driver.getTitle();
			if (driver.getTitle().equals(titulo))
				System.out.println("PASA");
			else
				System.err.println("FALLA");
			// Extracción de datos

			List<WebElement> listaElementos = driver.findElements(By.xpath("//*[contains(@class, 'ais-Hits')]"));
			System.out.println("Número de elementos de la lista: " + listaElementos.size());
			waitForPageLoaded(driver);
			// Obtener cada uno de los artículos
			WebElement elementoActual, navegacion;
			int j = 1;
			for (int i = 0; i < listaElementos.size()-2; i++) {
				elementoActual = listaElementos.get(i);
				navegacion = elementoActual.findElement(By.xpath(
						"/html/body/header/div[3]/div[2]/section/div[2]/div[2]/ol/li[" + j + "]/div/div/div[3]"));
				try {
				Thread.sleep(100);
				System.out.println(j + " " + navegacion.getText());
				j++;
				}catch(Exception e) {
					System.out.println("No hay más resulatdos para esta búsqueda.");
				}
				
			}

		}
	}

	public static void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("returndocument.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete.");
		}
	}
	

	/* Comprobar el título de la página de respuesta
	System.out.println("Título de la página " + driver.getTitle());
	String titulo = driver.getTitle();
	if (driver.getTitle().equals(titulo))
		System.out.println("PASA");
	else
		System.err.println("FALLA");*/

}
