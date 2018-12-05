package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import Logica.Gestor;
import Logica.Reloj;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {
    private ObservableList<Fila> data;
    private Gestor gestor;
    private Reloj reloj1;

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
    private Label txtOcioso_1;
    @FXML
    private Label txtOcioso_2;
    @FXML
    private Label txtEsperaMaxima;
    @FXML
    private TextField txtFilaDesde;
    @FXML
    private TextField txtFilaHasta;
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
    private TableColumn<Fila, String> tiempoMecanizadoTorno2;
    @FXML
    private TableColumn<Fila, String> proxFinAtencionTorno2;

    public void closeApp(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    private void clearItemsInTableView() {
        tvSim.getItems().clear();
    }

    public void setDiasSimulacion(){
        if (txtDiasASimular.getText() == null || txtDiasASimular.getText().trim().isEmpty()) {
            gestor.setDiasSimulacion(1);

        } else {
            gestor.setDiasSimulacion(Integer.valueOf(txtDiasASimular.getText()));
        }
    }

    public void setFilasMostrar(){
        if(txtFilaDesde.getText() == null || txtFilaDesde.getText().trim().isEmpty()){
            gestor.setFilaDesde(0);
            gestor.setFilaHasta(0);
        } else {
            gestor.setFilaDesde(Integer.valueOf(txtFilaDesde.getText()));
            gestor.setFilaHasta(Integer.valueOf(txtFilaHasta.getText()));
        }
    }

    public void cargarTabla() {

        this.gestor.inicio();

        setearColumnas();

        ObservableList<Fila> list = gestor.getData();

        tvSim.setItems(list);
    }

    private void resetSimulation() {
        Reloj.resetearReloj();
        this.gestor = new Gestor();
        this.setDiasSimulacion();
        this.setFilasMostrar();

        clearItemsInTableView();

        cargarTabla();
    }

    private void initializeNewSimulation() {

        this.resetSimulation();
    }

    public void setearColumnas(){
        dia.setCellValueFactory(new PropertyValueFactory<>("dia"));
        reloj.setCellValueFactory(new PropertyValueFactory<>("reloj"));
        event.setCellValueFactory(new PropertyValueFactory<>("event"));
        pieza.setCellValueFactory(new PropertyValueFactory<>("pieza"));
        rnd1.setCellValueFactory(new PropertyValueFactory<>("rnd1"));
        tiempoEntreLlegadas.setCellValueFactory(new PropertyValueFactory<>("tiempoEntreLlegadas"));
        proxFinAtencion.setCellValueFactory(new PropertyValueFactory<>("proxFinAtencion"));
        colaLlegadaPiezas.setCellValueFactory(new PropertyValueFactory<>("colaLlegadaPiezas"));
        estadoTorno1.setCellValueFactory(new PropertyValueFactory<>("estadoTorno1"));
        alimentadorTorno1_1.setCellValueFactory(new PropertyValueFactory<>("alimentadorTorno1_1"));
        alimentadorTorno1_2.setCellValueFactory(new PropertyValueFactory<>("alimentadorTorno1_2"));
        alimentadorTorno1_3.setCellValueFactory(new PropertyValueFactory<>("alimentadorTorno1_3"));
        rndTorno1.setCellValueFactory(new PropertyValueFactory<>("rndTorno1"));
        tiempoMecanizadoTorno1.setCellValueFactory(new PropertyValueFactory<>("tiempoMecanizadoTorno1"));
        proxFinAtencionTorno1.setCellValueFactory(new PropertyValueFactory<>("proxFinAtencionTorno1"));
        estadoTorno2.setCellValueFactory(new PropertyValueFactory<>("estadoTorno2"));
        alimentadorTorno2_1.setCellValueFactory(new PropertyValueFactory<>("alimentadorTorno2_1"));
        alimentadorTorno2_2.setCellValueFactory(new PropertyValueFactory<>("alimentadorTorno2_2"));
        alimentadorTorno2_3.setCellValueFactory(new PropertyValueFactory<>("alimentadorTorno2_3"));
        tiempoMecanizadoTorno2.setCellValueFactory(new PropertyValueFactory<>("tiempoMecanizadoTorno2"));
        proxFinAtencionTorno2.setCellValueFactory(new PropertyValueFactory<>("proxFinAtencionTorno2"));
    }

    @FXML
    void simulacionOnAction(ActionEvent event) {
        this.initializeNewSimulation();
        this.setStats();
    }

    private void setStats(){
        txtOcioso_1.setText(gestor.setTiempoOcioso1());
        txtOcioso_2.setText(gestor.setTiempoOcioso2());
        txtEsperaMaxima.setText(gestor.setEsperaMaxima());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
