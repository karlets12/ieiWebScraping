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
	public ArrayList<Smartphone> smartphones = new ArrayList<Smartphone>();
	public double precioActAmazon;
	public double precioAntAmazon;
	public double precioActPcComponentes;
	public double precioAntPcComponentes;

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
			// CADENA DE Bï¿½SQUEDA
			String busqueda = marca + " " + modelo;
			buscadorAmazon.sendKeys(busqueda);
			buscadorAmazon.submit();
			// ESPERA
			WebDriverWait waiting = new WebDriverWait(driver, 10);
			waiting.until(ExpectedConditions.presenceOfElementLocated(By.className("a-last")));
			// Tï¿½TULO DE RESPUESTA
			System.out.println("Titulo de la pï¿½gina " + driver.getTitle());

			//ELEMENTOS
			List<WebElement> listaElementos = driver
					.findElements(By.xpath("//*[contains(@class, 's-result-item')]"));

			System.out.println("Numero de elementos de la lista: " + listaElementos.size());
			String nombre="";
			String precioActual="";
			String precioAnterior="";
			String vendedor= "Amazon";
			int j = 1;
			for (int i = 0; i < listaElementos.size(); i++) {
				try {
					nombre = listaElementos.get(i).findElement(By.cssSelector("span.a-text-normal")).getText();
					precioActual = listaElementos.get(i).findElement(By.cssSelector("span[class='a-price']")).getText();
					precioActAmazon= Double.parseDouble(precioActual.replace("€", "").replace(",","."));
					//System.out.println("Nombre:" + nombre + ", Precio:" + precio);
					try {
						nombre = listaElementos.get(i).findElement(By.cssSelector("span.a-text-normal")).getText();
						precioAnterior = listaElementos.get(i).findElement(By.cssSelector("span[class='a-price a-text-price']")).getText();
						//System.out.println("Nombre:" + nombre + ", Precio:" + precioAnterior);
					}catch(Exception e) {
						nombre = listaElementos.get(i).findElement(By.cssSelector("span.a-text-normal")).getText();
						precioAnterior=precioActual;
						precioAntAmazon= Double.parseDouble(precioAnterior.replace("€", "").replace(",","."));
						//System.out.println("Nombre:" + nombre + ", Precio:" + precioAnterior);
					}
				}catch(Exception e) {
					precioActual=listaElementos.get(i).findElement(By.cssSelector("span[class='a-color-base']")).getText();
					precioAnterior=precioActual;
					precioAntAmazon= Double.parseDouble(precioAnterior.replace("€", "").replace(",","."));
				}
				
					if(nombre.trim().toLowerCase().contains(modelo.toLowerCase()) && nombre.trim().toLowerCase().contains(marca.toLowerCase())) {
						if(precioAntAmazon > 50 && precioActAmazon>50) {
							Smartphone smart = new Smartphone(nombre, precioActual, precioAnterior, vendedor);
							smartphones.add(smart);
						}
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
			//CADENA DE Bï¿½SQUEDA
			String busqueda = marca + " " + modelo;
			buscadorFnac.sendKeys(busqueda);
			buscadorFnac.submit();
			//ESPERA
			WebDriverWait waiting = new WebDriverWait(driver, 10);
			waiting.until(ExpectedConditions.presenceOfElementLocated(By.className("f-icon")));
			//Tï¿½TULO Pï¿½GINA
			System.out.println("Tï¿½tulo de la pï¿½gina " + driver.getTitle());
			//BUSCANDO ELEMENTOS
			List<WebElement> listaPreciosFnac = driver
					.findElements(By.xpath("//*[contains(@class, 'a-price-whole')]"));
			//System.out.println("Nï¿½mero de elementos de la lista: " + listaElementosAmazon.size());
			
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
					System.out.println("No hay mï¿½s resultados para esta bï¿½squeda");
				}
				j++;
			}*/

		}
		if (pcComponentsCheck.isSelected()) {
			String exePath = "C:\\firefox\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.pccomponentes.com/");
			//BUSCADOR
			WebElement buscadorPcComponents= driver.findElement(By.name("query"));
			//CADENA DE BÚSQUEDA
			String busqueda = telf + " " + marca + " " + modelo;
			buscadorPcComponents.sendKeys(busqueda);
			buscadorPcComponents.submit();
			//CONDICIÓN
			WebDriverWait waiting = new WebDriverWait(driver, 1000);
			waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ais-Hits')]")));
			
			
			//DATOS
			List<WebElement> listaElementos = driver.findElements(By.className("tarjeta-articulo__elementos-basicos"));
			System.out.println("Número de elementos de la lista: " + listaElementos.size());
			waitForPageLoaded(driver);
			
			// OBTENER CADA UNO DE LOS ARTÍCULOS
			String vendedor="Pc Componentes";
			String precioActual="";
			String precioAnterior="";
			String nombre;
			int j = 1;
			for (int i = 0; i < listaElementos.size(); i++) {
				try {
					precioActual= listaElementos.get(i).findElement(By.className("tarjeta-articulo__pvp")).getText();
					if(precioActual != null) {
						precioActPcComponentes= Double.parseDouble(precioActual.replace("€", "").replace(",","."));
					}
				}catch(Exception e) {
					if(precioActual != null) {
						precioAnterior=precioActual;
					}
					
					//precioAntPcComponentes= Double.parseDouble(precioAnterior.replace("€", "").replace(",","."));
				}
			    nombre = listaElementos.get(i).findElement(By.className("tarjeta-articulo__nombre")).getText();
				
			    /*if(nombre.trim().toLowerCase().contains(modelo.toLowerCase()) && nombre.trim().toLowerCase().contains(marca.toLowerCase())) {
					if(precioAntAmazon > 50 && precioActAmazon>50) {
						Smartphone smart = new Smartphone(nombre, precioActual, precioAnterior, vendedor);
						smartphones.add(smart);
					}
				}*/
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
			//System.out.println("Timeout waiting for Page Load Request to complete.");
		}
	}
}
