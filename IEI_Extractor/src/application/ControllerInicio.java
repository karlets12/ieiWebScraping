package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

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
    	compruebaCheckBox();
    	
    }
	
	
	public void compruebaCheckBox() {
		if (amazonCheck.isSelected()) {
    		System.out.print("amazon funciona");
    	}
    	if(fnacCheck.isSelected()) {
    		
    	}
    	if(pcComponentsCheck.isSelected()) {
    		
    	}
	}
	
	
}
