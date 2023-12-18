package com.example.examen_1trimestre_di_pablopostigomorales;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
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
    private ToggleGroup toggleGroup = new ToggleGroup();
    int multi =8;
    int tiempo;
    @FXML
    private DatePicker dpSalida;
    private String tarifaSelec = "Standard";


    @FXML
    public void initialize() {
        dpEntrada.valueProperty().addListener((ov, oldValue, newValue) -> {
            getCosto();
        });
        dpSalida.valueProperty().addListener((ov, oldValue, newValue) -> {
            getCosto();
        });


        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)toggleGroup.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();
                    System.out.println(s);
                    switch (s){
                        case "Standard":
                            multi = 8;
                            tarifaSelec="Standard";
                            break;
                        case "Larga duracion":
                            multi = 2;
                            tarifaSelec="Larga duracion";
                            break;
                        case "Oferta":
                            multi = 6;
                            tarifaSelec="Oferta";
                            break;
                    }
                    getCosto();
                }
            }
        });

        //Creacion de datos dummy
        ArrayList<String> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente(1,"Juan","juan@gmail.com");
        Cliente cliente2 = new Cliente(2,"Carlos","carlos@gmail.com");
        Cliente cliente3 = new Cliente(1,"Paco","paco@gmail.com");
        clientes.add(cliente1.getNombre());
        clientes.add(cliente2.getNombre());
        clientes.add(cliente3.getNombre());
        ArrayList<String>marcas = new ArrayList<>();
        Coche coche1 = new Coche("31054A","Seat",cliente1);
        Coche coche2 = new Coche("54585J","Ferrari",cliente2);
        Coche coche3 = new Coche("46451P","Ford",cliente3);
        marcas.add(coche1.getModelo());
        marcas.add(coche2.getModelo());
        marcas.add(coche3.getModelo());

        ElementoTabla elemento1 = new ElementoTabla("123456E","Seat",new Date(),new Date(18 / 2024),cliente1.getNombre(),"Standard",800);
        ElementoTabla elemento2 = new ElementoTabla("123456E","Seat",new Date(),new Date(18 / 2024),cliente1.getNombre(),"Standard",800);
        ElementoTabla elemento3 = new ElementoTabla("123456E","Seat",new Date(),new Date(18 / 2024),cliente2.getNombre(),"Standard",800);

        ArrayList<ElementoTabla> lista = new ArrayList<>();
        lista.add(elemento1);
        lista.add(elemento2);
        lista.add(elemento3);

        rbOferta.setToggleGroup(toggleGroup);
        rbStandard.setToggleGroup(toggleGroup);
        rbLarDuracion.setToggleGroup(toggleGroup);


        tablaMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        tablaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tablaFecEntrada.setCellValueFactory(new PropertyValueFactory<>("fechEntrada"));
        tablaFecSalida.setCellValueFactory(new PropertyValueFactory<>("fechSalida"));
        tablaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        tablaTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa"));
        tablaCoste.setCellValueFactory(new PropertyValueFactory<>("coste"));


        ObservableList<ElementoTabla> listaObjetos  = FXCollections.observableList(lista);
        tablaView.setItems(listaObjetos);
        tablaView.getSelectionModel().clearAndSelect(0);
        cbModelo.setItems(FXCollections.observableList(marcas));
        cbModelo.setValue(marcas.get(0));
        cbCliente.setItems(FXCollections.observableList(clientes));
        cbCliente.setValue(clientes.get(0));




    }

    private Integer getCosto () {
        if (dpSalida.getValue() != null && dpEntrada.getValue() != null) {
            int coste = 0;
            LocalDate fechaEntrada = dpEntrada.getValue();
            LocalDate fechaSalida = dpSalida.getValue();
            Period period = Period.between(fechaEntrada, fechaSalida);
            tiempo = period.getDays();
            if (tiempo >0) {
                System.out.println(period);

                coste = tiempo * multi;
                System.out.println(coste);
                lblCoste.setText(String.valueOf(coste+"€"));
                return coste;
            }else {
                lblCoste.setText(String.valueOf(0+"€"));
                return 0;
            }
        }else {
            lblCoste.setText(String.valueOf(0+"€"));
            return 0;
        }

    }

    @FXML
    public void addNewEntry(ActionEvent actionEvent) {
        ZoneId defaultZoneId = ZoneId.systemDefault();

        String matricula = txtMatricula.getText();
        String cliente = (String) cbCliente.getSelectionModel().getSelectedItem();
        String modelo =(String) cbModelo.getSelectionModel().getSelectedItem();
        Date fechaEntrada = Date.from(dpEntrada.getValue().atStartOfDay(defaultZoneId).toInstant());
        Date fechaSalida = Date.from(dpSalida.getValue().atStartOfDay(defaultZoneId).toInstant());

        ElementoTabla elementoTabla = new ElementoTabla(matricula,modelo,fechaEntrada,fechaSalida,cliente,tarifaSelec,Integer.parseInt(lblCoste.getText().substring(0, lblCoste.getText().length()-1)));
        tablaView.getItems().add(elementoTabla);
        tablaView.refresh();
    }

    @FXML
    public void logOut(ActionEvent actionEvent) {
        System.exit(0);
    }
}