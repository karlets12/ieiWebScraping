package application;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	
	public void initialize() {
		stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("BUSCADOR");
		
		
	}
}
