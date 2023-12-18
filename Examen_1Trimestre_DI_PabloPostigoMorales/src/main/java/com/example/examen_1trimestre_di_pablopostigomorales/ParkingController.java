package com.example.examen_1trimestre_di_pablopostigomorales;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Date;

public class ParkingController
{
    @FXML
    private TableView tablaView;
    @FXML
    private TableColumn tablaMatricula;
    @FXML
    private TableColumn tablaModelo;
    @FXML
    private TableColumn tablaFecEntrada;
    @FXML
    private TableColumn tablaFecSalida;
    @FXML
    private TableColumn tablaCliente;
    @FXML
    private TableColumn tablaTarifa;
    @FXML
    private TableColumn tablaCoste;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnLogOut;
    @FXML
    private TextField txtMatricula;
    @FXML
    private ChoiceBox cbModelo;
    @FXML
    private ChoiceBox cbCliente;
    @FXML
    private DatePicker dpEntrada;
    ArrayList<Cliente>clientes = new ArrayList<>();
    @FXML
    private RadioButton rbStandard;
    @FXML
    private RadioButton rbOferta;
    @FXML
    private RadioButton rbLarDuracion;
    @FXML
    private Label lblCoste;
    private ToggleGroup toggleGroup;

    @FXML
    public void initialize() {
        ArrayList<String>nombreClientes = new ArrayList<>();
        for (Cliente cliente : clientes) {
            cliente.getNombre();
        }
        cbCliente.getItems();

    }

    @FXML
    public void addNewEntry(ActionEvent actionEvent) {
        String matricula ="";
        Cliente cliente = null;
        String modelo = "";
        String tarifa = "";
        Date fechaEntrada = null;
        Date fechaSalida = null;

        try {
            matricula = txtMatricula.getText();
            if (clientes.size()==0){
                cliente.setId(1);
            }else cliente.setId(clientes.size()+1);
            cliente.setNombre((String) cbCliente.getSelectionModel().getSelectedItem());
            cliente.setCorreo(cliente.getNombre()+"@gmail.com");
            clientes.add(cliente);
            modelo = (String) cbModelo.getSelectionModel().getSelectedItem();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ERROR: Los campos no estan completos, la introducción no se añadirá a la tabla");
        }
    }

    @FXML
    public void logOut(ActionEvent actionEvent) {
    }
}