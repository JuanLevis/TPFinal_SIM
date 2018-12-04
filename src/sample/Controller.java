package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import Logica.Gestor;
import Logica.Reloj;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
    private ObservableList<Fila> data;
    private Gestor gestor;
    private Reloj reloj1;

    //TODO: Consultar a Lupo sobre los labels que faltan y la tabla sin scroll
    public Controller() {
        this.gestor = new Gestor();
        this.reloj1 = Reloj.getInstancia();
        this.tvSim = new TableView<Fila>();
    }

    @FXML
    private Button btnSimular;
    @FXML
    private TextField txtDiasASimular;
    @FXML
    private TableView<Fila> tvSim;
    @FXML
    private TableColumn<Fila, String> dia;
    @FXML
    private TableColumn<Fila, String> reloj;
    @FXML
    private TableColumn<Fila, String> event;
    @FXML
    private TableColumn<Fila, String> pieza;
    @FXML
    private TableColumn<Fila, String> rnd1;
    @FXML
    private TableColumn<Fila, String> tiempoEntreLlegadas;
    @FXML
    private TableColumn<Fila, String> proxFinAtencion;
    @FXML
    private TableColumn<Fila, String> colaLlegadaPiezas;
    @FXML
    private TableColumn<Fila, String> estadoTorno1;
    @FXML
    private TableColumn<Fila, String> alimentadorTorno1_1;
    @FXML
    private TableColumn<Fila, String> alimentadorTorno1_2;
    @FXML
    private TableColumn<Fila, String> alimentadorTorno1_3;
    @FXML
    private TableColumn<Fila, String> rndTorno1;
    @FXML
    private TableColumn<Fila, String> tiempoMecanizadoTorno1;
    @FXML
    private TableColumn<Fila, String> proxFinAtencionTorno1;
    @FXML
    private TableColumn<Fila, String> estadoTorno2;
    @FXML
    private TableColumn<Fila, String> alimentadorTorno2_1;
    @FXML
    private TableColumn<Fila, String> alimentadorTorno2_2;
    @FXML
    private TableColumn<Fila, String> alimentadorTorno2_3;
    @FXML
    private TableColumn<Fila, String> rndTorno2;
    @FXML
    private TableColumn<Fila, String> tiempoMecanizadoTorno2;
    @FXML
    private TableColumn<Fila, String> proxFinAtencionTorno2;

    public void closeApp(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public void setDiasSimulacion(){
        if (txtDiasASimular.getText() == null || txtDiasASimular.getText().trim().isEmpty()) {
            gestor.setDiasSimulacion(1);

        } else {
            gestor.setDiasSimulacion(Integer.valueOf(txtDiasASimular.getText()));
        }
    }

    @FXML
    void simulacionOnAction(ActionEvent event) {
        this.gestor.cargarFilaPrimeravez();
        //this.initializeNewSimulation(true);
        //this.setStats();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
